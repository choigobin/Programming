package p0806;

import java.util.Scanner;

public class exam11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x;
		System.out.print("처리할 수를 입력하세요 : ");
		x=s.nextInt();
		if(x>0) {
			System.out.print("입력한 수는 + 입니다.");
		}
		if(x==0) {
			System.out.print("입력한 수는 0 입니다.");
		}
		if(x<0) {
			System.out.print("입력한 수는 - 입니다.");
		}
	
	}
}
