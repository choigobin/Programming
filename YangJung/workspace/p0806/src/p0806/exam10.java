package p0806;

import java.util.Scanner;

public class exam10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x,sum=0;
		System.out.print("양의 정수를 입력하세요 : ");
		x=s.nextInt();
		do {if(x%2==0) {
				if(x>0) {sum=sum+x;}
			break;
			}
			else {break;}
		}while(x>0);
		System.out.print("양의 정수를 입력하세요 : ");
		x=s.nextInt();
		do {if(x%2==0) {
				if(x>0) {sum=sum+x;}
			break;
			}
			else {break;}
		}while(x>0);
		System.out.print("양의 정수를 입력하세요 : ");
		x=s.nextInt();
		do {if(x%2==0) {
				if(x>0) {sum=sum+x;}
			break;
			}
			else {break;}
		}while(x>0);
		System.out.print("양의 정수를 입력하세요 : ");
		x=s.nextInt();
		do {if(x%2==0) {
				if(x>0) {sum=sum+x;}
			break;
			}
			else {break;}
		}while(x>0);
		
		
		System.out.print("입력한 양의 정수 중에서 짝수의 합은 "+ sum);
	}
}
