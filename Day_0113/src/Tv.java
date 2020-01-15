public class Tv { 
	//Tv의 속성(멤버변수)
	String color; // 이렇게 정의 된 변수들은 "멤버변수(인스턴스 변수)"
	int channel;
	boolean power;
	
	//기능(메서드)
	void power() {
		power=!power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
	
}
