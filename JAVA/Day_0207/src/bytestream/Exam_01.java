package bytestream;
/*	1Byte씩 입출력
 * 	1. 콘솔 출력
 * 		- FileOutputStream
 * 		- BufferedOutputStream
 * 		- DataOutputStream
 * 		- Write();
 */
import java.io.*;
public class Exam_01 {
	public static void main(String[] args) {
		File file = new File("..\\data\\work\\data.txt");
		try {
			FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
			FileOutputStream fosf = new FileOutputStream(file);
			byte[] data = {66,68,70,72,(byte)'!'};
			fos.write(data);
			fosf.write(data);
			fos.close();
			fosf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
