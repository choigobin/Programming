public class sam_27 {
	
	public static void main(String[] args) {
		int a[] = {17,5,8,6,36,3,12,7,6,89};
		int b[] = {0,0,0,0,0,0,0,0,0,0};
		
		for(int i=0; i < b.length; i++) {
			b[i] = 1;
		}
		
		for(int i=0; i<a.length;i++) {
			for(int j=0; j<a.length; j++) {
				if(a[i]<a[j]) {
					b[i]++;
				}
			}
		}
		
		//결과 확인
		System.out.print("점수 :\t");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.print("\n석차 :\t");
		for(int i=0; i<a.length; i++) {
			System.out.print(b[i]+"\t");
		}
		
	}

}
