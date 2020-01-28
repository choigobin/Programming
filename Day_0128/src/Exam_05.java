import java.util.StringTokenizer;

public class Exam_05 {
	public static void main(String[] args) {
		String str ="010-1111.2222";
		String str2[] = str.split("-");
		for(int x=0; x<str2.length; x++) {
			System.out.println(str2[x]);
		}
		StringTokenizer st = new StringTokenizer(str,"-.");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
