package p0802;

import java.util.Scanner;

public class CalFuelEfficiency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		double x,y;
		
		System.out.print("주행거리를 입력하세요: ");
		x= s.nextDouble();
		System.out.print("사용한 휘발유량을 입력하세요: ");
		y= s.nextDouble();
		System.out.print("연비 = "+ x/y);
	}
}
