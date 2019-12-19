import java.util.Scanner;

/*	if(조건식){ //참
 * 		문장1;
 * 	}else{ //거짓
 * 		문장2;
 * 	}
 * 	문장3;
 * 
 * 	문제 : 키보드로 점수를 입력 받아서 85 이상이면 "합격" 아니면 "불합격" 출력
 */
public class Exam_04 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = s.nextInt();
		
		String pass="";
		if(score>=85) {
			//System.out.println("합격");
			pass = "합격";
		}else {
			//System.out.println("불합격");
			pass = "불합격";
		}
		System.out.println("결과 : "+pass);
	}

}
