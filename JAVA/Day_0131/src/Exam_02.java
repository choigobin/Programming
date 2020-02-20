import java.util.Calendar;

/*	Calendar
 * 	월 0 ~ 11
 * 	요일(1.일 ~ 7.토)
 * 	YEAR(년), MONTH(월), DATE(일)	
 * 	HOUR(시), MINUTE(분) ,SECOND(초), AM_PM
 * 	DAY_OF_WEEK(1.일 ~ 7.토)
 */
public class Exam_02 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // 객체 생성
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);// 1월이 0 => 실제 월을 알려면 +1 해줘야함
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year+"년 "+(month+1)+"월 "+day+"일");
		
	}
}
