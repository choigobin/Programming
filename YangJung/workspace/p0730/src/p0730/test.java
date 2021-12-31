package p0730;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Hellow World");
	System.out.println("I am New Java Programmer");
	Scanner scan = new Scanner(System.in);
	long num1;
	double num2;
	double num3;
	double pie=3.14;
	
	num1=30000;
	System.out.println("빛이 1년 동안 가는 거리 = "+num1*365*24*60*60);
	
	num2=5.0;
	System.out.println("원의 면적 = "+pie*Math.pow(num2, 2));
	
	System.out.print("원의 반지름을 입력하세요 :");
	num3=scan.nextDouble();
	System.out.println("원의 면적 = "+pie*Math.pow(num3, 2));
	}

}
