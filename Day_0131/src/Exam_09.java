import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*	1. 현재 날짜 - 1.8 버전부터
 * 	Date now = new Date();
 */
public class Exam_09 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now(); //현재 날짜
		LocalTime time = LocalTime.now(); //현재 시간
		LocalDateTime today = LocalDateTime.now(); //현재 날짜와 시간
		
		System.out.println("날짜 : "+date);
		System.out.println("시간 : "+time);
		System.out.println("날짜시간 : "+today);
		System.out.println("날짜 : "+LocalDate.now());
		System.out.println("시간 : "+LocalTime.now());
		System.out.println("날짜시간 : "+LocalDateTime.now());
		
		
	}
}
