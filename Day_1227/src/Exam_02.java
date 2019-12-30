
public class Exam_02 {
	public static void main(String[] args) {
		
		int a=5,b=0;
		int aa=5,bb=0;
		
		b=a++; // 대입 후 증가
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		bb=++aa; // 증가 후 대입
		System.out.println("aa = " + aa);
		System.out.println("bb = " + bb);
		
		int c=5,d=0;
		d=c++ +5;
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		
		int cc=5,dd=0;
		dd=++cc +5;
		System.out.println("cc = " + cc);
		System.out.println("dd = " + dd);
		
		
	}

}
