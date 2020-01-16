
public class SawonData {
	Sawon[] sa;
	int cnt;
	SawonData(Sawon[] sa,int cnt){
		this.sa = sa;
		this.cnt = cnt;
	}
	void calSa(){
		for(int i=0; i<cnt; i++) {
			int pay = sa[i].data[1];
			int unit = 50000; 
			for(int j=2; j<12; j++) {
				sa[i].data[j] = pay/unit;
				pay%=unit;
				if(j%2==0) {
					unit/=5;
				}else {
					unit/=2;
				}
			}
		}
		for(int i=0; i<cnt; i++) {
			for(int j=1; j<12; j++) {
				sa[10].data[j]+=sa[i].data[j];  //합계
			}
		}
	}
	void print() {
		calSa();
		System.out.print("사번\t이름\t급여\t");
		int unit = 50000; 
		for(int j=2; j<12; j++) {
			System.out.print(unit+"\t");
			if(j%2==0) {
				unit/=5;
			}else {
				unit/=2;
			}
		}
		System.out.println();
		for(int i=0; i<cnt; i++) {
			System.out.print(sa[i].data[0]+"\t");
			System.out.print(sa[i].name+"\t");
			for(int j=1; j<12; j++) {
				System.out.print(sa[i].data[j]+"\t"); //50,000
			}
			System.out.println();
		}
		System.out.print("합계\t\t");
		for(int j=1; j<12; j++) {
			System.out.print(sa[10].data[j]+"\t");
		}
	}
	
}
