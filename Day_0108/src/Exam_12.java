/*	1	2	3	4	5
 * 	10	9	8	7	6
 * 	11	12	13	14	15
 * 	20	19	18	17	16
 * 	21	22	23	24	25
 */
public class Exam_12 {
	public static void main(String[] args) {
		int[][] a = new int[5][5];
		int f = 5, cnt = 0, c = 1, i = 0, j = -1;
		// 입력
		while (f > 0) {
			for (int x = 0; x < f; x++) {
				cnt++;
				j += c;
				a[i][j] = cnt;
			}
			f--;
			for (int x = 0; x < f; x++) {
				cnt++;
				i += c;
				a[i][j] = cnt;
			}
			c = -c;
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
