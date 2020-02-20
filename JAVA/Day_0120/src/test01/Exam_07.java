package test01;
class A{
	
}
class B extends A{
	
}
public class Exam_07 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		//B b1 = new A(); //불가
		//B b2 = (B)a1; //가능한것 같으나 런타임오류
		
		B b3 = new B();
		A a3 = b3;
		B b4 = (B)a3; //가능 a3가 원래 B클래스를 가르키고있기 때문
		
	}

}
