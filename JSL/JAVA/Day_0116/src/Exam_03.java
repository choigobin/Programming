/*	상수 정의
 * 	리터럴(literal) => (10, 'a', 3.14, "aa")
 * 	int year = 2020;
 * 	final in MAX_VAULE = 100;
 * 	변수 = year //하나의 값을 저장하기 위한 공간
 * 	상수 = MAX_VALUE //값을 한번만 저장할 수 있는 공간
 * 	리터럴 = 2017, 100 //그 자체로 값을 의미하는 것
 */
class AA{
	final double PI=3.14;//상수
	final static int MAX=100;
}
public class Exam_03 {
	public static void main(String[] args) {
		AA a = new AA();
		int b=3;
		double d = b*a.PI;
		System.out.println(d);
		
	}
	
}
