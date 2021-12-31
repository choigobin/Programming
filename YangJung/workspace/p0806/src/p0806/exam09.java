package p0806;

import java.util.Scanner;

public class exam09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x,y;
		String Fuc;
		System.out.print("첫 번째 게산할 값을 입력하세요 ==> ");
		x=s.nextInt();
		System.out.print("+ - * / % ==> ");
		Fuc=s.next();
		System.out.print("두 번째 게산할 값을 입력하세요 ==> ");
		y=s.nextInt();
		
		switch(Fuc) {
		
		case "+":
			System.out.print(x+"+"+y+"="+(x+y));
			break;
		case "-":
			System.out.print(x+"-"+y+"="+(x-y));
			break;
		case "*":
			System.out.print(x+"*"+y+"="+(x*y));
			break;
		case "%":
			System.out.print(x+"%"+y+"="+(x%y));
			break;
		case "/":
			if(y==0) {System.out.print("0으로 나누면 안됩니다.");}
			else {System.out.print(x+"/"+y+"="+(x/y));}
			break;
		}
				
	}
}
