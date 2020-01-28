import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

/*	파일(test.txt)로 학생정보를 입력 받아서
 * 	총점 평균을 구하여 출력
 */
class Hak2{
	int bun;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;
	
	Hak2(int bun,String name,int kor,int eng,int mat){
		this.bun = bun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.ave = (int)(tot/3.*100+0.5)/100.;
	}
	@Override
		public String toString() {
			StringBuffer data = new StringBuffer();
			data.append(bun+"\t");
			data.append(name+"\t");
			data.append(kor+"\t");
			data.append(eng+"\t");
			data.append(mat+"\t");
			data.append(tot+"\t");
			data.append(ave+"\n");
			return data.toString();
		}
}

public class Exam_06 {
	public static void main(String[] args) throws Exception {
		Scanner scF = new Scanner(new File("test.txt"));
		StringTokenizer st = null;
		Hak2 hak2 = null;
		while(scF.hasNext()) {
			String str = scF.nextLine().replace("\uFEFF", ""); //utf-8의 bom 제거!!
			st = new StringTokenizer(str,", ");
			int bun = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int mat = Integer.parseInt(st.nextToken());
			hak2 = new Hak2(bun,name,kor,eng,mat);
			System.out.print(hak2);
		}
		scF.close();
		
	}

}
