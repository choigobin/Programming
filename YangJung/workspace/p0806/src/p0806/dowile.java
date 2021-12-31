package p0806;

import java.util.Scanner;

public class dowile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
	int x;
	do {
		System.out.println("<1>카페라떼 <2>카푸치노 <3>아메리카노 <4>그만시킬래요 ==> ");
		x=s.nextInt();
		if(x==1) {System.out.println("#카페라떼 주문하셨습니다.");}
		if(x==2) {System.out.println("#카푸치노 주문하셨습니다.");}
		if(x==3) {System.out.println("#아메리카노 주문하셨습니다.");}
		if(x==4) {System.out.println("주문하신 커피 준비하곘습니다.");}
		System.out.println("");
	}while(x<4);
	
	}

}
