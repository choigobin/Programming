/*	2차원 배열
 * 	배열[row][col]
 * 	배열[0] 배열[0][0] 배열[0][1] 
 * 	배열[1] 배열[1][0] 배열[1][1] 배열[1][2]
 * 	배열[2] 배열[2][0] 
 * 	배열[3] 배열[3][0] 배열[3][1] 배열[3][2]
 * 	
 * 	배열.length => 4 // 줄(행)
 * 	배열[0].length => 2 // 칸(열)
 */
public class Exam_08 {
	public static void main(String[] args) {
		int[][] score = new int[5][4];//[row][col]
		score[0][0] = 10;
		System.out.println("row : "+ score.length);
		System.out.println("col : "+ score[0].length);
		System.out.println("value : "+ score[0][0]);
		
		int[] s = {1,2,3,4,5};
		int[][] ss= {{1,2,3},{1,2},{1,2,3,4,5,6}};
		for(int x=0; x<s.length; x++) {
			System.out.print(s[x]+"\t");
		}
		System.out.println();
		for(int x=0; x<ss.length; x++) {
			for(int y=0; y<ss[x].length; y++) {
				System.out.print(ss[x][y]+"\t");
			}
			System.out.println();
		}
		
	}
}
