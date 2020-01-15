import java.util.Scanner;

/*	키보드로 번호,이름,국어,영어,수학 입력
 * 	다음과 같이 출력하는 클래스 생성하시오
 * 	[ 입력 예시 ]
 * 	입력 : 1 aaaa 90 70 80
 * 	[ 출력 예시 ]
 * 	번호 : xx
 * 	이름 : xx
 * 	총점 : xx
 * 	평균 : xx
 */
class Student{
	//Student(){} Student xx = new Student(); 만들고 싶을 때 생성
	Student(int b,String na,int k,int e,int m){
		a[0] = b;
		a[1] = k;
		a[2] = e;
		a[3] = m;
		a[4] = k+e+m;
		a[5] = (k+e+m)/3;
		this.na = na;
	}
	int[] a = new int [6];
	String na = "";
	void print(){
		System.out.println("[ 출 력 ]");
		System.out.println("번호 : "+a[0]);
		System.out.println("이름 : "+na);
		System.out.println("총점 : "+a[4]);
		System.out.println("평균 : "+a[5]);
	}
}

public class Exam_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int b = sc.nextInt();
		String na = sc.next();
		int k = sc.nextInt();
		int e = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		//입력 작업
		Student st = new Student(b,na,k,e,m);
		st.print();
		
	}
	
}
