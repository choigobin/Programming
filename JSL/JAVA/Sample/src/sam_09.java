import java.util.Scanner;

public class sam_09 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("기준 입력 : ");
		int a = sc.nextInt();
		int max=a, min=a;
		while(true) {
			System.out.print("입력 : ");
			a = sc.nextInt();
			if(a==-99) {
				System.out.println("max = "+max);
				System.out.println("min = "+min);
				sc.close();
				break;
			}else {
				if(max < a) {
					max=a;
				}
				if(min > a) {
					min=a;
				}
			}
			
		}

		
		
	}

}
