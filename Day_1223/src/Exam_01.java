/*	배열 처리: 동일한 이름을 가진 기억장소의 이름 (ex.아파트) //배열 : 참조형, 주소값 저장
 * 	배열명(이름), 인덱스(첨자) -> a[1]
 */
public class Exam_01 {
	public static void main(String[] args) {
		// 배열 선언
		int a; // a변수 선언 -> 4byte
		a=10; // 일반변수 => 값 저장
		int var[]; // var 배열변수 선언(공간만 할당) / int형이니까 4byte
		var = new int[10];// 할당(실제 메모리 구성), 주소값 저장 / 배열은 할당후 자동으로 초기화
		//var -> 첫번째 요소의 '주소'를 가리킴
		System.out.println("var = "+var);//배열의 시작주소 = 첫번쨰 요소의 주소
		System.out.println("var+0 = "+var+0);//첫번째 요소의 주소
		System.out.println("var+1 = "+var+1);//두번째 요소의 주소 -> 배열의 시작주소에서 4byte건너 뛴 주소
		System.out.println("var[0] = "+var[0]);//[0]번 요소의 값
	}
}
