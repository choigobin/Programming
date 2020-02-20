/* Wrapper 의 중요한 용어 ###########
 * - 오토박싱, 오토언박싱
 * 기본타입을 박싱하면 객체가 된다.
 *  
 */
public class Exam_03 {
	public static void main(String[] args) {
		int n=10;
		Integer nN = new Integer(n); // 객체화. 이런 방법으로 해야되지만
		
		// ## 오토박싱이 되기 때문에 아래와 같이 사용 가능.
		Integer nI =n; // 기본타입이 객체로 변환
		System.out.println(nN+"\t"+nI);
		// 오토언박싱(자동 변환) 기능으로 인해 주소값이 아니라 값이 출력된다.
		// 객체 지향 프로그램에서 int n=10;은 객체가 아니기 때문에 객체지향으로 바꾸기 위해 사용.
		
		
		Integer n2 = new Integer(100);
		int n3=n2;
		
	}

}