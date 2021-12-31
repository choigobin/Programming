package p0806;

import java.util.Scanner;

public class exam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int sec,hour,min,x;
		System.out.print("초 단위의 정수를 입력하세요 : ");
		x=s.nextInt();
		hour=x/3600;
		min=(x%3600)/60;
		sec=x%60;
		System.out.printf("%d시간 %d분 %d초",hour,min,sec);
		
	}

}
