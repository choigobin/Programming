package test01;
class AAAA{
	
}
class BBBB extends AAAA{
	
}
public class Exam_09 {
	static void test(AAAA parent) {
		if(parent instanceof BBBB) { //instanceof 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보는 연산자 => 참조변수 instanceof 타입(클래스명)
			BBBB bb = (BBBB)parent;
			System.out.println("BBBB 변환 "+bb);
		}else {
			System.out.println("BBBB 불가");
		}
	}
	public static void main(String[] args) {
		AAAA aa = new BBBB();
		test(aa);
		AAAA aaa = new AAAA();
		test(aaa);
	}

}
