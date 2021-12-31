public class sam_23 {
	
	public static void main(String[] args) {
		int a[] = {1,5,8,6,36,3,12,7,6,89};
		for(int i=0; i<a.length-1; i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
		//결과 확인
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		
		
	}

}
