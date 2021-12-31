package treeSetMap;
import java.util.*;
/*				이진트리
 * 				 7
 * 		   	  5	    9
 * 		 	1  6  8  10
 * 
 */
public class Exam_02 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		TreeSet set = new TreeSet();
		int[] score = {80,95,70,44,56,10,100,59};		
		
		for(int x=0; x<score.length; x++) {
			set.add(score[x]);
		}
		System.out.println("50보다 작은 값 : "+set.headSet(50));
		System.out.println("50보다 큰 값 : "+set.tailSet(50));
		System.out.println("가장 작은 값 : "+set.first());
		System.out.println("가장 큰 값 : "+set.last());
		System.out.println("90점 아래 값 : "+set.lower(90));
		System.out.println("90점 위 값 : "+set.higher(90));
		System.out.println("90점이거나 바로 아래 : "+set.floor(90));//트리 순서가 위에서 아래 => 90을 바닥으로 설정 => 90 위값은 90보다 작음
		System.out.println("90점이거나 바로 위 : "+set.ceiling(90));//트리 순서가 위에서 아래 => 90을 천장으로 설정 => 90 아래값은 90보다 큼
		//컬렉션에서 제거
		while(!set.isEmpty()) {
			int sc = (int)set.pollFirst();
			System.out.println(sc);
			System.out.println("남은 객체 수 : "+set.size());
		}
	}
}
