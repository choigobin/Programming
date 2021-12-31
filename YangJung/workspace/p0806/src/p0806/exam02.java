package p0806;

import java.util.Scanner;

public class exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int r,h;
		System.out.print("원기둥의 밑면의 반지름은? ");
		r=s.nextInt();
		System.out.print("원기둥의 높이는? ");
		h=s.nextInt();
		System.out.print("원기둥의 부피는 "+r*r*h*3.14);
	}

}
