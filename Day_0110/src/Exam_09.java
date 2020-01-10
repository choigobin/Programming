import java.util.Scanner;

/*	키보드 입력(10개)
 * 	오름 차순 정렬 출력
 * 		Source Data : xx xx xx xx xx ...
 * 		Sort Data : xx xx xx xx xx ...
 * 	1. 입력은 main()
 * 	2. 오름차순 정렬은 메소드 이용
 * 	3. 출력은 다른 메소드 이용
 */
public class Exam_09 {
	public static void main(String[] args) {
		int[] data = new int[10];
		Scanner sc = new Scanner(System.in);
		//입력
		System.out.print("입력 : ");
		for(int x=0; x<10; x++) {
			data[x] = sc.nextInt();
		}
		sc.close();
		// Source Data 출력
		print("Source",data);
		// Data 오름차순 정렬
		sort(data);
		// Sort Data 출력
		print("Sort",data);
		
		
	}
	
	static void sort(int[] a) {
		for(int x=0;x<a.length-1;x++) {
			for(int y=x+1; y<a.length;y++) {
				if(a[x]>a[y]) {
					int temp = a[x];
					a[x] = a[y];
					a[y] = temp;
				}
			}
		}
		
	}
	
	static void print(String title,int[] data) {
		System.out.print(title+" Data :\t");
		for(int x=0; x<10; x++) {
			System.out.print(data[x]+"\t");	
		}
		System.out.println();
	}
	
}
