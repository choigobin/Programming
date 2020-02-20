public class sam_25 {
	
	public static void main(String[] args) {
		int a[] = {17,5,8,6,36,3,12,7,6,89};
		
		for(int i=1; i<a.length-1; i++) {
			int sw = 0;
			for(int j=0; j<a.length-i; j++) {
				if(a[j]>a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					sw=1;
				}
			}
			if(sw==0) {
				break;
			}
		}
		//결과 확인
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		
		
	}

}
