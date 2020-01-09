import java.util.Scanner;

/*	번호, 이름, 국어점수, 영어점수, 수학점수를
 * 	입력받아서 총점, 평균을 계산하여 출력
 */
public class Exam_08 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("번호 : ");
		int bun = scn.nextInt();
		
		System.out.println("이름 : ");
		String name = scn.next();
		
		System.out.println("국어점수 : ");
		int kor = scn.nextInt();

		System.out.println("수학점수 : ");
		int mat = scn.nextInt();

		System.out.println("영어점수 : ");
		int eng = scn.nextInt();
		
		int tot = kor+mat+eng;
		double avg = tot/3.;
		scn.close();
		System.out.println("번호\t이름\t국어점수\t수학점수\t영어점수\t총점\t평균");
		System.out.println(bun+"\t"+name+"\t"+kor+"\t"+mat+"\t"+eng+"\t"+tot+"\t"+avg);
	}

}
