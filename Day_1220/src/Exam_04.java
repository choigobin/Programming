/*
 1~100 홀수합
 1) for문
 2) while문
 */


public class Exam_04 {
	
	public static void main(String[] args) {
		
		//1) for문 사용
		
		//나머지 연산 이용
		int sum = 0;
		
		for(int i = 0; i<=100 ; i++) {
			
			if(i%2 == 1) {
				sum = sum + i;
			}
			
		}
		System.out.println("1~100 까지 홀수의 합은 "+sum);
		
		//flag 사용(스위치)
		int sum1 = 0;
		boolean flag = true;
		
		for(int i = 1; i<=100 ; i++) {
			
			if(flag) {
				flag = false;
				sum1 = sum1 + i;
			}else {
				flag = true;
			}
			
		}
		System.out.println("1~100 까지 홀수의 합은 "+sum1);
		
		
		
		//flag 사용(스위치) 짝수합
		int sum2 = 0;
		boolean flag2 = true;
		
		for(int i = 0; i<=100 ; i++) {
			
			if(flag2) {
				flag2 = false;
				sum2 = sum2 + i;
			}else {
				flag2 = true;
			}
			
		}
		System.out.println("1~100 까지 짝수의 합은 "+sum2);
		
		//나머지 연산 이용 짝수합
		int sum3 = 0;
		
		for(int i = 0; i<=100 ; i++) {
			
			if(i%2 == 0) {
				sum3 = sum3 + i;
			}
			
		}
		System.out.println("1~100 까지 짝수의 합은 "+sum3);
		
		
		
		
		//2) while문 사용
		
		
		
		
	} 
	

}
