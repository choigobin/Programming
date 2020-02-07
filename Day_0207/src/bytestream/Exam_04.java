package bytestream;
import java.io.*;
public class Exam_04 {
	public static void main(String[] args) throws Exception {
		File file = new File("..\\data\\work\\data1.txt");
		FileInputStream fos = new FileInputStream(file);
		BufferedInputStream bos = new BufferedInputStream(fos);
		DataInputStream dos = new DataInputStream(bos);
		
		int a = dos.readInt();
		double d = dos.readDouble();
		byte[] b = new byte[10];
		dos.read(b);
		
		System.out.println("a = "+a);
		System.out.println("d = "+d);
		System.out.println("b = "+new String(b));

		
	}
}
