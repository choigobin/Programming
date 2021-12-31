package lotto;
import java.util.*;
public class SetLotto_02 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		for(int x=1; x<46; x++) {
			set.add(new Integer(x));
		}
		System.out.println(set);
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.shuffle(list);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for(int x=0; x<6; x++) {
			list2.add(list.get(x));
		}
		Collections.sort(list2);
		System.out.println(list2);

		
	}
}
