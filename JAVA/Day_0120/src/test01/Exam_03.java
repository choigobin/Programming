package test01;
// 생성자의 연속 호출
class FF{
	FF(){
		System.out.println("FF() 생성자 호출");
	}
}
class GG extends FF{
	GG(){
		System.out.println("GG() 생성자 호출");
	}
}
class HH extends GG{
	HH(){
		System.out.println("HH() 생성자 호출");
	}
}
public class Exam_03 {

	public static void main(String[] args) {
		HH h1 = new HH();
	}

}
