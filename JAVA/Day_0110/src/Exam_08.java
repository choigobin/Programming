import java.util.Scanner;

/*	리턴타입 o, 매개변수 o
 * 	키보드로 정수 입력
 * 	입력된 정수까지 합계 출력
 */
public class Exam_08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		sc.close();
		System.out.println(sum(num));
		int sum=sum(num);//리턴을 받았을 때는 저장할 변수 -> 저장하지 않으면 바로 삭제됨
		System.out.println(sum);
	}
	static int sum(int s) {
		int sum=0;
		for(int x=1; x<s+1; x++) {
			sum += x;
		}
		return sum;
	}
}
