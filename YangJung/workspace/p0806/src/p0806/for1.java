package p0806;

import java.util.Scanner;

public class for1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int i,dan,j;
		
		System.out.print("출력할 단을 입력하세요 : ");
		//dan=s.nextInt();
		
		for(i=1;i<=9;i++) {
			System.out.printf("%d 단\n",i);
			for(j=1;j<=9;j++) {
				System.out.printf("%d*%d=%d ",i,j,i*j);
			}
			System.out.printf("\n");
		}
		
		
	}

}
