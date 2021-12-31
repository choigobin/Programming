package p0802;

import java.util.Scanner;

public class DetermineGraduation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x,y;
		
		System.out.print("총 이수학점을 입력하세요: ");
		x= s.nextInt();
		System.out.print("TOEIC 점수를 입력하세요: ");
		y= s.nextInt();
		if(x>=140 && y>=700) {
			System.out.println("졸업을 축하합니다.");
		}
		else if(x>=140) {
			System.out.println("아쉽지만 수료하셨습니다.");
		}
		else {
			System.out.println("졸업이 불가합니다.");
		}
	}

}
