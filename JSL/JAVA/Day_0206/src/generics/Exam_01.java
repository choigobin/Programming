package generics;
import java.util.*;
/*	제네릭 : 다양한 타입의 객체를 다루는 메소드나 클래스에
 * 			컴파일시의 타입 체크를 해주는 기능
 * 	제네릭을 사용하면 형변환 필요X => 편의성 향상(형변환 불필요)
 * 	제네릭을 사용하면 해당 타입의 객체만 사용가능 => 안정성 향상(객체 타입 제한), 
 */
public class Exam_01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		String name = list.get(0); //(String)list.get(0) => 형변환 불필요 
		System.out.println(name);
		
	}
}
