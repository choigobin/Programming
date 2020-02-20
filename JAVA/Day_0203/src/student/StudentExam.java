package student;

import java.util.ArrayList;
import java.util.Scanner;

/*	1. 키보드 입력
 * 		입력 : 번호,이름,점수,점수,점수,점수,점수
 * 	2. 처리조건
 * 		- 입력시 번호가 '0' 이면 입력 종료
 * 		- 번호가 중복시 입력 불가 하도록 처리
 * 		- 총점기준으로 석차 부여
 * 		- 1차 출력은 입력 자료순으로 하고
 * 		- 2차 출력은 석차 순으로 출력한다.
 * 	3. 출력
 * 		번호	이름	점수1	...	점수5	총점	평균	석차
 */
public class StudentExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		while(true) {
			System.out.print("입력(b,n,1,2,3,4,5) : ");
			String s = sc.nextLine();
			String[] str = s.split(",");
			if(str[0].equals("0")) {
				break;
			}
			int[] score = {Integer.parseInt(str[2]),Integer.parseInt(str[3]),Integer.parseInt(str[4]),Integer.parseInt(str[5]),Integer.parseInt(str[6])};
			Student st = new Student(Integer.parseInt(str[0]),str[1],score) ;
			if(list.contains(st)) {
				System.out.println("\t\t번호 중복 불가");
			}else {
				list.add(st);
			}
		}
		sc.close();
		StudentData std = new StudentData(list);
		std.print();
		std.sort();
		std.print();
		
		
	}
}
