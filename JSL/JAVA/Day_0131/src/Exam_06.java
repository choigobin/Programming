
public class Exam_06 {
	public static void main(String[] args) {
		String date = "20200131";
		//2020-01-31
		//2020년01월31일
		String y = date.substring(0,4);
		String m = date.substring(4,6);
		String d = date.substring(6,8);
		System.out.println(y+"-"+m+"-"+d);
		System.out.println(y+"년"+m+"월"+d+"일");
	}
}
