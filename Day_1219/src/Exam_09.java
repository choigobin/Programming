/*	두개의 정수 입력 대, 소 구분
 * 	단, 동일한 값음 없음
 */
public class Exam_09 {
	public static void main(String[] args) {
		int a=90, b=80;
		int max, min;
		if(a>b) {
			max = a;
			min = b;
		}else {
			max=b;
			min=a;
		}
		System.out.println("대 : "+max+" 소 : "+min);
	}

}
