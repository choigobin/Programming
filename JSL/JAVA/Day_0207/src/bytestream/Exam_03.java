package bytestream;
import java.io.*;
public class Exam_03 {
	public static void main(String[] args) throws Exception {
		File file = new File("..\\data\\work\\data1.txt");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeInt(35);
		dos.writeDouble(3.14);
		dos.writeBytes("Seoul");
		dos.close();
		
	}
}
