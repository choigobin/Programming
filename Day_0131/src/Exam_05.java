import java.text.DecimalFormat;

/*	숫자 형식화
 * 	DecimalFormat
 * 	123000 -> 123,000
 */
public class Exam_05 {
	public static void main(String[] args) {
		int money = 758600;
		double money2 = 75554.456;
		DecimalFormat df1 = new DecimalFormat("'￦'#,###");
		DecimalFormat df2 = new DecimalFormat("#,###.##");
		
		System.out.println(df1.format(money));
		System.out.println(df2.format(money2));
		
		
		
	}
}
