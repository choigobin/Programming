package p0802;

import java.util.Scanner;

public class exam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int month;
		System.out.print("1~12까지 입력하세요.: ");
		month=s.nextInt();
		
		switch(month) {
		
		case 1:
			System.out.println("1월");
			break;
		case 2:
			System.out.println("2월");
			break;
		case 3:
			System.out.println("3월");
			break;
		case 4:
			System.out.println("4월");
			break;
		case 5:
			System.out.println("5월");
			break;
		case 6:
			System.out.println("6월");
			break;
		case 7:
			System.out.println("7월");
			break;
		case 8:
			System.out.println("8월");
			break;
		case 9:
			System.out.println("9월");
			break;
		case 10:
			System.out.println("10월");
			break;
		case 11:
			System.out.println("11월");
			break;
		case 12:
			System.out.println("12월");
			break;
		default:
			System.out.println("잘못된 값");
		}
	}

}
