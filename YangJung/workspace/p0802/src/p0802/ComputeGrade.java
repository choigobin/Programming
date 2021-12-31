package p0802;

import java.util.Scanner;

public class ComputeGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int att,repo,hig,mid,fin;
		double grade;
		
		System.out.print("출석 점수를 입력하세요. : ");
		att= s.nextInt();
		System.out.print("과제 점수를 입력하세요. : ");
		repo= s.nextInt();
		System.out.print("수시시험 점수를 입력하세요. : ");
		hig= s.nextInt();
		System.out.print("중간시험 점수를 입력하세요. : ");
		mid= s.nextInt();
		System.out.print("기말시험 점수를 입력하세요. : ");
		fin= s.nextInt();
		
		grade=att*0.1+repo*0.4+hig*0.1+mid*0.2+fin*0.2;
		
		if(grade>=90) {
			System.out.println("총점:      "+grade);
			System.out.println("학점:      A");
		}
		else if(grade>=80) {
			System.out.println("총점:      "+grade);
			System.out.println("학점:      B");
		}
		else if(grade>=70) {
			System.out.println("총점:      "+grade);
			System.out.println("학점:      C");
		}
		else if(grade>=60) {
			System.out.println("총점:      "+grade);
			System.out.println("학점:      D");
		}
		else {
			System.out.println("총점:      "+grade);
			System.out.println("학점:      F");
		}
	}

}
