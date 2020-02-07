package textstream;

import java.io.*;
import java.util.TreeSet;

/*	파일로 부터 입력(data.txt)
 * 	출력 예시(파일 출력:dataout.txt, 콘솔 출력)
 * 	번호	이름		성별	국어	영어	수학	총점	평균
 * 	1	홍길동	남자	78	88	90	256	85.33
 */
public class StudentExam {
	public static void main(String[] args) throws IOException {
		//파일 읽기(입력)
		File file = new File("..\\data\\work\\data.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		TreeSet<Student> list = new TreeSet<Student>();
		for(;;) {
			String str = br.readLine();
			if(str==null) {break;}
			String[] s = str.split(",");
			list.add(new Student(Integer.parseInt(s[0]),s[1],s[2],Integer.parseInt(s[3]),Integer.parseInt(s[4]),Integer.parseInt(s[5])));
		}
		br.close();
		//데이터 수정
		StudentData stData = new StudentData(list);
		String[] data = stData.outPut();
		//파일 저장(출력)
		File fileX = new File("..\\data\\work\\dataX.txt");
		FileWriter fw = new FileWriter(fileX);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("번호\t이름\t성별\t국어\t영어\t수학\t총점\t평균");
		System.out.println("번호\t이름\t성별\t국어\t영어\t수학\t총점\t평균");
		bw.newLine();
		for(int i=0; i<data.length; i++) {
			bw.write(data[i]);
			bw.newLine();
			System.out.println(data[i]);
		}
		bw.close();
	}
}
