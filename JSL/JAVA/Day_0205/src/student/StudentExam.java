package student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		while(true) {
			int y,c,n,score;
			String hak,name;
			boolean end = false;
			while(true) {
				System.out.print("학년 : ");
				y = sc.nextInt();
				if(y==0) {
					end = true;
					break;
				}else if(y>0 && y<4) {
					break;
				}else {
					System.out.println("학년(1~3)을 재입력 하시오.");
				}
			}
			if(end) {
				System.out.println("입력 종료");
				break;
			}
			while(true) {
				System.out.print("반 : ");
				c = sc.nextInt();
				if(c>0 && c<7) {
					break;
				}else {
					System.out.println("반(1~6)을 재입력 하시오.");
				}
			}
			while(true) {
				System.out.print("번호 : ");
				n = sc.nextInt();
				if(n>0 && n<46) {
					break;
				}else {
					System.out.println("번호(1~45)를 재입력 하시오.");
				}
			}
			while(true) {
				System.out.print("이름 : ");
				name = sc.next();
				if(name.length()<11) {
					break;
				}else {
					System.out.println("이름(10자이내)을 재입력 하시오.");
				}
			}
			while(true) {
				System.out.print("점수 : ");
				score = sc.nextInt();
				if(score>=0 && score<=100) {
					break;
				}else {
					System.out.println("점수(0~100)를 재입력 하시오.");
				}
			}
			hak = y+"-"+c+"-"+n;
			Student st = new Student(hak,name,score);
			if(list.contains(st)) {
				System.out.println("이미 등록된 학생입니다.");
			}else {
				list.add(st);
				System.out.println("학생 등록 완료");
			}
		}
		sc.close();
		StudentData std = new StudentData(list);
		std.printAll();
		
	}
}
