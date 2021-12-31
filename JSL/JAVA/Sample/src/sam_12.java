import java.util.Scanner;

public class sam_12 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int a= sc.nextInt();
		sc.close();
		for(int i=2;i<a+1;i++) {
			int n = a -(int)(a/i)*i;
			if(n==0) {
				if(a==i) {
					System.out.println("소수");
					break;
				}else {
					System.out.println("소수 아님");
					break;
				}
			}
		}
		
	}

}
