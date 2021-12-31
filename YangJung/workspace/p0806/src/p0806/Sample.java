package p0806;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int i=1, dan;
		System.out.print("출력할 단을 입력하세요 : ");
		dan=s.nextInt();
		do {
			System.out.printf("%d*%d=%d\n5",dan,i,dan*i);
			i++;
		}while(i<=9);
			
		
	}

}
