package test01;
class Super{
	int x=100;
	void aa() {
		System.out.println("x="+ x);
	}
}
class Child extends Super{
	int x =150;
	int y=200;
	void aa() {
		System.out.println("x="+ x);
		System.out.println("y="+ y);
	}
	void bb() {
		System.out.println("x="+ x);
	}
}
class ChildA extends Super{
	
}
public class Exam_06 {
	public static void main(String[] args) {
		Super s = new Super();
		System.out.println("x="+ s.x);
		Child c = new Child();
		System.out.println("x="+ c.x);
		System.out.println("y="+ c.y);
		System.out.println("------------------------------------");
		Super ss = new Child();
		System.out.println("x="+ ss.x);
		//System.out.println("y="+ ss.y);
		ss = new ChildA();
		System.out.println("x="+ ss.x);
		System.out.println("------------------------------------");
		ss = c;
		ss.x=200;
		System.out.println("x="+ c.x);
		System.out.println("y="+ c.y);
		System.out.println("------------------------------------");
		s=c;
		s.aa();
		System.out.println("------------------------------------");
		c.aa();
		System.out.println("------------------------------------");
		c.bb();
	}

}
