package p0802;

import java.util.Scanner;

public class exam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int x;
		int y=1000;
		System.out.print("실적을 입력하세요(단위:만원)= ");
		x= s.nextInt();
		if(x>=y) {
			System.out.println("실적 달성");
			System.out.println("보너스 : "+(x-y)/10);
		}
		else {
			System.out.println("실적 달성실패");
		}
	}

}
