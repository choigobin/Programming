public class sam_36 {
	
	public static void main(String[] args) {
		int[][] a =new int[5][5];
		int k=0,c=1,i=0,j=-1,f=5;
		while(f>0) {
			for(int n=0;n<f;n++) {
				k++;
				j+=c;
				a[i][j] = k;
			}
			f--;
			
			for(int n=0;n<f;n++) {
				k++;
				i+=c;
				a[i][j] = k;
			}
			c*=-1;
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
