package net.webmvc.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;


public class FileUp{
	private Hashtable parameters = new Hashtable();			// 변수 기억용
	private Hashtable fileParameters = new Hashtable();		// 화일변수 기억용
	private Vector vc = new Vector();						// 임시벡터 사용
	private DataInputStream servletIn = null;				// 데이터 저장용
	private FileOutputStream fileOut = null;				// 파일 출력용
	private File saveFile = null;							// 파일 저장시 경로명 포함할 File변수
	private String fileName = null;							// 파일 이름 기억용
	private long maxFileSize = 1024*1024*3;					// 기본 업로드 용량(초기값 3M)
	private long contentLength = 0;							// 데이터 용량 기억용
	private String bound = "";								// 변수값 구분자 저장용
	private String saveDir = "";							// 파일 저장 경로명 저장용
	private final String nameHeader = new String("Content-Disposition: form-data; name=");
																																								// 기본 헤더 문구 선언용
	// 객체 생성시
	public FileUp() { }

	// 객체 생성시 기본 업로드 용량 설정 (M 단위)
	public FileUp(int fileSize) {
		this.maxFileSize = (long)(fileSize*1024*1024);
	}

	// 데이터 업로드 용량 설정 함수
	public void setMaxFileSize(int fileSize){
		this.maxFileSize = (long)(fileSize*1024*1024);
	}

	// 파일 저장 경로 설정하기
	public void setSaveDir(String dir){
		File createDir = new File(dir);
		if(!createDir.exists()) createDir.mkdirs();							// 폴더 없을시 생성
		char otherSeparator;
		otherSeparator = File.separatorChar == '/' ? '\\' : '/';			// 경로 구분자 바꾸기
		this.saveDir = dir.replace(otherSeparator, File.separatorChar);
	}

	// 데이터 받고 용량 검사 및 변수 추출
	public void getRequest(HttpServletRequest req) throws Exception{
		try{
			servletIn = new DataInputStream(req.getInputStream());
			bound = getBoundary(req.getContentType());						// 변수 구분자 추출
			contentLength = req.getContentLength();							// 데이터 용량 저장
			makeParameters();												// 변수 추출 함수 호출
		}
		finally {														// 항상 실행시킬때
			try{servletIn.close();}
			catch(Exception ex){}
		}
	}

	// 변수 구분자 생성 함수
	private String getBoundary(String line) throws Exception{
		int from = line.indexOf("boundary=");
		return ("--"+line.substring(from+9));
	}

	// 변수 추출 함수
	private void makeParameters() throws Exception {
		String line = "";
		String subLine = "";
		try	{
			servletIn.readLine();
			while(true){
				if((line = servletIn.readLine()) == null) break;
				if(line.indexOf(nameHeader) != -1){
					subLine = servletIn.readLine();
					if(subLine.indexOf("Content-Type") != -1){		 // 파일시작부분 검사
						saveFile(line);								// 파일 추가 함수 호출
						servletIn.readLine();
					}	 else addParameter(line);					 // 변수 추가 함수 호출
				}
			}
		}
		finally { }
	}

	// 변수 추가 함수
  private void addParameter(String line) throws Exception{
    String pName = line.substring(38,line.length()-1);		// 변수명 추출
    String pValue = "";										// 변수값 저장 변수
    StringBuffer imsi = new StringBuffer();					// 변수값 임시 저장변수

    while((pValue = servletIn.readLine()) !=null){			// 변수값 추출 부분
      if(pValue.indexOf(bound)!= -1) break;
      else imsi.append(pValue+"\n");
    }
    parameters.put(pName,new String(imsi.toString().trim()));  // 변수이름과 값 저장
  }

	// 변수 호출 함수
	public String getParam(String pkey) throws Exception{
		if(!parameters.containsKey(pkey)){								// 변수 없을시 에러 발생
			throw new Exception("Input Parameter Name Error! name:"+pkey);
		}
		return parameters.get(pkey).toString();					// 변수값 반환
	}

