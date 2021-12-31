package p0802;

import java.util.Scanner;

public class exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int number;
		System.out.print("정수를 입력하세요. : ");
		number= s.nextInt();
		
		if(number>=90) {
			System.out.println("A학점");
		}
		else if(number>=80){
			System.out.println("B학점");
		}
		else if(number>=70){
			System.out.println("C학점");
		}
		else if(number>=60){
			System.out.println("D학점");
		}
		else {
			System.out.println("F학점");
		}
		
	}

}
