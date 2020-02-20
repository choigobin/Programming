import java.util.Properties;

/*	환경병수 수집
 * 	
 */
public class Exam_05 {
	public static void main(String[] args) {
		Properties props = System.getProperties();
		props.list(System.out);
		System.out.println("--------------------");
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		System.out.println("운영체제 이름 : "+ osName);
		System.out.println("사용자 이름 : "+ userName);
		System.out.println("사용자 홈디렉토리 : "+ userHome);
		
	}
}