	// 파일 추가 함수
	private void saveFile(String line) throws Exception{
		byte[] buffer=new byte[1024];		// 임시 버퍼 (한줄 최대 길이)
		byte ch;
		long gfilesize = 0;												// 파일 실제 사이즈 저장 변수
		int lineNum = 0;
		int x=0;

		String pName = line.substring(38,line.lastIndexOf(";")-1);
		if((lineNum = line.indexOf(" filename=")) != -1){								// 파일이름 검사
			fileName = line.substring(line.lastIndexOf(";")+12,line.length()-1);		// 경로 포함한 파일 이름 추출
			if(fileName == null || fileName.trim().equals("")){							// 경로 포함한 파일 이름 없을때
				fileParameters.put(pName,"");
				fileParameters.put(pName+"_size","0");
				return;
			}
			fileName = new String(fileName.substring(fileName.lastIndexOf("\\")+1));		// 파일 이름 추출
			if(fileName == null || fileName.trim().equals("")){								// 경로만 존재할때
				fileParameters.put(pName,"");
				fileParameters.put(pName+"_size","0");
				return;
			}
		} else return;

    existCheck();								// 파일 생성 함수 호출
    
    fileOut = new FileOutputStream(saveFile);
    servletIn.readLine();

		while(true){								 // 파일 실제 데이터 읽어서 저장하는 부분
			buffer[x++] = ch = servletIn.readByte();
			gfilesize++;

			fileSizeCheck(gfilesize);			// 파일 사이즈 체크

			if(x == bound.length() + 1){
				int y = 0;
				String end2 = new String(buffer,0,x);
				y = end2.indexOf(bound);
				if(y != -1){
					x = y;
					if(x != 0)fileOut.write(buffer,0,x-1);
					break;
				}
			}else{
				if(x == 1023 || ch == '\n'){
					fileOut.write(buffer,0,x);
					x = 0;
				}
			}
		}
		fileOut.close();

		// 파일 이름과 파일 크기 변수로 저장
		fileParameters.put(pName,fileName);
		fileParameters.put(pName+"_size",Long.toString(gfilesize));
	}

	// 파일 저장용 함수 (파일 생성 부분)
  private void existCheck() throws Exception{
    String fileFullName = saveDir + Han.toHan(fileName);		// 파일 이름 조합
    saveFile = new File(fileFullName);						// 파일 생성
    if(saveFile.exists()) fileRename();						// 파일이 존재할때 새로운 이름으로 생성
		vc.addElement(saveFile);							// 에러발생시 파일 삭제할때 쓰임
  }

	// 파일변수 호출 함수
	public String getFileParam(String pkey) throws Exception{
		if(!fileParameters.containsKey(pkey)){								// 변수 없을시 에러 발생
			throw new Exception("Input Parameter Name Error! name:"+pkey);
		}
		return fileParameters.get(pkey).toString();					// 변수값 반환
	}

	// 파일 존재시 새로운 이름으로 생성
	private void fileRename() throws Exception{
		while(true){
			fileName = "imsi_"+fileName;
			saveFile = new File(saveDir + Han.toHan(fileName));
			if(!saveFile.exists()) break;
		}
	}

	// 파일 사이즈 체크후 용량 초과시 기존 파일까지 삭제
	private void fileSizeCheck(long filesize) throws Exception{
		if(maxFileSize <= filesize){
			fileOut.close();
			servletIn.close();
			if(saveFile.exists()) saveFile.delete();
			if(!vc.isEmpty()){
				for(int i=0 ; i<vc.size() ; i++){
					File delFile = (File)vc.elementAt(i);
					if(delFile.exists()) delFile.delete();
				}
				vc = null;
			}
			throw new IOException("File size error["+(maxFileSize/1024/1024)+"M]");
		}
	}

}