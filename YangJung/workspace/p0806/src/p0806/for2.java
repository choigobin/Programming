package p0806;

import java.util.Random;
import java.util.Scanner;

public class for2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Random rd = new Random();
		
		int answer = rd.nextInt(100);
		int x;
		
		for(int i=1;i<=100;i++) {
			System.out.println("정답을 추측하여 보시오: ");
			x=s.nextInt();
			if(answer!=x) {
				if(answer>x) {System.out.println("제시한 정수가 낮습니다.");}
				if(answer<x) {System.out.println("제시한 정수가 높습니다.");}
				continue;
				}
			System.out.println("축하합니다. 시도횟수="+i);
			break;
			}
			
	}

}
