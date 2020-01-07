/*	10개의 배열에 저장된 데이터 중 최대, 최소 값 찾기
 */
public class Exam_07 {
	public static void main(String[] args) {
		int score[] = {90,44,77,88,67,94,83,54,86,57};
		int max=score[0];
		int min=score[0];
		for(int x=1;x<score.length;x++) {
			if(max<score[x]) {
				max=score[x];
			}
			if(min>score[x]) {
				min=score[x];
			}
		}
		//출력
		System.out.print("입력자료 : ");
		for(int i=0;i<score.length;i++) {
			System.out.print(score[i]+" ");
		}
		System.out.println("\nMAX : "+max+"\tMIN : "+min);
		
	}
}
