package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4
public class StudentExam {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("정답 입력 : ");
		int[] answer = new int[20];
		for(int i=0; i<20; i++) {
			answer[i] = sc.nextInt();
		}
		sc.close();
		Student[] stData = new Student[10];
		int cnt=0;
		Scanner scF = new Scanner(new File("data.txt"));
		while(scF.hasNext()) {
			String xx = scF.nextLine().replace("\uFEFF", "");//utf-8의 bom 제거!!
			String[] str = xx.split(",");
			stData[cnt] = new Student(str);
			cnt++;
		}
		scF.close();
		StudentData stD = new StudentData(stData, answer,cnt);
		stD.print();
		
	}
}
