/*	객체 비교
 */
class DataA{
	static int id=10;//static 클래스가 로딩되는 순간 만들어짐 => 나머지는 실행되는 순간 만들어짐
	int pw=111;
	
}

public class Exam_08 {
	public static void main(String[] args) {
		DataA a1 = new DataA();
		//a1.id = 333;
		DataA.id = 555;
		DataA a2 = new DataA();
		
		System.out.println("a1==a2 : "+ (a1==a2));
		//System.out.println("a1.id==a2.id : "+ (a1.id==a2.id));
		//System.out.println(a1.id);
		//System.out.println(a2.id);
		System.out.println(DataA.id);
		
	}

}
