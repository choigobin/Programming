package student;
/*	1)입력				2)출력							4) class 설계
 * 	학년	:1				학번		이름		점수		학점			학번	이름	점수
 * 	반	:1				1-1-1	홍길동	95		A			문자	문자	숫자
 * 	번호	:1				3)점수{90 -> A 60-> D				6	10	3
 * 	이름	:홍길동				 {80 -> B 60 미만 F
 * 	점수	:95					 {70 -> C
 * 	- 학년이 0이면 종료
 * 	- 유효성 체크{학년(1~3)
 * 	    항목별	  {반(1~6)
 * 	    개별	  {번호(1~45)
 * 	    재입력	  {점수(0~100)
 */
public class Student {
	String hak;
	String name;
	int score;
	Student(){}
	Student(String hak,String name,int score){
		this.hak = hak;
		this.name = name;
		this.score = score;
	}
	@Override
		public boolean equals(Object obj) {
			if (obj instanceof Student) {
				Student st = (Student)obj;
				return st.hak.equals(hak);
			}else {
				return false;
			}
		}
}
