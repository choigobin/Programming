import java.util.*;

/*	Hashtable -> 동기화 지원
 * 	HashMap -> 동기화 지원x -> 싱글 스레드의 경우 훨씬 빠름
 * ▼ HashMap 클래스의 put() 메소드
 public V put(K key, V value) {
 	int idx = hash(key);
	HashEntry<K, V> e = buckets[idx];
  
	while (e != null) {
    	if (equals(key, e.key)) {
        	e.access(); // Must call this for bookkeeping in LinkedHashMap.
      		V r = e.value;
            e.value = value;
            return r;
        }else
        	e = e.next;
		}
	// At this point, we know we need to add a new entry.
	modCount++;
    if (++size > threshold) {
    	rehash();
		// Need a new hash value to suit the bigger table.
        idx = hash(key);
    }
	// LinkedHashMap cannot override put(), hence this call.
    addEntry(key, value, idx, true);
    return null;
}
 */
public class Exam_10 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "ABC");
		String s = map.put(1, "AAA");
		System.out.println(map);
		System.out.println(s);
		map.put(2, "BBB");
		map.put(3, "CCC");
		map.put(1, "DDD");
		System.out.println(map);
		
		Set<Integer> set = map.keySet();
		System.out.println(set);
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			int x = iter.next();
			System.out.println("Key : "+x+" Value : "+map.get(x));
		}
		
	}
}
