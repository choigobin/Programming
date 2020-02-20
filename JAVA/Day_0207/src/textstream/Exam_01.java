package textstream;

import java.io.*;

/*	텍스트 입출력
 * 		Reader		 / Writer
 * 	----------------
 * 	InputSteamReader / OutputStreamWriter	--> 콘솔 입출력
 * 	FileReader		 / FileWriter			--> 파일 입출력
 * 	BufferedReader	 / BufferedWriter		--> 필터역할
 * 					 / PrintWriter			--> 필터역할
 */
public class Exam_01 {
	public static void main(String[] args) throws IOException {
		File file = new File("..\\data\\work\\data2.txt");
		// 콘솔 출력
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw);
		pw.println("화면 출력 테스트 입니다");
		pw.close();
		
		PrintWriter pwf = new PrintWriter(new BufferedWriter(new FileWriter(file))); 
		pwf.println("파일 출력 테스트");
		pwf.close();
		
	}
}
