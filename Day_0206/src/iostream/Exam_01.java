package iostream;
/*	입출력 스트림
 * 	바이트 방식 => InputStream, OutputStream
 * 	문자(text) 방식 => Reader, Writer
 */
import java.io.*;
public class Exam_01 {
	public static void main(String[] args) {
		File f = new File("data\\work");
		if(f.exists()) {
			f.delete();
			System.out.println("삭제");
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}
		System.out.println("시작");
		if(!f.exists()) {
			f.mkdir();
			System.out.println("생성");
		}
		
		
	}
}
