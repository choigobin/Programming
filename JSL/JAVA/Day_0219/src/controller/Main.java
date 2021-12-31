package controller;

import java.util.Scanner;

import view.UI;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UI ui = new UI();
		System.out.println("도서대출 관리 프로그램");
		System.out.println("[1] 도서 대출 예약 등록");
		System.out.println("[2] 도서 대출 현황 조회");
		System.out.println("[3] 도서 대출 예약 수정");
		System.out.println("[4] 도서 대출 반납 등록");
		for(;;) {
			System.out.print("메뉴를 선택하세요(1 ~ 4) : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				ui.insert(sc);
				break;
			case 2:
				ui.select();
				break;
			case 3:
				System.out.print("대출번호 : ");
				int x = sc.nextInt();
				sc.nextLine();
				ui.update(sc, x);
				break;
			case 4:
				System.out.print("대출번호 : ");
				int y = sc.nextInt();
				sc.nextLine();
				ui.update2(sc, y);
				break;
			default:
				System.out.println("해당번호가 없음");
				continue;
			}
			if(menu==-1) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		sc.close();
		
		
	}
}
