
public class sam_11 {
	
	public static void main(String[] args) {
		int s=0,t=0;
		
		for(double i=1;i<101;i++) {
			
			if(i/2==(int)(i/2)) {
				t+=i;
			}else {
				s+=i;
			}
				
		}
		System.out.println("홀수의 합 = "+ s);
		System.out.println("짝수의 합 = "+ t);
		
		
	}

}
