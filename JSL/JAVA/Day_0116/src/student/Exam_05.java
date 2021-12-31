package student;

public class Exam_05 {

	public static void main(String[] args) {
		AAA aa = new AAA();
		aa.aa = 100;
		aa.bb = 200;
		//aa.cc = 300; // private라서 접근이 안됌
		aa.aaa();
		aa.bbb();
		//aa.ccc(); // private라서 접근이 안됌
	}

}
