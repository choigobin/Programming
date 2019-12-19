import java.util.Scanner;

/*	키보드 입력
 * 	번호 : 
 * 	국어 : 
 * 	영어 : 
 * 	수학 : 
 * 
 * 	출력
 * 	번호	국어	영어	수학	총점	평균	판정
 * 	
 * 	처리조건 :
 * 	총점 = 국어+영어+수학
 * 	평균 = 총점/3.
 * 	판정 : 평균이 60이상이고 3과목 모두 40이상 일 때 "합격"
 * 	1과목 이라도 40미안이면 "과락"
 * 	3과목 모두 40이상이나 평균이 60미만이면 "불합격"
 */
public class Exam_07 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("번호 : ");
		int num = s.nextInt();
		System.out.print("국어 : ");
		int kor = s.nextInt();
		System.out.print("영어 : ");
		int eng = s.nextInt();
		System.out.print("수학 : ");
		int mat = s.nextInt();
		int tot = kor+eng+mat;
		double avg = tot/3.;
		avg = (int)(avg*100+0.5)/100.;
		String pass = "";
		/*
		if(kor>=40 && eng>=40 && mat>=40) {
			if(avg>=60) {
				pass = "합격";
			}else {
				pass = "불합격";
			}
		}else {
			pass = "과락";
		}
		*/
		
		if(kor>=40&&eng>=40&&mat>=40&&avg>=60) {
			pass = "합격";
		}else {
			if(avg<60) {
				pass="불합격";
			}else {
				pass="과락";
			}
		}
		
		System.out.println("\t번호\t국어\t영어\t수학\t총점\t평균\t판정");
		System.out.println("\t"+num+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg+"\t"+pass);
	}

}
