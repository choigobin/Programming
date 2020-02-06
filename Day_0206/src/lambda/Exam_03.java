package lambda;
@FunctionalInterface
interface BBB{
	void test(int x);
}
public class Exam_03 {
	public static void main(String[] args) {
		BBB b;
		b=(x)->{System.out.println(x/0.01);};
		b.test(5);
	}
}
