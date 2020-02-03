package member;

import java.util.ArrayList;
import java.util.Scanner;

/*	키보드 입력
 * 	아이디, 이름, 나이 입력 Member 객체를 생성
 * 	- 입력시 아이디가 'end'면 전체 출력 후 종료	
 * 	- ArrayList 이용
 * 	- 아이디가 같은 경우 "중복된 아이디입니다" 문장 출력 후 재입력
 * 	다음과 같이 출력
 * 	아이디	이름		나이
 * 	user01	홍길동	29
 * 		.	.	.
 * 
 */
public class MemberExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> list = new ArrayList<Member>();
		while (true) {
			System.out.print("입력(아이디,이름,나이) : ");
			String s = sc.nextLine();
			String[] str = s.split(",");
			if (str[0].equalsIgnoreCase("end")) {
				break;
			}
			Member m = new Member(str[0], str[1], Integer.parseInt(str[2]));
			if (list.contains(m)) {
				System.out.println("\t\t중복된 아이디입니다.");
			} else {
				list.add(m);
			}

		}
		sc.close();
		System.out.println("아이디\t이름\t나이");
		new MemberData(list);
		
	}
}
