package p0806;

import java.util.Scanner;

public class exam07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		float x,y;
		System.out.print("두 개의 실수를 입력하세요.\n");
		x=s.nextFloat();
		y=s.nextFloat();
		System.out.println("두 수의 합은 "+(x+y)+" 입니다");
		System.out.println("두 수의 합은 "+(x+y)/2+" 입니다");
		
	}

}
