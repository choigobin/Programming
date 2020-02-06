package treeSetMap;
/* 컬렉션 => 값 저장X 객체 저장O
 * 검색기능을 강화한 컬렉션
 * TreeSet
 */
import java.util.*;
public class Exam_01 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Set<Integer> setz = new HashSet<Integer>();
		setz.add(10);//오토박싱 => 10 -> new Integer(10)
		setz.add(new Integer(10));//객체 주소가 저장됨
		@SuppressWarnings("rawtypes")
		Set set = new TreeSet();
		for(; set.size()<6;) {
			int num = (int)(Math.random()*45+1);
			set.add(num);
		}
		System.out.println(set);
		@SuppressWarnings("rawtypes")
		Set set2 = new HashSet();
		for(; set2.size()<6;) {
			int num = (int)(Math.random()*45+1);
			set2.add(num);
		}
		System.out.println(set2);
		
	}
}
