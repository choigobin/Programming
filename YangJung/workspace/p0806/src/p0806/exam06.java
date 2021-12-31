package p0806;

import java.util.Scanner;

public class exam06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int x;
		System.out.print("등수를 입력하세요 : ");
		x=s.nextInt();
		switch(x) {
			case 1:
				System.out.print("아주 잘했습니다");
				break;
			case 2:
				System.out.print("잘했습니다");
				break;
			case 3:
				System.out.print("잘했습니다");
				break;
			case 4:
				System.out.print("보통입니다");
				break;
			case 5:
				System.out.print("보통입니다");
				break;
			case 6:
				System.out.print("보통입니다");
				break;
			default:
				System.out.print("노력해야 겠습니다.");			
		}
	}

}
