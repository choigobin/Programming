package textstream;
public class Student implements Comparable<Student>{
	int bun;
	String name;
	String gender;
	int kor,eng,mat;
	Student(){}
	Student(int bun,String name,String gender,int kor,int eng,int mat){
		this.bun = bun;
		this.name = name;
		this.gender = gender;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	@Override
	public int compareTo(Student o) {
		if(o.bun > bun) {
			return -1;
		}else if(o.bun==bun) {
			return 0;
		}else {
			return 1;
		}
	}
	
}
