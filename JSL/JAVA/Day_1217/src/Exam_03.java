
public class Exam_03 {
	public static void main(String[] args) {
		int bun = 10;
		char irum ='k';
		int kor = 95;
		int eng=88,mat=77;
		//총점 계산
		int tot = kor+eng+mat;
		//평균
		double ave=tot/3.;//tot/3 -> 정수 나머지 버림 //tot/3. -> 실수 나머지 살림
		
		System.out.println("번호 = " + bun);
		System.out.println("이름 = " + irum);
		System.out.println("총점 = " + tot);
		System.out.println("평균 = " + ave);
		System.out.println();
		System.out.print("번호\t이름\t국어\t영어\t수학\t총점\t평균\n");
		System.out.print(bun+"\t"+irum+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+ave);
	}
}
