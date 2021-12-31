package student;

public class StudentData {
	Student[] stData;
	int[] answer;
	Student[] stCal;
	int cnt;
	int[] poca = new int[20];
	StudentData(Student[] stData,int[] answer,int cnt){
		this.stData = stData;
		this.answer = answer;
		this.cnt = cnt;
	}
	void Cal() {
		stCal = stData.clone();
		for(int i=0; i<cnt; i++) {
			for(int a=0; a<20; a++) {
				if(stCal[i].data[a] == answer[a]) {
					stCal[i].data[a] = 'o';//111
				}else {
					stCal[i].data[a] = 'x';//120
				}
			}
		}
	}
	void print() {
		Cal();
		System.out.print("번호\t이름\t");
		for(int i=1; i<21; i++) {
			System.out.print(i+"\t");
		}
		System.out.println("점수");
		for(int i=0; i<cnt; i++) {
			System.out.print(stCal[i].bun+"\t");
			System.out.print(stCal[i].name+"\t");
			int score = 0;
			for(int a=0; a<20; a++) {
				String x = "";
				switch (stCal[i].data[a]) {
				case 111:
					x = "o";
					score +=5;
					poca[a]++;
					break;

				case 120:
					x = "x";
					break;
				}
				System.out.print(x+"\t");
			}
			System.out.println(score);
		}
		System.out.print("정답률\t\t");
		for(int a=0; a<20; a++) {
			System.out.print(((int)((double)poca[a]/cnt*100+0.5))/1.+"%\t");
		}
	}
}
