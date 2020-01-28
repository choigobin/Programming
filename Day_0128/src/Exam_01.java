import java.util.Scanner;

/*	키보드로 영문 단어를 입력
 * 	영문자의 빈도수를 출력(대소문자 구분 없음)
 * 	입력 예시
 * 	단어 : Apple
 * 	단어 : Seoul
 * 		.	.
 * 	단어 : end(또는 END) --> 종료
 * 	출력 예시
 * 	A B C D ... Z
 * 	1 0 2 3 ... 1 
 */
class AlphaTest{
	//String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};//26개
	int[] frequency = new int[26];
	
	void insert(String str) {
		for(int x=0; x<str.length(); x++) {
			char ch = str.charAt(x);
			if(ch>='A' && ch<='Z') {
				frequency[ch-65]++;
			}
		}
		/*
		for(int i=0; i<26; i++) {
			for(int s=0; s<str.length(); s++) {
				//if(alphabet[i].equalsIgnoreCase(str.substring(s,s+1)))
				if(alphabet[i].equals(str.substring(s,s+1))) { //입력받은 문자열을 대문자로 바꿨음
					frequency[i]++;
				}
			}
		}
		*/
	}
	
	void print() {
		/*
		for(int i=0; i<26; i++) {
			System.out.print(alphabet[i]+"\t");
		}
		*/
		for(char ch = 'A';ch<='Z';ch++) {
			System.out.print(ch+"\t");
		}
		System.out.println();
		for(int i=0; i<26; i++) {
			System.out.print(frequency[i]+"\t");
		}
		System.out.println();
	}
	void printBest() {
		System.out.println("가장 높은 빈도수");
		int best = 0;
		int point = 0;
		for(int i=0;i<26;i++) {
			if(best<frequency[i]) {
				best = frequency[i];
				point = i;
			}
		}
		System.out.println((char)(point+65)+" : "+best);
	}
	void printWorst() {
		System.out.println("한 번도 나오지 않은 알파벳");
		for(int i=0;i<26;i++) {
			if(frequency[i]==0) {
				System.out.print((char)(i+65)+"\t");
			}
		}
	}
}
public class Exam_01 {
	public static void main(String[] args) {
		// 입력
		AlphaTest alpha = new AlphaTest();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("단어 : ");
			String str = sc.nextLine().toUpperCase();
			if(str.equals("END")) {
				System.out.println("입력 종료");
				break;
			}
			alpha.insert(str);
		}
		sc.close();
		// 출력
		alpha.print();
		alpha.printBest();
		alpha.printWorst();
		
	}

}
