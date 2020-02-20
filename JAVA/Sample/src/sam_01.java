import java.util.Scanner;

public class sam_01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//키보드로 입력 받기
		System.out.print("입력 : ");
		int a = sc.nextInt();
		sc.close();
		if(a>100) {
			System.out.println("입력 오류");
		}else {
			if(a>=90) {
				System.out.println("수");
			}else if(a>=80) {
				System.out.println("우");
			}else if(a>=70) {
				System.out.println("미");
			}else if(a>=60) {
				System.out.println("양");
			}else {
				System.out.println("가");
			}
		}
		
		
	}

}
