/*	if()
 * 	switch ~ case
 * 	90이상,	80이상, 	70이상,	60이상,	60미만
 * 	100-~90 89~80	79~70	69~60	59~0
 */
public class Exam_01 {
	public static void main(String[] args) {
		int var = 77;
		String str=""; // !=String str=null => ""=공백, null=없음 다름!
		char ch=' ';
		
		if(var<=100 && var>=90) { //if(var>=90)
			str="A";
		}else if(var<=89 && var>=80) { //else if(var>=80)
			str="B";
		}else if(var<=79 && var>=70) { //else if(var>=70)
			str="C";
		}else if(var<=69 && var>=60) { //else if(var>=60)
			str="D";
		}else { //else if(var>=0)
			str="F";
		}
		System.out.println(str+ch);
		
	}
}
