package student;

import java.util.ArrayList;
import java.util.Collections;

public class StudentData {
	ArrayList<Student> list;
	StudentData(){}
	StudentData(ArrayList<Student> list){
		this.list = list;
		cal();
	}
	
	void cal() {
		for(int x=0; x<list.size(); x++) {
			list.get(x).rank = 1;
			for(int s=0; s<5; s++) {
				list.get(x).tot += list.get(x).score[s];
			}
			list.get(x).ave = ((int)(list.get(x).tot/5.*100+0.5))/100.;
		}
		for(int x=0; x<list.size(); x++) {
			for(int y=0; y<list.size();y++) {
				if(list.get(x).tot<list.get(y).tot) {
					list.get(x).rank++;
				}
			}
		}
	}
	
	void print() {
		System.out.println("번호\t이름\t점수1\t점수2\t점수3\t점수4\t점수5\t총점\t평균\t석차");
		for(Student s : list) {
			System.out.println(s);
		}
	}
	void sort() {
		for(int x=0; x<list.size(); x++) {
			for(int y=x+1; y<list.size();y++) {
				if(list.get(x).rank>list.get(y).rank) {
					Collections.swap(list, x, y);
				}
			}
		}
		
	}
	
}
