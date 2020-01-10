import java.util.Scanner;

public class sam_08 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max=0,min=999;
		
		while(true) {
			System.out.print("입력 : ");
			int a = sc.nextInt();
			if(a==-99) {
				System.out.println("Max = "+max);
				System.out.println("Min = "+min);
				sc.close();
				break;
			}else {
				if(max<a) {
					max=a;
				}
				if(min>a) {
					min=a;
				}
			}
		}
		

		
		
	}

}
