package student.util;
import student.AAA;

public class Exam_06 {

	public static void main(String[] args) {
		AAA aa = new AAA();
		aa.aa = 100;
		//aa.bb = 200; // default라서 다른 패키지에서 접근이 안됌
		//aa.cc = 300; // private라서 접근이 안됌
		aa.aaa();
		//aa.bbb(); // default라서 다른 패키지에서 접근이 안됌
		//aa.ccc(); // private라서 접근이 안됌

	}

}
