package p0802;

import java.util.Scanner;

public class ComputeArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		float radius;
		double pie=3.14159;
		System.out.print("원의 반지름을 입력하세요: ");
		radius= s.nextFloat();
		System.out.println("원의 반지름은 "+radius+"이다.");
		System.out.println("원의 면적 = "+pie*Math.pow(radius, 2)+"이다.");
	}

}
