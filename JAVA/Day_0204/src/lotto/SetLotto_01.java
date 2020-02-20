package lotto;
import java.util.*;
public class SetLotto_01 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		while(set.size()<6) {
			int lotto = (int)(Math.random()*45)+1;
			set.add(lotto);
		}
		while(set.size()<6) {
			Double lotto = Math.random()*45+1;
			set.add(lotto.intValue());
		}
		// 1차 출력
		System.out.println(set);
		// 정렬 후 출력
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		System.out.println(list);
		
	}
}
