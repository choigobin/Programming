
public class Exam_03 {
	public static void main(String[] args) {
		int money = 327658;
		int m=50000;
		boolean sw=true;
		for(int x=1;x<=10;x++) {
			int s=money/m;
			System.out.println(m+" : "+s);
			if(sw) {
				money = money%m;//money=money-(s*m);
				m=m/5;
				sw=false;
			}else {
				money = money%m;
				m=m/2;
				sw=true;
			}
		}
		
		
		
	}
}
