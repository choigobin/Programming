package p0813;

public class TryCatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {0,1,2};
		try {
			System.out.println("첫번째 원소 : "+array[0]);
			//System.out.println("마지막 원소 : "+array[3]);
			int num1=10;
			int result;
			result= num1/0;
			}/*catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("원소가 존재하지 않습니다.");
			}catch(ArithmeticException e) {
				System.out.println("0으로 나누면 안됩니다.");
			}*/
			 catch(Exception e) {
				 System.out.println("오류입니다");
				 e.printStackTrace();
			 }finally {
				 System.out.println("무조건 수행"); 
			 }	
		System.out.println("어이쿠!!!");
		
}}
