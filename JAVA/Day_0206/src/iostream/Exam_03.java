package iostream;
import java.io.*;
public class Exam_03 {
	public static void main(String[] args) {
		File f = new File("..\\data\\work\\test.txt");
		if(f.exists()) {
			f.deleteOnExit();//종료시 삭제
			System.out.println("파일명 : "+f.getName());
			System.out.println("파일경로 : "+f.getPath());
			System.out.println("파일경로 : "+f.getParent());
			System.out.println("파일크기 : "+f.length());
			System.out.println("최종수정일 : "+f.lastModified());

		}else {
			System.out.println(f.getName()+"가 없음");
		}
		
		
		
	}
}
