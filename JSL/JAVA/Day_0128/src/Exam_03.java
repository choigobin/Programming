import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*	Scanner
 * 	
 */
public class Exam_03 {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner sc = new Scanner(System.in);
		Scanner scF = new Scanner(new File("test.txt"));
		while(scF.hasNext()) {
			System.out.println(scF.nextLine());
		}
		scF.close();
	}

}
