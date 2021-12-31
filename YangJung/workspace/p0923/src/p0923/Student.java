package p0923;

class Student {
	private int stuNo;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	void print() {
		System.out.println("학번 : "+stuNo+ " 이름 : " +name+"\n국어 : "+kor+" 영어 : "+eng+" 수학 : "+mat);
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
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

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}
}
