import java.util.regex.Pattern;

/*	이메일 유효성 검사
 * 	abc@abc.com, 123@a23.co.kr
 * 	\w+ - 숫자or문자 1자 이상
 * 	\w+@\w+.\w+(.\w+)?
 */
public class Exam_03 {
	public static void main(String[] args) {
		String mail ="abc@abc.co.dm";
		String pat = "\\w+@\\w+.\\w+(.\\w+)?";
		
		boolean bool = Pattern.matches(pat, mail);
		if(bool) {
			System.out.println(mail + " 정상");
		}else {
			System.out.println(mail + " 오류");
		}
		
		
	}

}
