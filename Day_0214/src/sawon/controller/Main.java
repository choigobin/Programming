package sawon.controller;

import java.io.IOException;
import java.util.Scanner;

import sawon.view.UI;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("==================================");
		System.out.println("=    사원&부서관리 프로그램 ver 1.0    =");
		System.out.println("==================================");
		System.out.println("     [1] 사원 전체 목록");
		System.out.println("     [2] 신규 사원 등록");
		System.out.println("     [3] 사원 검색");
		System.out.println("     [4] 사원 정보 수정");
		System.out.println("     [5] 사원 정보 삭제");
		System.out.println("     [6] 프로그램 종료");
		System.out.println("----------------------------------");
		UI ui = new UI();
		Scanner scn = new Scanner(System.in);
		for(;;) {
			System.out.println("  해당항목을 선택하세요 ?");
			System.out.println("==================================");
			int menu = scn.nextInt();
			switch(menu) {
			case 1:
				if(ui.select()!='\r') menu=-1;
				break;
			case 2:
				ui.insert(scn);
				break;
			case 3:
				while(true) {
					if(!ui.selectEMP(scn).equals("Y")) break;
				}
				break;
			case 4:
				ui.update(scn);
				break;
			case 5:
				ui.delete(scn);
				break;
			case 6:
				System.out.print("프로그램을 종료하시겠습니까(y/n) ? ");
				String answer = scn.next().toUpperCase();
				if(answer.equals("Y")) {
					menu=-1;
				}
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
		scn.close();

	}

}
