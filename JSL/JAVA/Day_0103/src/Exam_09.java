/*	*****		    *
 * 	*****		   **
 * 	*****		  ***
 * 	*****		 ****
 * 	*****		*****
 */
public class Exam_09 {
	public static void main(String[] args) {
		for(int x=1;x<=5;x++) {
			for(int y=1;y<=5;y++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for(int x=1;x<=5;x++) {
			for(int k=5;k>x;k--) {
				System.out.print(" ");
			}
			for(int y=1;y<=x;y++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for(int x=1;x<=5;x++) {
			for(int k=5-x;k>0;k--) {
				System.out.print(" ");
			}
			for(int y=1;y<=x;y++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
	}
}
