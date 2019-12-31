/*	반복문 // 조건식 = 참,거짓
 * 	1. while(조건식){	}
 * 	2. do{	}while(조건식)
 * 	3. for(변수=초기값;조건식;증감식){	}
 */
public class Exam_04 {
	public static void main(String[] args) {
		int x=0;
		while(true) {//무한반복
			System.out.println("x = "+ x);
			x++;
			if(x==10) {
				break;
			}
		}
		int y=0;
		while(y<10) {
			System.out.println("y = "+ y);
			y++;
		}
		int z=0;
		do {
			System.out.println("z = "+ z);
			z++;
		}while(z==10);
		
		
		
	}
}
