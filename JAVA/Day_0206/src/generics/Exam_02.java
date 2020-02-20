package generics;
class Box{
	private Object obj;
	public void set(Object o) {
		obj = o;
	}
	public Object get() {
		return obj;
	}
}
class Apple{
	
}
public class Exam_02 {
	public static void main(String[] args) {
		Box box = new Box();
		box.set("홍길동");
		
		String name = (String)box.get();
		System.out.println(name);
		System.out.println(box.get());
	}	
}
