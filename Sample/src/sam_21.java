import java.util.Scanner;

public class sam_21 {
	
	public static void main(String[] args) {
		int a[] = new int[10];
		Scanner sc = new Scanner(System.in);
		int i = 0;
		System.out.print("입력 : ");
		while(i!=10) {
			int s = sc.nextInt();
			a[i] = s;
			i++;
		}
		sc.close();
		
		for(int j=0;j<10;j++) {
			System.out.print(a[j]+"\t");
		}
		
		
	}

}
