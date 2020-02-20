import java.text.SimpleDateFormat;
import java.util.Date;

/*	날짜관련 클래스
 * 	Date - 클래스, Calendar - 추상클래스
 * 	GregorianCalendar - 클래스
 */
public class Exam_01 {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분ss초");
		String nowStr = sdf.format(now);
		System.out.println(nowStr);
		
	}
}
