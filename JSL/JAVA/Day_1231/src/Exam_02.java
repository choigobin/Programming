/*	if()
 * 	switch ~ case
 * 	90이상,	80이상, 	70이상,	60이상,	60미만
 * 	100-~90 89~80	79~70	69~60	59~0
 */
public class Exam_02 {
	public static void main(String[] args) {
		int var = 77;
		String str=""; // !=String str=null => ""=공백, null=없음 다름!
		
		switch(var/10) { // ()안에는 수식 또는 변수(정수, 문자, 문자열)
			case 10: // 값(정수, 문자, 문자열)
				str="A";
				break;
			case 9:
				str="A";
				break;
			case 8:
				str="B";
				break;
			case 7:
				str="C";
				break;
			case 6:
				str="D";
				break;
			default:
				str="F";
		}
		System.out.println("성적 = "+str);
		System.out.println(var+"\t"+var/10);
		
		
	}
}
