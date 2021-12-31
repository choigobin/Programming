import java.util.Scanner;

public class sam_07 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i=0,s=0;
		
		while(true) {
			System.out.print("입력 : ");
			int a = sc.nextInt();
			if(a==0) {
				System.out.println("i = "+i);
				System.out.println("s = "+s);
				break;
			}else {
				i++;
				s+=a;
			}
		}
		sc.close();
		
		
	}

}
