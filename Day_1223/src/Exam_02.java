
public class Exam_02 {
	public static void main(String[] args) {
		int[] arr = new int[5];//arr[0],arr[1] -- arr[4] -> 0~4 5개!
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3] = arr[0]+arr[1]+arr[2];
		arr[4] = arr[3]/3;
		
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.print(arr[0]+"\t");
		System.out.print(arr[1]+"\t");
		System.out.print(arr[2]+"\t");
		System.out.print(arr[3]+"\t");
		System.out.print(arr[4]+"\n");
		
	}
}
