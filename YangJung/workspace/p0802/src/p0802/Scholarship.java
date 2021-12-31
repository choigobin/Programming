package p0802;

import java.util.Scanner;

public class Scholarship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		float grade;
		System.out.print("성적을 입력하세요. : ");
		grade= s.nextFloat();
		
		if(grade>=4.0) {
			System.out.println("장학금 대상자입니다.");
		}
		else {
			System.out.println("장학금 대상자가  아닙니다.");
		}
	}

}
