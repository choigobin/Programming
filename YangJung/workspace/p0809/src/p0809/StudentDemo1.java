package p0809;

public class StudentDemo1 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Student1 park = new Student1(15412);
		//park.setNo(1);
		park.setName("박씨");
		park.setKor(90);
		park.setEng(70);
		park.setMat(50);
		park.print();
		System.out.println("합계: "+(park.getEng()+park.getKor()+park.getMat()));
		
		Student1 lee = new Student1();
		lee.setNo(2);
		lee.setName("이씨");
		lee.setKor(70);
		lee.setEng(60);
		lee.setMat(30);
		lee.print();
		
		Student1 yoon = new Student1(512,"윤씨",80,50,40);
		yoon.print();
		Student1 yoon1 = new Student1(512,"윤씨",80,50,40);
		yoon1.print();
		Student1 yoon11 = new Student1(512,"윤씨",80,50,40);
		yoon11.print();
		Student1 yoon111 = new Student1(512,"윤씨",80,50,40);
		yoon111.print();
		System.out.println(Student1.count);
		System.out.println(yoon111.count1);
		System.out.println(yoon.count);
		
	}
}
