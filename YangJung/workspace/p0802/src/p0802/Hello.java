package p0802;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* int num1; //byte는 -127~127까지 표현 
		int num2;
		int result;
		num1=100;
		num2=200;
		result=num1+num2;
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		System.out.println("num1 + num2 : "+result);
		result=num1-num2;
		System.out.println("num1 - num2 : "+result);
		result=num1*num2;
		System.out.println("num1 * num2 : "+result);
		result=num1/num2;
		System.out.println("num1 / num2 : "+result);
		result=num1%num2;
		System.out.println("num1 % num2 : "+result);
		
		final double pie = 3.14;
		double area;
		double r=5.0;
		
		area=pie*r*r;
		System.out.println(area);
		r=10.0;
		System.out.println(area);
		System.out.println(r);
		
		int x=1;
		System.out.println("x = "+ ++x);
		System.out.println("x = "+ ++x);
		System.out.println("x = "+ x++);
		System.out.println("x = "+ x);
		
		int y=5;
		System.out.println("y = "+ y);
		y=10;
		System.out.println("y = "+ y);
		System.out.println("x=y "+ (x==y)); */
		int num1;
		int num2;
		int result;
		Scanner s = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 입력 : ");
		num1 = s.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		num2 = s.nextInt();
		result=num1+num2;
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		System.out.println("num1 + num2 : "+result);
		result=num1-num2;
		System.out.println("num1 - num2 : "+result);
		result=num1*num2;
		System.out.println("num1 * num2 : "+result);
		result=num1/num2;
		System.out.println("num1 / num2 : "+result);
		result=num1%num2;
		System.out.println("num1 % num2 : "+result);
	}

}
