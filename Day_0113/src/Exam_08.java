import java.util.Scanner;

/*
[키보드 입력] 
- 번호, 이름, 점수를 입력
예시)
입력 : 1 홍길동 100
[출력]
번호     이름     점수    그래프 (10점당 '*' 1개)
1   홍길동    100  *********
 */
class Hak3{
	int bun;
	String name;
	int score;
	
	Hak3() {
//		dataPrint();
	}
	Hak3(int bun, String name, int score){ // 초기화 작업을 해줄 생성자
		//this(); // 자기자신의 메서드 == 자기자신의 생성자
		this.bun = bun;
		this.name = name;
		this.score = score;
		//여기서 this는 자기자신(class)을 가르킴
		dataPrint();
	}
	void dataPrint() {
		System.out.print(bun+"\t"+name+"\t");
		for(int x = 0; x < score; x++) {
			if(x % 10 == 0) {
				System.out.print("*");
			}
		}System.out.println();
	}
}



public class Exam_08 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Hak3 hak; // 이놈이 밖에 있는 이유는 변수를 한번만 만들어서 그걸 공유할려고
		while(true) {
			System.out.print("입력 : ");
			hak = new Hak3();
			hak.bun = sc.nextInt();
			if(hak.bun == -99) break;
			hak.name = sc.next();
			hak.score = sc.nextInt();
/*			
			System.out.print(hak.bun+"\t"+hak.name+"\t");
			for(int x = 0; x < hak.score; x++) {
				if(x % 10 == 0) {
					System.out.print("*");
				}
			}System.out.println();
*/			
			//위 주석 부분을 메서드로 빼버림
			hak.dataPrint();
		}
		
		
		
		
		
	}
}