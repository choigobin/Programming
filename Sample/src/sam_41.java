/*	배열 a,b가 각각 정렬이 되있어야지 c에 병합하여 정렬할 수 있다.
 * 
 */
public class sam_41 {
	public static void main(String[] args) {
		int[] a= {2,3,4,5,8,9,10,15,19,25};
		int[] b= {1,6,7,11,12,13,14,16,17,18,20,21,22,23,24};
		int[] c= new int[25];
		int i=0,j=0,k=0;
		
		while(true) {
			if(i<10 && j<15) {
				if(a[i]<=b[j]) {
					c[k]=a[i];
					i++;
				}else {
					c[k]=b[j];
					j++;
				}
				k++;
			}else if(i>=10) {
				while(j<15) {
					c[k]=b[j];
					j++;
				}
				break;
			}else {
				while(i<10) {
					c[k]=a[i];
					i++;
				}
				break;
			}
			
		}
		//결과 확인
		for(int z=0; z<c.length; z++) {
			System.out.print(c[z]+" ");
		}
		
		
	}
}
