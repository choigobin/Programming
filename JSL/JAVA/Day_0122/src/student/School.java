package student;

public class School {
	Student[] st;
	int cnt;
	int tot[];
	double avg[];
	int rank[];
	School(Student[] st,int cnt){
		this.st = st;
		this.cnt = cnt;
		this.tot = new int[cnt];
		this.avg = new double[cnt];
		this.rank = new int[cnt];
	}
	void cal(){
		for(int i=0; i<cnt; i++) {
			//총점
			for(int j=0;j<3;j++) {
				tot[i]+=st[i].score[j];
			}
			//평균
			avg[i]= ((int)(tot[i]/3.*100+0.5))/100.;
			//석차
			rank[i] = 1;
		}
		for(int i=0; i<cnt; i++) {
			for(int r=0;r<cnt;r++) {
				if(tot[i]<tot[r]) {
					rank[i]++;
				}
			}
		}
	}
	void sort() {
		cal();
		for(int i=0; i<cnt-1; i++) {
			for(int j=i+1;j<cnt;j++) {
				if(st[i].bun>st[j].bun) {
					Student t = st[i];
					st[i] = st[j];
					st[j] = t;
					int temp = tot[i];
					tot[i] = tot[j];
					tot[j] = temp;
					temp = rank[i];
					rank[i] =rank[j];
					rank[j] = temp;
					double rt = avg[i];
					avg[i] = avg[j];
					avg[j] = rt;
				}
			}
		}
	}
	void print() {
		sort();
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t석차");
		for(int i=0; i<cnt; i++) {
			System.out.print(st[i].bun+"\t");
			System.out.print(st[i].name+"\t");
			System.out.print(st[i].score[0]+"\t");
			System.out.print(st[i].score[1]+"\t");
			System.out.print(st[i].score[2]+"\t");
			System.out.print(tot[i]+"\t");
			System.out.print(avg[i]+"\t");
			System.out.print(rank[i]+"\n");
		}
	
	}
	
	
}
