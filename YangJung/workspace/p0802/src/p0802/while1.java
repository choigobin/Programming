package p0802;

import java.util.Scanner;

public class while1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n;
		int i=1;
		System.out.print("구구단 중에서 출력하고 싶은 단을 입력하시오 : ");
		n=s.nextInt();
		
		while(i<=9) {
			System.out.println(n+"*"+i+" = "+n*i);
			i++;
			
		}
	
	}

}
