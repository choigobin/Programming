
public class Exam_02 {
	public static void main(String[] args) {
		int bun[] = new int[5];
		String[] name = new String[5];
		bun[0]=1;
		bun[1]=10;
		bun[2]=100;
		bun[3]=1000;
		bun[4]=10000;
		name[0]="김자바";
		name[1]="홍길동";
		name[2]="C/C++";
		name[3]="파이썬";
		name[4]="서블릿";
		
		for(int x=0; x<5; x++) {
			System.out.println(bun[x] + ":" + name[x]);
		}
		
	}
}

