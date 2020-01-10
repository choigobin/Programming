public class sam_26 {
	
	public static void main(String[] args) {
		int a[] = {17,5,8,6,36,3,12,7,6,89};
		
		for(int i=1; i<a.length; i++) {
			int key = a[i];
			int n = i-1;
			for(int j= n;j>=0;j--) {
				if(key<a[j]) {
					a[j+1] =a[j];
					a[j]=key;
				}else {
					a[j+1] = key;
					break;
				}
			}
		}
		
		//결과 확인
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		
		
	}

}
