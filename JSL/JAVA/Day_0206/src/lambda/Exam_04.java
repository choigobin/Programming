package lambda;
@FunctionalInterface
interface DDD{
	int test(int x, int y);
}
public class Exam_04 {
	public static void main(String[] args) {
		DDD d;
		d=(x,y)->{
			int r = x*y;
			return r;
		};
		int sum = d.test(10, 20);
		System.out.println(sum);
		d=(x,y)->{
			int s=0;
			for(int i=x; i<y; i++) {
				s+=i;
			}
			return s;
		};
		System.out.println("sum = "+d.test(1, 11));
		
	}
}
