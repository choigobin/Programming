import java.util.Scanner;

public class sam_22 {
	
	public static void main(String[] args) {
		int a[] = new int[10];
		Scanner sc = new Scanner(System.in);
		int i = 0;
		System.out.print("입력(10개) : ");
		for(int j=0;j<10;j++) {
			a[j] = sc.nextInt();
		}
		sc.close();
		while(i!=10) {
			System.out.print(a[i]+" ");
			i++;
		}
		
	}

}
