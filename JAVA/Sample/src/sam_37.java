public class sam_37 {
	
	public static void main(String[] args) {
		int[][] a =new int[5][5];
		int k=0;
		
		for(int i=0;i<5; i++) {
			a[i][4] = 0;
			for(int j=0;j<4;j++) {
				k++;
				a[i][j] = k;
				a[i][4] += k;
			}
		}
		
		
		//결과 확인
		for(int i2=0; i2<5; i2++) {
			for(int j2=0; j2<5; j2++) {
				if(a[i2][j2] != 0) {
					System.out.print(a[i2][j2]);
				}
				System.out.print("\t");
			}
			System.out.println();
		}
		
	}

}
