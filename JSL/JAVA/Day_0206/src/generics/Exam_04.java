package generics;
class Product<T,M>{
	private T kind;
	private M model;
	public void set(T k, M m) {
		kind = k;
		model = m;
	}
	public T getKind() {
		return kind;
	}
	public M getModel() {
		return model;
	}
}
class Car{
	
}
public class Exam_04 {
	public static void main(String[] args) {
		Product<String,Integer> p = new Product<String, Integer>();
		p.set("컴퓨터", 386);
		System.out.println(p.getKind()+" = "+p.getModel());
		
		Product<Car,Integer> pp = new Product<Car, Integer>();
		Car c = new Car();
		pp.set(c, 10);
	}
}
