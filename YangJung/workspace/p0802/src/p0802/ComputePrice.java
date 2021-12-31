package p0802;

import java.util.Scanner;

public class ComputePrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int buy;
		double price=100000.0;
		
		System.out.print("고객이 구입한 제품의 수량을 입력하세요. : ");
		buy= s.nextInt();
		
		if(buy>=10) {
			System.out.print("총 가격 =");
			System.out.print(price*buy*0.9);
		}
		else {
			System.out.print("총 가격 =");
			System.out.print(price*buy);
		}
	}

}
