package antProject;

public class SampleClass {

	public static void main(String[] args) {
		
		new HelperClass().printDate();

	}

}

class HelperClass {
	
	void printDate() {
		
		java.util.Date dt = new java.util.Date();
		
		System.out.println(dt);
		
	}
	
}
