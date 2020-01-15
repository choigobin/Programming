public class TvTest3 {
	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		System.out.println("t1의 channel값은 "+tv1.channel+"입니다.");
		System.out.println("t2의 channel값은 "+tv2.channel+"입니다.");
		
		tv2 = tv1;
		
		tv1.channel = 8;
		System.out.println("t1의 channel값을 8로 조정 하였습니다.");
		
		System.out.println("t1의 channel값은 "+tv1.channel+"입니다.");
		System.out.println("t2의 channel값은 "+tv2.channel+"입니다.");
		
		
	}
}