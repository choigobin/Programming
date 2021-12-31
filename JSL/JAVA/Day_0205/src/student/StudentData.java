package student;

import java.util.ArrayList;

public class StudentData {
	ArrayList<Student> list;
	public StudentData(ArrayList<Student> list) {
		this.list = list;
	}
	void printAll() {
		System.out.println("학번\t이름\t점수\t학점");
		for(int x=0; x<list.size(); x++) {
			Student st = list.get(x);
			System.out.print(st.hak+"\t");
			System.out.print(st.name+"\t");
			System.out.print(st.score+"\t");
			System.out.println(grade(st.score));
		}
		
	}
	char grade(int score) {
		char grade;
		if(score>=90) {
			grade = 'A';
		}else if(score>=80) {
			grade = 'B';
		}else if(score>=70) {
			grade = 'C';
		}else if(score>=60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		return grade;
	}
	
}
