import java.util.Scanner;

public class sam_40 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		int i =-1;
		System.out.print("입력 : ");
		int n = sc.nextInt();
		sc.close();
		
		while(true) {
			if(n>0) {
				int m = n/2;
				int g = n%2;
				i++;
				a[i]=g;
				n=m;
			}else {
				for(int l=i; l>=0; l--) {
					System.out.print(a[l]);
				}
				break;
			}
		}
		
		
		
		
		
	}

}
