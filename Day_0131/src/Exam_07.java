import java.text.SimpleDateFormat;
import java.util.Date;

/*	SimpleDateFormat
 */
public class Exam_07 {
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println("현재 날짜 : "+today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now1 = sdf.format(today);
		System.out.println("날짜 변환 : "+now1);
		
	}
}
