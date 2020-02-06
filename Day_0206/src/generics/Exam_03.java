package generics;
class Box2<T>{
	private T t;
	
	public T get() {
		return t;
	}
	public void set(T t) {
		this.t=t;
	}
}
public class Exam_03 {
	public static void main(String[] args) {
		Box2<String> box = new Box2<String>();
		box.set("홍길동");
		String name = box.get();
		System.out.println(name);
		
		
	}
}
