package p0802;

import java.util.Scanner;

public class Admission {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x,y;
		
		System.out.print("시험 점수를 입력하세요: ");
		x= s.nextInt();
		System.out.print("면접 점수를 입력하세요: ");
		y= s.nextInt();
		if(x>=80 && y>=60) {
			System.out.println("합격을 축하합니다.");
		}
		else {
			System.out.println("아쉽지만 불합격입니다.");
		}
	}

}
