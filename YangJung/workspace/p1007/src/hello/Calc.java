package hello;

public class Calc {
	int result = 0;
	
	public Calc(int num1, int num2, String op) {
		
		if(op.equals("+")) {
			result = num1 + num2;
		}
		else if(op.equals("-")) {
			result = num1 - num2;
		}
		else if(op.equals("*")) {
			result = num1 * num2;
		}
		else if(op.equals("/")) {
			result = num1 / num2;
		}
		//return result;
	}	
	public int getResult() {
		return result;
	}
}
