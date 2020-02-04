import java.util.*;
public class Exam_12 {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("김자바", 100); // 100 -> 오토박싱 -> new Integer(100)
		map.put("홍길동", 95);
		map.put("이자바", 88);
		map.put("박자바", 78);
		map.put("강자바", 90);
		// 학생명단 출력
		Set<String> set = map.keySet();
		System.out.println("학생 : "+set);
		// 값(점수)만 추출
		Collection<Integer> value = map.values();
		System.out.println("점수 : "+value);
		// 값 합계
		int tot=0;
		for(int x : value) {
			tot+=x;
		}
		System.out.println("합계 : "+tot);
	}
}
