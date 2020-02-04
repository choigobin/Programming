import java.util.*;
public class Exam_11 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		//		id	,	pw
		map.put("java", "90");
		map.put("jsp", "96");
		map.put("servlet", "88");
		map.put("spring", "59");
		map.put("linux", "95");
		
		String id="java";
		String pw="90";
		if(map.containsKey(id)) {
			if(map.get(id).equals(pw)) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("비밀번호가 틀립니다");
			}
		}else {
			System.out.println("아이디가 없습니다");
		}
		
		
		
	}
}
