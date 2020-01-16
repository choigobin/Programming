import java.util.Scanner;

/*	키보드로 사원번호, 이름, 급여 입력(최대 10명)
 * 	사원번호가 -99 종료
 * 
 * 	입력 : 사번 이름 급여
 * 		.	.	.
 * 	출력
 * 	사번	이름	급여	50,000	10,000	5,000	...	1
 * 	 .	 .	 .
 * 	합계		xxx	xx		xx		xx			x
 * 	
 * 	사원(Sawon),사원처리(SawonData)
 */
public class Exam_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		Sawon sa[] = new Sawon[11];//클래스 배열 생성!
		sa[10] = new Sawon();//클래스 객체 생성!
		while(cnt<10) {
			sa[cnt] = new Sawon();//클래스 객체 생성!
			System.out.print("입력 : ");
			sa[cnt].data[0] = sc.nextInt();//사번
			if(sa[cnt].data[0]==-99) break;
			sa[cnt].name = sc.next();//이름
			sa[cnt].data[1] = sc.nextInt();//급여
			sc.nextLine();
			cnt++;//인원 카운트
		}
		sc.close();
		SawonData sadata = new SawonData(sa,cnt);
		sadata.print();
	}

}
