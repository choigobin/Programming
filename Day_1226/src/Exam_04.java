import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);//System.in => 키보드입력;
		
		System.out.print("번호입력 :");
		int bun = scn.nextInt();
		System.out.print("이름입력 :");
		String name = scn.next();
		System.out.print("국어점수 :");
		double kor=scn.nextDouble();
		System.out.print("영어점수 :");
		double eng=scn.nextDouble();
		System.out.print("수학점수 :");
		double mat=scn.nextDouble();
		
		//int tot = (int)(kor+eng+mat);
		double tot = kor+eng+mat;
		double ave = tot/3;
		
		System.out.println("성적표");
		System.out.println("번호\t이름\t총점\t평균");
		System.out.println(bun+"\t"+name+"\t"+tot+"\t"+ave);
		
		
	}
}
