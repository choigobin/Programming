package p0802;

import java.util.Scanner;

public class exam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int x;
		int y;
		System.out.print("첫 번째 정수를 입력하세요. : ");
		x= s.nextInt();
		System.out.print("두 번째 정수를 입력하세요. : ");
		y= s.nextInt();
		if(x>y) {
			System.out.println("큰 수는 "+x);
		}
		else if(x==y){
			System.out.println("두 수는 같다.");
		}
		else {
			System.out.println("큰 수는 "+y);
		}
	}

}
