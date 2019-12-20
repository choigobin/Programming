/* 1)*****	2)*		3)*****	4)    *	5)*****
 * 	 *****	  **	  ****	     **	   ****
 * 	 *****	  ***	  ***	    ***	    ***
 *   *****	  ****	  **	   ****	     **
 *   ***** 	  *****	  *		  *****	      *
 */
public class Exam_07 {
	public static void main(String[] args) {
		int i,j;
		
		 System.out.println("1)");
		 for(i=1; i<=5;i++) { //還熱
			for(j=1;j<6;j++) { //還渡 蘊熱
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
		System.out.println("2)");
		for(i=1;i<6;i++) {
			for(j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("3)");
		for(i=5;i>0;i--) {
			for(j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("4)");
		for(i=1;i<6;i++) {
			for(int k=5;k>i;k--) {
				System.out.print(" ");
			}
			for(j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("5)");
		for(i=1;i<6;i++) {
			for(j=1;j<i;j++) {
				System.out.print(" ");
			}
			for(int k=6;k>i;k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
