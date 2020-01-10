
public class sam_10 {
	
	public static void main(String[] args) {
		int s=0,t=0,sw=0;
		
		for(int i=1;i<101;i++) {
			if(sw==0) {
				sw=1;
				s=s+i;
			}else {
				sw=0;
				t=t+i;
			}
		}
		System.out.println("홀수의 합 = "+s);
		System.out.println("짝수의 합 = "+t);
		
		
	}

}
