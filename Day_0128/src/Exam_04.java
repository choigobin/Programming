import java.io.File;
import java.util.Scanner;

/*	파일(test.txt)로 학생정보를 입력 받아서
 * 	총점 평균을 구하여 출력
 */
class Hak{
	int bun;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;
	
	Hak(String[] x){
		this.bun = Integer.parseInt(x[0]);
		this.name = x[1];
		this.kor = Integer.parseInt(x[2]);
		this.eng = Integer.parseInt(x[3]);
		this.mat = Integer.parseInt(x[4]);
		this.tot = kor+eng+mat;
		this.ave = (int)(tot/3.*100+0.5)/100.;
	}
	void print() {
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(bun+"\t"+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+ave);
	}
}

public class Exam_04 {
	public static void main(String[] args) throws Exception {
		Scanner scF = new Scanner(new File("test.txt"));
		Hak hak = null;
		while(scF.hasNext()) {
			String str =scF.nextLine().replace("\uFEFF", ""); //utf-8의 bom 제거!!
			String[] x = str.split(",");
			hak = new Hak(x);
			hak.print();
		}
		scF.close();

	}

}

