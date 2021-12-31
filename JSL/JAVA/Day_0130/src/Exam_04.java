/*	System 클래스
 * 	- 운영체제와 상호작용
 */
public class Exam_04 {
	public static void main(String[] args) {
		int cnt=0;
		while(true) {
			System.out.println(cnt);
			if(cnt==10) {
				System.exit(1); // 프로그램 종료 - 일반적으로 0(정상 종료), 0 이외(비정상 종료)
				break;
			}
			cnt++;
		}
		
		System.out.println("프로그램 종료");
		
		System.gc(); // 가비지컬렉션(쓰레기 수집) - 요청 (바로 수행되는 건 아님)
	}
}
