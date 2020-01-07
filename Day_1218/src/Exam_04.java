import java.util.Scanner;

/*	(정수)번호, 이름, 국어, 영어, 수학 점수를 키보드로 입력(점수는 소수점 첫째자리까지 입력가능)
 * 	총점, 평균(소수점 세번째 자리에서 반올림)
 */
public class Exam_04 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("번호 : ");
		int num = s.nextInt();
		System.out.print("이름 : ");//영어로 입력하면 문제없음
		String name = s.next();
		System.out.print("국어 : ");
		double kor = s.nextDouble();
		System.out.print("영어 : ");
		double eng = s.nextDouble();
		System.out.print("수학 : ");
		double mat = s.nextDouble();
		s.close();
		double tot = kor+eng+mat;
		double avg = tot/3.;// ex)87.256-> 87.26
		avg = (int)(avg*100+0.5)/100.;
		
		System.out.println("번호\t이름\t총점\t평균\t");
		System.out.println(num+"\t"+name+"\t"+tot+"\t"+avg);
	}

}