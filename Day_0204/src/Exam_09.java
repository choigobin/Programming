import java.util.*;
class Member{
	String id;
	String name;
	int age;
	Member(){}
	Member(String i, String n, int a){
		id=i;
		name=n;
		age=a;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member m = (Member)obj;
			return m.id.equals(id);
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
/*	키보드 입력(아이디,이름,나이)
 * 	- 이름이 'end'면 종료
 * 	- 동일한 아이디인 경우 '아이디 중복' 출력 후 재입력
 * 	출력 결과
 * 	아이디 이름 나이
 */
public class Exam_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Member> set = new HashSet<Member>();
		
		while(true) {
			System.out.print("입력(id,name,age): ");
			String[] str = sc.next().split(",");
			if(str[0].equalsIgnoreCase("end")) {
				break;
			}
			Member mem = new Member(str[0],str[1],Integer.parseInt(str[2]));
			if(!set.add(mem)) {
				System.out.println("\t아이디 중복입니다");
			}
		}
		sc.close();
		System.out.println("아이디\t이름\t나이");
		Iterator<Member> iter = set.iterator();
		while(iter.hasNext()) {
			Member m = iter.next();
			System.out.println(m.id+"\t"+m.name+"\t"+m.age);
		}
 		
	}
}
