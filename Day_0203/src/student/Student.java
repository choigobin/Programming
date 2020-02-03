package student;
public class Student {
	int bun;
	String name;
	int[] score;
	int tot;
	double ave;
	int rank;
	
	Student(){}
	Student(int bun,String name,int[] score){
		this.bun = bun;
		this.name = name;
		this.score = score;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s = (Student)obj;
			return s.bun==bun;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return ""+bun+"\t"+name+"\t"+score[0]+"\t"+score[1]+"\t"+score[2]+"\t"+score[3]+"\t"+score[4]+"\t"+tot+"\t"+ave+"\t"+rank;
	}
	
}
