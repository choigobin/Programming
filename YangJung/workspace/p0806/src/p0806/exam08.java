package p0806;

import java.util.Scanner;

public class exam08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int grade;
		System.out.print("점수를 입력하세요 ==> ");
		grade=s.nextInt();	
		if(grade>=80) {
			System.out.print("축하합니다. 합격입니다.");
		}
		else {
			System.out.print("아쉽네요. 불합격입니다.");	
		}
	}

}
