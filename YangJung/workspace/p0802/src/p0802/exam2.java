package p0802;

import java.util.Scanner;

public class exam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int number;
		System.out.print("정수를 입력하세요. : ");
		number= s.nextInt();
		
		if(number%2==0) {
			System.out.println("짝수 입니다.");
		}
		else {
			System.out.println("홀수 입니다.");
		}
	}

}
