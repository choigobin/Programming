public class sam_29 {
	
	public static void main(String[] args) {
		int a[][] = new int[5][5];
		int k = 0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				k++;
				a[i][j] = k;
			}
		}
		
		//결과 확인
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
