/*	if(조건식){
 * 		문장1;
 * 	}else if(조건식2){
 * 		문장2;
 * 	}else if(조건식3){
 * 		문장3;
 * 	}else if(조건식n){
 * 		문장n;
 * 	}else{
 * 		문장n+1;
 * 	}
 * 
 */
public class Exam_08 {
	public static void main(String[] args) {
		int a=70;
		String rank="";
		if(a>=90) {
			rank="A+";
		}else if(a>=80) {
			rank="A";
		}else if(a>=70) {
			rank="B+";
		}else if(a>=60) {
			rank="B";
		}else {
			rank="C";
		}
		System.out.println("등급  : "+rank);
	}

}
