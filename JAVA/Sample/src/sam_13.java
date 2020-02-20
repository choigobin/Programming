import java.util.Scanner;

public class sam_13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k =0;
		System.out.print("입력 : ");
		int m = sc.nextInt();
		sc.close();
		
		for(int i=2;i<=m;i++) {
			for(int j=2;j<=i; j++) {
				int n = i - (int)(i/j)*j;
				if(n==0) {
					if(i==j) {
						k++;
					}
					break;
				}
				
			}
		}
		System.out.println("2 ~ "+m+" 까지의 소수 갯수 = "+k);
		
		
		
	}

}
