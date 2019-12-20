/*
 1~100 짝수합
 */
public class Exam_05 {
	
	public static void main(String[] args) {
		
		//2씩 증가 시켜주기
		int i = 0, eventot = 0;
		while(true) {
			i = i + 2;
			eventot = eventot + i ;
			if(i == 100) {
				break;
			}
		}
		System.out.println("1~100 까지 짝수 합은 "+eventot);
		
		//조건문추가
		i = 0;
		int eventot1 = 0;
		while(i<100) {
			i = i + 2;
			eventot1 = eventot1 + i ;
			
		}
		System.out.println("1~100 까지 짝수 합은 "+eventot1);
		
		//나머지 연산 이용
		i = 0;
		int eventot2 = 0;
		while(i<100) {
			
			i = i + 2;
			if(i % 2 ==0) {
				eventot2 = eventot2 + i ;
			}
			
		}
		System.out.println("1~100 까지 짝수 합은 "+eventot2);
		
		//flag이용
		i = 0;
		int eventot3 = 0;
		boolean flag = true;
		while(i<100) {
			i++;
			if(flag) {
				flag = false;
			}else {
				eventot3 += i;
				flag = true;
			}
		}
		System.out.println("1~100 까지 짝수 합은 "+eventot3);
		
		
		
		
		
		
	}

}
