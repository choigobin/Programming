import java.util.Scanner;

/*
키보드 입력(최대10개)
오름 차순 정렬하는 클래스 생성
입력 : 2 6 9 7 5 8 9 1
출력
정렬전
2 6 9 7 5 8 9 1
정렬후
1 2 5 6 7 8 9 9 
 */

class HH{ // 오름차순 정렬 클래스
	
	//선택정렬 메소드
	void sort(int arr[],int cnt) { //arr - 참조에 의한 호출 , cnt - 값에 의한 호출
		for(int x = 0; x < cnt-1; x++) {
			for(int y = x+1; y < cnt; y++) {
				if(arr[x] > arr[y]) {
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
			}
		}//for문 끝
	}//sort메서드 끝
	
	//출력 메소드
	void arrPrint(int arr[],int cnt,String str) {
		System.out.println("["+str+"]");
		for(int x = 0; x < cnt; x++) {
			System.out.print(arr[x]+"\t");
		}System.out.println();
	}
	

	
	
}

public class Exam_08 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numberArr[] = new int[10];
		int cnt = 0;
		//입력 작업
		System.out.print("입력 : ");
		while(true) {
			int num = sc.nextInt();
			if(num == -99) break;
			numberArr[cnt] = num;
			cnt++;
			if(cnt == 10) break;		
		}
		
		//객체 생성
		HH h = new HH();
		
		//전 - 호출
		h.arrPrint(numberArr,cnt,"전");
		
		//정렬 메소드 호출
		h.sort(numberArr,cnt);
		
		//후 - 호출
		h.arrPrint(numberArr,cnt,"후");
		
	}
}