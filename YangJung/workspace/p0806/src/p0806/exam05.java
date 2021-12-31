package p0806;

import java.util.Scanner;

public class exam05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int age;
		System.out.print("나이를 입력하세요 : ");
		age=s.nextInt();	
		if(age>=19) {
			System.out.print("성년");
		}
		else {
			System.out.print("미성년");	
		}
	}

}
