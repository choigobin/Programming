public class sam_35 {
	
	public static void main(String[] args) {
		int a[][] = new int[5][5];
		int k = 0;
		int m=4;
		
		for(int i=0; i<5; i++) {
			if(i%2==0) {
				for(int j=0; j<=m; j++) {
					k++;
					a[i][j] = k;
				}
			}else {
				for(int j=m; j>=0; j--) {
					k++;
					a[i][j] = k;
				}
			}
		}
		
		//결과 확인
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(a[i][j] != 0) {
					System.out.print(a[i][j]);
				}
				System.out.print("\t");
			}
			System.out.println();
		}
		
	}

}
