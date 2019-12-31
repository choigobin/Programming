/*	1 ~ 10 합계
 * 	1+2+3+4+ ..... +10 = 55
 */
public class Exam_05 {
	public static void main(String[] args) {
		int i=0;// 1 2 3 4 5 6 ...
		int s=0;// 1+2+3 ...
		do {
			i++;//i=i+1
			s+=i;//s=s+i
		}while(i<10);
		System.out.println("1부터 10까지의 합 = "+s);
		i=0;s=0;
		while(i<10) {
			i++;
			s+=i;
		}
		System.out.println("1부터 10까지의 합 = "+s);
		i=0;s=0;
		while(true) {
			i++;
			s+=i;
			if(i==10) break;
		}
		System.out.println("1부터 10까지의 합 = "+s);
		
	}
}
