/*
[키보드 입력] 
- 번호, 이름, 점수를 입력
예시)
입력 : 1 홍길동 100
[출력]
번호     이름     점수    그래프 (10점당 '*' 1개)
1   홍길동    100  *********
 */
class Hak2{
	int bun;
	String name;
	int score;
	
	Hak2() {}
	Hak2(int b, String n, int s){
		bun = b;
		name = n;
		score = s;
	}
}



public class Exam_07 {
	public static void main(String[] args) {
		//키보드로 입력 했다고 가정
		int bun = 1;
		String name = "홍길동";
		int score = 90;
		
		//1번 - 디폴트 생성자 이용
		Hak2 h1 = new Hak2();
		h1.bun = bun;
		h1.name = name;
		h1.score = score;
		
		System.out.print(h1.bun+"\t"+h1.name+"\t");
		
		for(int x = 0; x < h1.score; x++) {
			if(x%10==0) {
				System.out.print("*");
			}
		}
		System.out.println();
		
		//2번 - 생성자 이용
		Hak2 h2 = new Hak2(2,"최강민",20);
		System.out.print(h2.bun+"\t"+h2.name+"\t");
		
		for(int x = 0; x < h2.score; x++) {
			if(x%10==0) {
				System.out.print("*");
			}
		}
		System.out.println();
		
		
		
		
		
		
	}
}