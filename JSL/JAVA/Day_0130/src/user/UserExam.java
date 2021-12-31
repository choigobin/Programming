package user;

import java.util.Scanner;
import java.util.regex.Pattern;

/*	클래스 배열을 이용한 검색 기능 구현
 */
public class UserExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User[] data = new User[10];
		int cnt = 0;
		boolean end = true;
		//입력
		while(end && cnt<10) {
			while(cnt<10) {
				data[cnt] = new User();
				System.out.print("회원이름 : ");
				data[cnt].name = sc.nextLine();
				if(data[cnt].name.equals("")||data[cnt].name.equals("end")) {
					end = false;
					break;
				}
				System.out.print("회원 ID : ");
				data[cnt].userid = sc.nextLine();
				boolean check = false;
				for(int x=0; x<cnt; x++) {
					if(data[x].equals(data[cnt])) {
						System.out.println("경고! 아이디 중복");
						check = true;
						break;
					}
				}
				if(check) {
					break;
				}
				System.out.print("이메일 : ");
				data[cnt].email = sc.nextLine();
				String pat = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
				boolean bool = Pattern.matches(pat, data[cnt].email);
				if(!bool) {
					System.out.println("경고! 이메일 형식오류");
					break;
				}
				data[cnt].bun = cnt+1;
				cnt++;
			}
		}
		//입력자료 출력
		System.out.println("고유번호\t이름\tID\t이메일");
		for(int x=0; x<cnt; x++) {
			System.out.println(data[x]);
		}
		//회원 조회
		while(true) {
			System.out.print("검색(ID) : ");
			String id = sc.nextLine();
			if(id.toUpperCase().equals("END")) {
				break;
			}
			boolean result = true;
			for(int x=0; x<cnt; x++) {
				if(id.equals(data[x].userid)) {
					System.out.println(data[x]);
					result = false;
					break;
				}
			}
			if(result) {
				System.out.println("해당정보없음");
			}
		}
		System.out.println("검색 종료!");
		sc.close();
		
		
	}
}
