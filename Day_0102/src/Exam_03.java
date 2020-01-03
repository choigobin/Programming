import java.util.Scanner;

/*	주차요금 계산 프로그램 작성
 * 	키보드로 차량번호, 주차시간(분)을 입력
 * 	예)	차량번호 : 1234
 * 		주차시간 : 42
 * 		주차요금 계산
 * 		차량번호	요금
 * 		1234	1500원
 * 	-주차가능 시간은 최대 하루(24시간)(1440분)
 * 	-주차요금은 10분미만 무료, 30분까지 500원,30분 이후부터는 10분당 500원 계산
 * 	-하루주차요금은 최대 30000원만 징수한다.
 */
public class Exam_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("차량번호 : ");
		int car = sc.nextInt();
		System.out.print("주차시간 : ");
		int min = sc.nextInt();
		sc.close();
		int fee=0;
		if(min>=10 && min<=30) {
			fee=500;
		}else {
			min-=21;
			fee+=(min/10)*500+500;
			if(fee>30000) fee=30000;
		}
		System.out.println("차량번호\t요금");
		System.out.println(car+"\t"+fee+"원");
		
	}
}
