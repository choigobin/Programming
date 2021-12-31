/*
1~100 합계
while(){}을 사용
 */

public class Exam_02 {
	
	public static void main(String[] args) {
		
		int i = 0;
		int sum = 0;
		
		while(true) {
			i++;
			sum = sum + i;
			
			if(i==100) break;
		}
		System.out.println("1~100 까지의 합 : "+sum);
		
		
		
		
	}

}
