import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*	아래와 같이 args사전(Map)에 이름과 나이가 저장되어 있다.
 * 	(이름이 '키' 이므로 같은 이름이 없다고 가정한다)
 * 	args['Alice']=23,	args['Paul']=25
 * 	args['Peter']=19,	args['Karen']=40
 * 	args['Andy']=25,	args['Cindy']=30
 * 	args['David']=19,	args['Sally']=28
 * 	args['Tom']=22,		args['Sue']=28
 * 	args['Bob']=31
 * 	이를 사용해서 아래와 같은 실행 결과를 내는 프로그램을 작성
 * 	Enter name : Peter
 * 	Peter is 19 years old
 * 	즉, 키를 입력받아 키에 해당하는 나이를 찾아 출력하는 프로그램을 작성하시오.
 */
public class Exam_02 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Alice", 23);	map.put("Paul", 25);
		map.put("Peter", 19);	map.put("Karen", 40);
		map.put("Andy", 25); 	map.put("Cindy", 30);
		map.put("David", 19); 	map.put("Sally", 28);
		map.put("Tom", 22); 	map.put("Sue", 28);
		map.put("Bob", 31);
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.print("Enter name : ");
			String x = sc.nextLine();
			if(x.equals("end")) {
				break;
			}else if(map.containsKey(x)) {
				System.out.println(x+" is "+map.get(x)+" years old");
			}else {
				System.out.println("This name does not");
			}
		}
		sc.close();
	}
}
