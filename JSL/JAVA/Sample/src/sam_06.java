
public class sam_06 {
	
	public static void main(String[] args) {
		int i=0,s=0,sw=0;
		while(true){
			i++;
			if(sw==0) {
				s+=i;
				sw=1;
			}else {
				s-=i;
				sw=0;
			}
			if(i==10) break;
		}
		System.out.println("출력 : "+s);		
		
	}

}
