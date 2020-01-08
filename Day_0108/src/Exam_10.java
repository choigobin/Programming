/*	1	6	11	16	21
 * 	2	7	12	17	22
 * 	3	8	13	18	23
 *	4	9	14	19	24
 *	5	10	15	20	25 
 */
public class Exam_10 {
	public static void main(String[] args) {
		int[][] a= new int[5][5];
		int cnt=1;
		//입력
		for(int x=0; x<a.length; x++) {
			for(int y=0; y<a[0].length; y++) {
				a[y][x] = cnt;
				cnt++;
			}
		}
		//출력
		for(int x=0; x<a.length; x++) {
			for(int y=0; y<a[0].length; y++) {
				System.out.print(a[x][y]+"\t");
			}
			System.out.println();
		}
		//초기화
		System.out.println("-----------------------------------");//2
		cnt =1;
		for(int x=0; x<a.length; x++) {
			for(int y=0; y<a[0].length; y++) {
				a[y][x] = 0;
			}
		}
		//입력
		for(int x=0; x<a.length; x++) {
			for(int y=0; y<x+1; y++) {
				a[x][y] = cnt;
				cnt++;
			}
		}
		//출력
		for(int x=0; x<a.length; x++) {
			for(int y=0; y<a[0].length; y++) {
				if(a[x][y]==0) {
					System.out.print("\t");
				}else {
					System.out.print(a[x][y]+"\t");
				}
			}
			System.out.println();
		}
		//초기화
		System.out.println("-----------------------------------");//3
		cnt = 1;
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[0].length; y++) {
				a[y][x] = 0;
			}
		}
		// 입력
		int z=4;
		for (int x = 0; x < a.length; x++) {
			z--;
			for (int y = 0; y < a[0].length; y++) {
				if(y>z) {
					a[x][y] = cnt;
					cnt++;
				}
			}
		}
		// 출력
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[0].length; y++) {
				if (a[x][y] == 0) {
					System.out.print("\t");
				} else {
					System.out.print(a[x][y] + "\t");
				}
			}
			System.out.println();
		}
		//초기화
		System.out.println("-----------------------------------");//4
		cnt = 1;
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[0].length; y++) {
				a[y][x] = 0;
			}
		}
		// 입력
		for (int x = 0; x < a.length; x++) {
			for (int y = x; y >=0; y--) {
				a[x][y] = cnt;
				cnt++;
			}
		}
		// 출력
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[0].length; y++) {
				if (a[x][y] == 0) {
					System.out.print("\t");
				} else {
					System.out.print(a[x][y] + "\t");
				}
			}
			System.out.println();
		}	
	}
}
