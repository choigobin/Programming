class Data{
	int x;
	int y;
}
public class Exam_04 {
	static void swap(int a, int b) {
		int c=a;
		a=b;
		b=c;
	}
	
	public static void main(String[] args) {
		int a=10;
		int b=20;
		System.out.println("a="+a +"\tb="+b);
		swap(a,b);//값에 의한 호출! 변수 a,b와는 관계없음 call by value
		System.out.println("a="+a +"\tb="+b);
		System.out.println("----------------------------------");
		Data d = new Data();
		d.x=10;
		d.y=20;
		System.out.println("d.x="+d.x +"\td.y="+d.y);
		swapD(d); // Data a의 자리에 d를 넣음 Data a = d; 
		System.out.println("d.x="+d.x +"\td.y="+d.y);
		System.out.println("----------------------------------");
		int s[] = {10,20};
		System.out.println("s[0]="+s[0]+"\ts[1]="+s[1]);
		swapA(s);
		System.out.println("s[0]="+s[0]+"\ts[1]="+s[1]);
		
	}
	
	static void swapA(int[] x) {
		int temp = x[0];
		x[0] = x[1];
		x[1] = temp;		
	}

	static void swapD(Data a) {
		int c = a.x;
		a.x = a.y;
		a.y = c;
	}
	
}
