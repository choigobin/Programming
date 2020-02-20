
public class Exam_02 {

	public static void main(String[] args) {
		int a=(int)(7/5.); // 형변환-강제형변환(데이터가 잘려나갈 수 있음)
		int b=7%5;
		System.out.println("7/5=" + a);
		System.out.println("7%5=" + b);
		System.out.println("7/5=" + 7/5.);
		System.out.println("7%5=" + 7%5);
		
		//int var = 3.14; int = 4byte, double = 8byte -> 4바이트에 8바이트값을 넣어서 에러
		int var = (int)3.14;
		double d =a;	//자동형변환
		double d2 = 90; //자동형변환//90.//(double)90
		System.out.println("d=" + d);
		System.out.println("d2=" + d2);
		System.out.println("var=" + var);
	}

}
