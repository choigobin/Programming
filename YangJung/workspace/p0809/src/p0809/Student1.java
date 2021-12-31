package p0809;

public class Student1 {
	private int no;
	private String name;
	private int kor,mat,eng;
	static int count=0;
	int count1=0;
	Student1(){
		System.out.println("생성자 호출");
	}
	Student1(int no){
		this.no=no;
	}
	
	Student1(int no,String name,int kor,int mat, int eng){
		this.no=no;
		this.name=name;
		this.kor=kor;
		this.mat=mat;
		this.eng=eng;
		count1++;
		count++;
	}
	
	void print() {
		System.out.println(no+"번 "+name+" 국어: "+kor+" 수학: "+mat+" 영어: "+eng);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	

}
