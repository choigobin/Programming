import java.util.Scanner;

public class sam_02 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력(a,b) : ");
		int a= sc.nextInt();
		int b= sc.nextInt();
		sc.close();
		int max,min;
		if(a>b) {
			max =a;
			min =b;
			
		}else {
			max =b;
			min =a;
		}
		System.out.println("max = "+max);
		System.out.println("min = "+min);
	}

}
