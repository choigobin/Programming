import java.util.regex.Pattern;

/*	uncompress 함수는 숫자와 알파벳으로 구성된 문자열을 입력받아서
 * 	숫자만큼 알파벳을 반복시켜 변환하는 함수이다.
 * 	ex)
 * 	uncompress("2a5b1c") => aabbbbbc
 * 	uncompress("3x5y2z") => xxxyyyyyzz
 * 	이 때 숫자는 1~9사이에 있는 숫자이다.
 * 	숫자와 문자열이 반복되어 나온다. 즉 1~9 사이의 숫자 뒤에 알파벳이 하나 나오는 패턴
 * 	#main
 * 	String[] S = {"2a5b1c","3x5y2z","2m4n","9o"}
 * 	for(String string : S){
 * 		String new_string = uncompress(string);
 * 		System.out.print(string+":"+new_string);	
 * 	}
 * 1) 숫자만 : ^[0-9]*$
 * 2) 영문자만 : ^[a-zA-Z]*$
 */
public class Exam_05 {
	static String uncompress(String string) {
		boolean bool = Pattern.matches("(\\d{1}[a-zA-Z]{1})+", string);
		if(bool) {
			StringBuilder ucom = new StringBuilder();
			for(int x=0; x<string.length(); x+=2) {
				for(int y=0; y<Integer.parseInt(string.substring(x, x+1)); y++) {
					ucom.append(string.substring(x+1,x+2));
				}
			}
			return ucom.toString();
		}else {
			return "error";
		}
	}
	public static void main(String[] args) {
		String[] S = {"2a5b1c","3x5y2z","2m4n","9o"};
		for(String string : S){
		  	String new_string = uncompress(string);
		  	System.out.println(string+":"+new_string);	
		 }
		
		
		
	}

}
