package jslhrd5;

import java.util.Scanner;

class Equalstest{
	String name;
}
public class test {

	public static void main(String[] args) {
		Equalstest e1 = new Equalstest();
		Equalstest e2 = new Equalstest();
		
		Scanner s = new Scanner(System.in);//스캐너 => 클래스 
		
		e1.name = s.next();
		e2.name = "최문구";
		String d = "최문구";
		String a = "최문";
		String b = "구";
		String c = a+b;
		System.out.println(e1.name==e2.name);
		System.out.println(e1.name=="최문구");
		System.out.println(e2.name==c);
		System.out.println(e2.name==d);
		System.out.println("e1.name = "+System.identityHashCode(e1.name));
		System.out.println("e2.name = "+System.identityHashCode(e2.name));
		System.out.println("a = "+System.identityHashCode(a));
		System.out.println("b = "+System.identityHashCode(b));
		System.out.println("c = "+System.identityHashCode(c));
		System.out.println("d = "+System.identityHashCode(d));
	}

}
