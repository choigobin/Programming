/*	1					             1		*****
 * 	2  3				          2  3		 ****
 * 	4  5  6				       4  5  6		  ***
 * 	7  8  9  10			    7  8  9 10		   **
 * 	11 12 13 14 15		11 12 13 14 15		    *	
 * 											   **
 * 	A					*********			  ***
 * 	AB					 *******			 ****
 * 	ABC					  *****				*****
 * 	~					   ***			
 * 	A~~~Z				    *
 */
public class Exam_11 {
	public static void main(String[] args) {
		//1
		int x=0;
		for(int i=1;i<=5;i++) {
			for(int y=0;y<i;y++) {
				x++;
				if(x<10) {
					System.out.print(x+"  ");
				}else {
					System.out.print(x+" ");
				}
				
			}
			System.out.println();
		}
		//2 A=65 Z=90
		for(int i=65;i<=90;i++) {
			for(int y=65;y<=i;y++) {
				System.out.print((char)y);
			}
			System.out.println();
		}
		//3
		x=0;
		int z=13;
		for(int i=1;i<=5;i++) {
			for(int k=0;k<z;k++) {
				System.out.print(" ");
			}
			z=13;		
			for(int y=0;y<i;y++) {
				x++;
				if(x<9) {
					System.out.print(x+"  ");
					z-=3;
				}else {
					System.out.print(x+" ");
					z-=4;
				}
			}
			System.out.println();
		}
		//4
		z=0;
		for(int i=0;i<5;i++) {
			for(int k=0;k<i;k++) {//0 1 3 4 5
				System.out.print(" ");
			}
			for(int y=9;y>z;y--) {//9 7 5 3 1
				System.out.print("*");
			}
			z+=2;
			System.out.println();
		}
		//5
		for(int i=0;i<9;i++) {
			if(i<5) {
				for(int k=0; k<i; k++) {//0 1 2 3 4
					System.out.print(" ");
				}
				for(int y=5;y>i;y--) {
					System.out.print("*");
				}
			}else {
				for(int k=8; k>i; k--) {//3 2 1 0
					System.out.print(" ");
				}
				for(int y=3;y<i;y++) {
					System.out.print("*");
					}
			}
			System.out.println();
		}
		
		
		
		

	}
}
