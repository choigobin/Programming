package p0809;

class Phone{
	String model;
	int value;
	
	void print() {
		System.out.println(value+"만원짜리"+model+"스마트폰");
	}
}

public class PhoneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone myPhone = new Phone();
		myPhone.model="갤럭시 S10";
		myPhone.value=15;
		myPhone.print();
		
		Phone yourPhone = new Phone();
		yourPhone.model = "아이폰xs";
		yourPhone.value = 120;
		yourPhone.print();
		
		Phone yourPhone1 = new Phone();
		yourPhone1.model = "아이폰xr";
		yourPhone1.value = 110;
		yourPhone1.print();
		
		Phone iphoneXplus = new Phone();
		iphoneXplus.model = "아이폰Xplus";
		iphoneXplus.value = 130;
		iphoneXplus.print();
	}
}
