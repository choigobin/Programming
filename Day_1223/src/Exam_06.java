/*	배열에 저장된 data 중 가장큰 값, 가장 작은값 찾기
 */
public class Exam_06 {
	public static void main(String[] args) {
		int array[] = {90,77,56,78,69,56,95,88,56,93,16,89,67,77};
		System.out.print("array data list");
		for(int i=0; i<array.length;i++) {
			if(i%7==0) {
				System.out.print("\n");
			}
			System.out.print(array[i]+"\t");
		}
		System.out.println();
		int max=array[0];//최대
		int min=array[0];//최소
		for(int i=1;i<array.length;i++) {
			if(max < array[i]) {
				max=array[i];
			}
			if(min > array[i]) {
				min=array[i];
			}
		}
		System.out.println("max = "+max);
		System.out.println("min = "+min);
		
	}
}
