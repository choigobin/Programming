import java.util.Scanner;

/*	키보드로 사용자, 시작값, 끝값 입력 다음과 같이 출력하는 클래스를 작성하시오
 * 	[ 입력 예시 ]
 * 	사용자: 홍길동
 * 	시작   : 5
 *	   끝   : 20
 *	[ 출력 예시 ]
 *	사용자 : 홍길동
 *	연산결과 : 5+6+7+8+9+ ... +20 = xxx 
 * 
 */
class SeqNumber{
	String name;
	int start, end;
	SeqNumber(String name,int start,int end){
		this.name = name;
		this.start = start;
		this.end = end;
	}
	void print() {
		System.out.println("[ 출력 ]");
		System.out.println("사용자 : "+name);
		System.out.print("연산결과 : ");
		for(int i=start;i<end;i++) {
			System.out.print(i+"+");
		}
		System.out.println(end+" = "+(start+end)*(end-start+1)/2);
	}
}

public class Exam_02 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("사용자 : ");
		String name = sc.nextLine();
		System.out.print("시작    : ");
		int start = sc.nextInt();
		System.out.print(" 끝     : ");
		int end = sc.nextInt();
		sc.close();
		//입력
		
		SeqNumber seq = new SeqNumber(name, start, end);
		seq.print();
	}
	
}
