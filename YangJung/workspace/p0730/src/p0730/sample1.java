package p0730;

import java.util.Scanner;

public class sample1 {

	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		
		int num1;
		int num2;
		int result;// int num1,num2,result;
		
		System.out.print("첫번째 수를 입력하세요 :");
		num1=scan.nextInt();
		System.out.print("두번째 수를 입력하세요 :");
		num2=scan.nextInt();
		
		
		result=num1+num2;
		System.out.println(num1+"+"+num2+"="+result);
		
		result=num1-num2;
		System.out.println(num1+"-"+num2+"="+result);
		
		result=num1*num2;
		System.out.println(num1+"*"+num2+"="+result);
		
		result=num1/num2;
		System.out.println(num1+"/"+num2+"="+result);
		
		result=num1%num2;
		System.out.println(num1+"%"+num2+"="+result);
	}

}
