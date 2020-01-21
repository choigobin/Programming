package jslhrd5;

public class Exam_10 {
	public static void main(String[] args) {
		int a[] = {10,20,30,40,50};
		int b[] = a; // 주소 복사
		b[1] = 88;
		System.out.println("a[1] = "+a[1]+" b[1] = "+b[1]);
		int c[] = {10,20,30,40,50};
		int d[] = c.clone(); // 배열 복사
		d[1] = 99;
		System.out.println("c[1] = "+c[1]+" d[1] = "+d[1]);
	}

}
