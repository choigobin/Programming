package p0923;
import p0923.phone1;

public class phonedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		phone1 myPhone = new phone1();
		myPhone.model = "갤럭시 S8";
		myPhone.value = 100;
		myPhone.print();
		
		phone1 yourPhone = new phone1();
		yourPhone.model = "G8";
		yourPhone.value = 100;
		yourPhone.print();
	}

}
