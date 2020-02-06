package iostream;
import java.io.*;
public class Exam_02 {
	public static void main(String[] args) {
		File f = new File("data\\work");
		if(!f.exists()) {
			f.mkdir();
			System.out.println("생성");
		}
		File f1 = new File(f,"test.txt");
		if(!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (IOException e) {}
		}
		
	}
}
