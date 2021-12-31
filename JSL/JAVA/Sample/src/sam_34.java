/*	0; 0<=4; +1  => 4; 4<=0; -1; 이렇게 바뀐다.
 * 	0; 0<=4; +1  => 4; 4>=0; -1; 이렇게 바뀌어야 의도되로 돌아감
 * 	부등 호 < -> > 이렇게 바꿔주는 방법이 필요! if 문으로 처리했음
 */
public class sam_34 {
	
	public static void main(String[] args) {
		int a[][] = new int[5][5];
		int k = 0;
		int l=0;
		int m=4;
		int n=1;
		for(int i=0; i<5; i++) {
			if(n==1) {
				for(int j=l;j<=m;j+=n) {
					k++;
					a[i][j] = k;
				}
			}else {
				for(int j=l;j>=m;j+=n) {
					k++;
					a[i][j] = k;
				}
			}
			int p = l;
			l=m;
			m=p;
			n *= -1;
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
