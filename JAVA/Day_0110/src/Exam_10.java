/*	2차원 배열에 Data가 입력되어 있을 경우
 * 	줄: 번호	점수1	점수2	점수3	점수4	점수5
 * 	1:	9	90	80	89	80	90
 * 	2:	5	77	88	99	90	70
 * 	.:	.	.	.	.	.	.
 * 	5:	55	66	76	89	80	90
 * 	
 * 	1. 입력 자료 출력 메소드 구현(dataPrint())
 * 		번호	점수1	점수2	점수3	점수4	점수5
 * 		.	.	.	.	.	.	
 * 
 * 	2. 총점 구하는 메소드 구현(dataTot())
 * 	3. 총점을 기준으로 내림차순 정렬 메소드 구현(totSort())
 * 	4. 전체 출력 메소드 구현(dataPrint())
 * 		번호	점수1	점수2	점수3	점수4	점수5	총점
 * 		.	.	.	.	.	.	.
 */
public class Exam_10 {

	public static void main(String[] args) {
		//배열 선언 및 데이터 초기화
		int data[][] = {{4,50,40,50,60,50,0},{8,80,56,10,35,47,0},{7,98,65,45,65,12,0},
				{18,65,78,56,78,23,0},{9,56,12,78,98,56,0}};
		//dataPrint() 호출
		dataPrint(data);
		//dataTot() 호출
		dataTot(data);
		//totSort() 호출
		totSort(data);
		//dataPrint2() 호출
		dataPrint(data);
	}
	
	static void dataPrint(int[][] data) {
		if(data[0][6]==0) {
			System.out.print("번호\t점수1\t점수2\t점수3\t점수4\t점수5\n");
			for(int x=0; x<data.length;x++) {
				for(int y=0;y<data[x].length-1;y++) {
					System.out.print(data[x][y]+"\t");
				}
				System.out.println();
			}
		}else {
			System.out.print("번호\t점수1\t점수2\t점수3\t점수4\t점수5\t총점\n");
			for(int x=0; x<data.length;x++) {
				for(int y=0;y<data[x].length;y++) {
					System.out.print(data[x][y]+"\t");
				}
				System.out.println();
			}
		}
	}
	
	static void dataTot(int[][] data) {
		for(int x=0; x<data.length;x++) {
			for(int y=1;y<data[x].length-1;y++) {
				data[x][data[x].length-1] += data[x][y];
			}
		}
	}
	
	static void totSort(int[][] data) {
		for(int x=0; x<data.length-1;x++) {
			for(int y=x+1;y<data.length;y++) {
				if(data[x][data[x].length-1]<data[y][data[y].length-1]) {
					int[] temp = new int[data[x].length];
					for(int z=0; z<temp.length; z++) {
						temp[z] = data[x][z];
						data[x][z] = data[y][z];
						data[y][z] = temp[z];
					}
				}
			}
		}
	}
	
}
