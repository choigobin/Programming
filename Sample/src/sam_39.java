public class sam_39 {
	
	public static void main(String[] args) {
		int[][] a = {{1,20,30,40,90},{2,10,20,40,70},
				{3,20,30,35,85},{4,20,35,40,95},{5,45,40,10,95}};
		
		for(int i=0; i<a.length-1; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i][4] > a[j][4]) {
					for(int k=0; k<a[0].length; k++) {
						int t = a[i][k];
						a[i][k] = a[j][k];
						a[j][k] = t;
					}
				}
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
