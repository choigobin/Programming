package p0806;

import java.util.Scanner;

public class exam04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x,a,b,c;
		System.out.print("0~999 사이의 숫자를 입력하세요 : ");
		x=s.nextInt();
		a=x/100;
		b=(x%100)/10;
		c=x%10;
		System.out.print("각 자리수의 합 = "+(a+b+c));
	}

}
