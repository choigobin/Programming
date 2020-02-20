public class sam_24 {
	
	public static void main(String[] args) {
		int a[] = {1,5,8,6,36,3,12,7,6,89};
		for(int i=1; i<a.length-1; i++) {
			int n = a.length-i;
			for(int j=0;j<n;j++) {
				if(a[j]>a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
				}
			}
		}
		//결과 확인
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		
		
	}

}
