/*	1	2	3	4	5
 * 	10	9	8	7	6
 * 	11	12	13	14	15
 * 	20	19	18	17	16
 * 	21	22	23	24	25
 */
public class Exam_11 {
	public static void main(String[] args) {
		int[][] a = new int[5][5];
		int cnt = 1;
		// 입력
		for (int x = 0; x < a.length; x++) {
			if (x % 2 == 0) {
				for (int y = 0; y < a[0].length; y++) {
					a[x][y] = cnt;
					cnt++;
				}
			} else {
				for (int y = a[0].length - 1; y >= 0; y--) {
					a[x][y] = cnt;
					cnt++;
				}
			}
		}
		// 출력
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[0].length; y++) {
				System.out.print(a[x][y] + "\t");
			}
			System.out.println();
		}
		// 초기화
		System.out.println("-----------------------------------");
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[0].length; y++) {
				a[y][x] = 0;
			}
		}
		int k = 0, m = 5 ;
		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < m; j++) {
					k = k + 1;
					a[i][j] = k;
				}
			} else {
				for (int j = m-1; j >=0; j--) {
					k = k + 1;
					a[i][j] = k;
				}
			}
		}
		// 출력
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[0].length; y++) {
				System.out.print(a[x][y] + "\t");
			}
			System.out.println();
		}

	}
}
