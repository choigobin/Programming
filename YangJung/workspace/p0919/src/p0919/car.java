package p0919;

public class car {
	
	String compnay="현대자동차";
	String model;
	String color;
	int maxspeed;
	//생성자
	
	car(){
		
	}
	car(String model){
		this.model=model;
	}
	car(String model,String color){
		this.model=model;
		this.color=color;
	}
	
	public static void main(String[] args) {
		car c1=new car();
		System.out.println(c1.compnay+" "+c1.model);
		car c2=new car("펠리세이드");
		System.out.println(c2.compnay+" "+c2.model);
		car c3=new car("제네시스","블랙");
		System.out.println(c3.compnay+" "+c3.model+" "+c3.color);
	}
}
