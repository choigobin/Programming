package exam;
import java.util.*;

import view.UI;
public class examMain {
	public static void main(String[] args) {
		UI ui = new UI();
		Scanner scn = new Scanner(System.in); 
		boolean bool = true;
		while(bool) {
			System.out.println("1: 목록(List)");
			System.out.println("2: 등록(Insert)");
			System.out.println("3: 검색(Select)");
			System.out.println("4: 수정(Update)");
			System.out.println("5: 삭제(Delete)");
			System.out.println("6: 종료(Exit)");
			System.out.print(" 메뉴 선택 :");
			int menu = scn.nextInt();
			switch(menu) {
			case 1:
				//목록
				ui.deptView();
				break;
			case 2:
				//등록
				ui.deptInsert(scn);
				break;
			case 3:
				//부서번호를 입력시 해당 부서 정보 출력
				ui.deptSelect(scn);
				break;
			case 4:
				//부서번호를 받아 부서명, 지역명 수정
				ui.deptUpdate(scn);
				break;
			case 5:
				ui.deptDelete(scn);
				//부서번호를 이용한 삭제
				break;
			case 6:
				System.out.println("종료합니다.");
				bool = false;
				break;
			}
		}
		scn.close();
		
	}
}
