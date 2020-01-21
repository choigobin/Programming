package jslhrd5;
class Equalstest{
	String name;
}
public class test {

	public static void main(String[] args) {
		Equalstest e1 = new Equalstest();
		Equalstest e2 = new Equalstest();
		
		e1.name = "최문구";
		e2.name = "최문구";
		System.out.println(e1.name==e2.name);
		

	}

}
