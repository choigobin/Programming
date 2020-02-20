/*	System.arraycopy
 */
public class Exam_07 {
	public static void main(String[] args) {
		int[][] var = {{1,2,3},{4,5,6}};
		int[][] str = new int[3][10];
		System.arraycopy(var, 0, str, 0, var.length);
		for(int x=0; x<str.length; x++) {
			for(int y=0; y<str[x].length; y++) {
				System.out.print(str[x][y]+"\t");
			}
			System.out.println();
		}
		String[][] s = {{"a","b"},{"c","d","e"}};
		String[][] s2 = new String[3][10];
		System.arraycopy(s, 0, s2, 0, s.length);
		s[0][0] = "z";
		for(int x=0; x<s2.length; x++) {
			for(int y=0; y<s2[x].length; y++) {
				System.out.print(s2[x][y]+"\t");
			}
			System.out.println();
		}
		String[] s3= {"a","b"};
		String[] s4= new String[5];
		System.arraycopy(s3, 0, s4, 0, s3.length);
		s3[0] = "z";
		for(int x=0; x<s4.length; x++) {
			System.out.print(s4[x]+"\t");
		}
		System.out.println(s3[0]);
	}
}
