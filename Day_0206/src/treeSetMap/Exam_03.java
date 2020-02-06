package treeSetMap;
import java.util.*;
/*	TreeMap
 * 
 */
public class Exam_03 {
	public static void main(String[] args) {
		TreeMap<Integer, String> score = new TreeMap<Integer, String>();
		score.put(87, "홍길동");// 87 => new Integer(87) - 오토박싱
		score.put(90, "김자바");
		score.put(55, "이순신");
		score.put(78, "이말자");
		score.put(69, "강호동");
		score.put(40, "홍자반");
		System.out.println(score);
		Map.Entry<Integer, String> entry = null;
		entry = score.firstEntry();
		System.out.println("가장 작은 점수 : "+entry.getKey() +" - "+entry.getValue());
		
		entry = score.lastEntry();
		System.out.println("가장 큰 점수 : "+entry.getKey() +" - "+entry.getValue());
		
		entry = score.lowerEntry(85);
		System.out.println("85점 아래 점수 : "+entry.getKey() +" - "+entry.getValue());
		
		entry = score.higherEntry(75);
		System.out.println("75점 위 점수 : "+entry.getKey() +" - "+entry.getValue());
		
		entry = score.floorEntry(85);
		System.out.println("85점 이거나 바로 아래 점수 : "+entry.getKey() +" - "+entry.getValue());
		
		entry = score.ceilingEntry(85);
		System.out.println("85점 이거나 바로 위 점수 : "+entry.getKey() +" - "+entry.getValue());
		
		while(!score.isEmpty()) {
			entry = score.pollFirstEntry();
			System.out.println(entry.getKey()+" - "+entry.getValue()+" 남은 객체 : "+ score.size());
		}
		
	}
}
