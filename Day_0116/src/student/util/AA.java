package student.util;
import student.BB;
/*	같은 패키지내에는 같은 클래스를 만들 수 없다.
 * 	패키지가 다르면 상관없다.
 */
public class AA {
	BB b = new BB();//다른 패키지의 클래스를 사용할 때는 import 필요!
}
