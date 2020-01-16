import java.util.Scanner;

/*	클래스 배열 처리
 * 	키보드 입력 - 최대 10명
 * 	입력 : 번호 이름 국어 영어 수학
 * 		.	.	.
 * 	출력(석차를 기준으로 오름차순)
 * 	번호 이름 국 영 수 총 평 석차
 * 	
 * 	번호가 -99 이면 입력 종료
 * 	1. 학생 정보 Student
 * 	2. 학생 정보 처리 StudentData
 * 	3. 자료 입력 main()
*/
public class Exam_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		Student stu[] = new Student[10];//Student클래스 배열 생성 ps) 열을 생성(자리 배정)
		while(cnt<10) {
			System.out.print("입력 : ");
			stu[cnt] = new Student();//Student클래스 생성 ps) 행을 생성(자리 배정)
			stu[cnt].data[0] = sc.nextInt();//번호
			if(stu[cnt].data[0]==-99) break;
			stu[cnt].name = sc.next();
			stu[cnt].data[1] = sc.nextInt();//국어
			stu[cnt].data[2] = sc.nextInt();//영어
			stu[cnt].data[3] = sc.nextInt();//수학
			stu[cnt].data[4] = stu[cnt].data[1]+stu[cnt].data[2]+stu[cnt].data[3];//총점
			stu[cnt].data[5] = (int)(stu[cnt].data[4]/3.*100+0.5)/100.;//평균
			stu[cnt].data[6] = 1;//석차	
			sc.nextLine();
			cnt++;
		}
		sc.close();
		StudentData studata = new StudentData();
		studata.sortPrint(stu, cnt);
	}

}
