package p0809;

public class StudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student park = new Student();
		park.name = "박씨";
		park.no = 1;
		park.eng=50;
		park.kor=70;
		park.mat=30;
		park.print();
		
		Student lee = new Student();
		lee.name = "이씨";
		lee.no = 2;
		lee.eng=30;
		lee.kor=50;
		lee.mat=40;
		lee.print();
		
		Student yoon = new Student();
		yoon.name = "윤씨";
		yoon.no = 3;
		yoon.eng=70;
		yoon.kor=90;
		yoon.mat=50;
		yoon.print();
		
		
	}
}
