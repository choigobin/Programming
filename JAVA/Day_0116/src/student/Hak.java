package student;
/*	자바 빈 파일(데이터 전송용) 만들기 -POJO(Plan Old Java Object)
 * 	java beans
 * 	ex) XxxBeans / XxxVO(Value Object) / XxxDTO(Data Transfer Object) 
 */
public class Hak {
	private int bun;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double ave;
	private int rank;
	
	public int getBun() {
		return bun;
	}
	public void setBun(int bun) {
		this.bun = bun;
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
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAve() {
		return ave;
	}
	public void setAve(double ave) {
		this.ave = ave;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
