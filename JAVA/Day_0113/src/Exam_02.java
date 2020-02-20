public class Exam_02 {
	public static void main(String[] args) {
		
		Tv tv1; 
		tv1 = new Tv();
		//Tv tv1 = new Tv();
		tv1.color = "red";
		tv1.channel = 0;
		tv1.power = false;
		
		String str ;
		str = new String("AAA");
		System.out.println("str = "+str); // 얘는 값이 찍히고 -> 왜? String은 좀 특이한 케이스라서 그럼(오버라이딩 되어있음)
		System.out.println("tv1 = "+tv1); // 얘는 주소가 찍힌다.
		
		System.out.println("전원 상태 : "+tv1.power);
		tv1.channelUp();
		tv1.channelUp();
		tv1.channelUp();
		System.out.println("채널 상태 : "+tv1.channel);
		
	}
}
