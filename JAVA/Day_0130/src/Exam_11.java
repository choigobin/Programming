import java.util.Arrays;

/*	검색
 */
public class Exam_11 {
	public static void main(String[] args) {
		int var[] = {80,90,77,88,56,95};
		String name[] = {"홍길동","김자바","이순신"};
		Arrays.parallelSort(var);
		for(int x=0; x<var.length; x++) {
			System.out.print(var[x]+"\t");
		}
		System.out.println();
		int index = Arrays.binarySearch(var, 90);
		System.out.println("90 위치는 : "+(index+1));
		Member m1 = new Member("홍길동");
		Member m2 = new Member("김자바");
		Member m3 = new Member("이순신");
		Member[] mem = {m1,m2,m3};
		Arrays.parallelSort(mem);
		int no = Arrays.binarySearch(mem, m2);
		System.out.println(m2.name+"는 "+(no+1)+"번째 있음");
		Arrays.parallelSort(name);
		no = Arrays.binarySearch(name, "홍길동");
		System.out.println("홍길동은 "+(no+1)+"번째 있음");
		
	}
}
