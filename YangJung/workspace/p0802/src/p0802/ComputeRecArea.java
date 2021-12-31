package p0802;

import java.util.Scanner;

public class ComputeRecArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x,y;
		
		System.out.print("가로길이를 입력하세요: ");
		x= s.nextInt();
		System.out.print("세로길이를 입력하세요: ");
		y= s.nextInt();
		System.out.print("면적 = "+ x*y);
	}
}
