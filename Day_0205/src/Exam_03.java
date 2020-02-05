/*	리스트 words에는 여러 개의 영어 단어가 입력되어 있다.
 * 	입력된 단어들 중에서 가장 길이가 긴 단어를 출력하는 프로그램을 작성
 * 	가장 긴 단어가 여러 개인 경우에는 모두 출력한다.
 * 	words = ["hello","tall","school","hi","hey"];
 * 	output : school
 */
public class Exam_03 {
	public static void main(String[] args) {
		String[] words = {"hello","tall","school","hi","hey","banana"};
 		int max=0;
		for(int x=0; x<words.length; x++) {
 			if(max<words[x].length()){
 				max = words[x].length();
 			}
 		}
		System.out.print("output : ");
		for(int x=0; x<words.length; x++) {
			if(max==words[x].length()){
				System.out.print(words[x]+" ");
			}
		}
		System.out.println();
		
	}
}
