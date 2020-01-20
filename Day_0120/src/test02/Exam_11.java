package test02;
abstract class Animal{
	String kind;
	void test() {
		System.out.print(kind+" : ");
		sound();
	}
	abstract void sound();
}
class Dog extends Animal{
	@Override //애너테이션 (Annotation)
	void sound() {
		kind = "개";
		System.out.println("멍멍");
	}
}
class Cat extends Animal{
	@Override
	void sound() {
		kind = "고양이";
		System.out.println("야옹");
	}
}
public class Exam_11 {
	public static void main(String[] args) {
		Animal a = new Dog();
		a.test();
		a = new Cat();
		a.kind = "고양이다";
		a.test();
		System.out.println("=======================");
		animalSound(new Dog());
		animalSound(new Cat());
		
	}
	static void animalSound(Animal a) {
		a.sound();
	}
}
