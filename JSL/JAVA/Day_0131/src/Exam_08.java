import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*	문자열 -> 날짜형으로 변환
 * 	SimpleDateFormat -> parse(str);
 * 	날짜형 -> 문자열형으로
 */
public class Exam_08 {
	public static void main(String[] args) {
		String today = "20200131";
		DateFormat sdf = new SimpleDateFormat("yyyyMMdd");// today랑 모양을 맞춰줘야함
		DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date now;
		try {
			now = sdf.parse(today);
			String now1 = sdf1.format(now);
			System.out.println("날짜 변환 : "+now1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
