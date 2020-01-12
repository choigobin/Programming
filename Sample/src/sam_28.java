import java.util.Scanner;

public class sam_28 {
	
	public static void main(String[] args) {
		int a[] = {1,5,7,8,9,19,23,27,30,37};
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int k = sc.nextInt();
		sc.close();
		int low = 0;
		int high = 9;
		while(true) {
			if(low<=high) {
				int mid = (low+high)/2;
				if(k == a[mid]) {
					System.out.println("mid = "+ mid);
					break;
				}else {
					if(k> a[mid]) {
						low = mid +1;
					}else {
						high = mid-1;
					}
				}
			}else {
				System.out.println("자료없음");
				break;
			}
		}
		
		
	}

}
