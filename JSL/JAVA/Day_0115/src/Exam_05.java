class AA{
	int a;
	int b;
}
public class Exam_05 {
	
	public static void main(String[] args) {
		AA a = new AA();//클래스 객체
		int[] b = new int[5];
		b[0] = 10;
		b[1] = 10;
		AA[] s= new AA[5];//클래스 배열
		s[0] = a;
		s[1] = a;
		s[2] = new AA();
		s[3] = new AA();
		s[4] = s[3];
		a.a= 100;
		System.out.println("s[0] = "+s[0]);
		System.out.println("s[1] = "+s[1]);
		System.out.println("s[2] = "+s[2]);
		System.out.println("s[3] = "+s[3]);
		System.out.println("s[4] = "+s[4]);
		System.out.println("s[0].a = "+s[0].a);
		System.out.println("s[1].a = "+s[1].a);
	}
	
}
