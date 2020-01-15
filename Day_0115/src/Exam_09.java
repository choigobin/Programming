/*	싱글톤(singleton)
 */
class DataB{
	private static DataB data = new DataB();
	private DataB() {}
	static DataB getInstance() {
		return data;
	}
	
}
public class Exam_09 {

	public static void main(String[] args) {
		DataB d1 = DataB.getInstance();
		DataB d2 = DataB.getInstance();
		
		System.out.println("d1==d2 : "+ (d1==d2));
		
		
	}

}
