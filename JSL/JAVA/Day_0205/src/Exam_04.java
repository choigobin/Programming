import java.util.*;
/* 리스트 voca에는 몇 개의 단어가 저장되어 있다.(중복된 단어들이 있다)
 * 각 단어가 voca에 몇 번 저장되어 있는 지를 출력하는 프로그램을 작성
 * (반드시 사전(Map)을 이용한다)
 * voca={"rose","candle","paper","book","song","candle","berry","paper","berry"
 * 		,"song","paper","rose","song","lion","berry","rose","book","rose","rose"}
 * 출력
 * candle : 2 times
 * rose : 5 times
 * 	.	.	.
 */
public class Exam_04 {
	public static void main(String[] args) {
		String[] voca = {"rose","candle","paper","book","song","candle","berry","paper","berry"
				 		,"song","paper","rose","song","lion","berry","rose","book","rose","rose"};
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int x=0; x<voca.length; x++) {
			if(map.containsKey(voca[x])) {
				map.put(voca[x],map.get(voca[x])+1);
			}else {
				map.put(voca[x],1);
			}
		}
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key+" : "+map.get(key)+" times");
		}
	}
}
