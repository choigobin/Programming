import java.util.Scanner;

public class sam_03 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력(a,b,c) : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		int max,me,min;
		if(a>b) {
			if(a>c){
				max=a;
				if(b>c) {
					me=b;
					min=c;
				}else {
					me=c;
					min=b;
				}
			}else {
				max=c;
				me=a;
				min=b;
			}
		}else {
			if(b>c) {
				max=b;
				if(a>c) {
					me=a;
					min=c;
				}else {
					me=c;
					min=a;
				}
			}else {
				max=c;
				me=b;
				min=a;
			}
		}
		System.out.println("max = "+max);
		System.out.println("me = "+me);
		System.out.println("min = "+min);
			
		
	}

}
