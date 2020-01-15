public class SawonData {
	
	void sourceDataPrint() {
		
	}
	void sourceDataPrint(Sawon[] sa ,int cnt) {
		System.out.println("sourceData");
		for(int i=0;i<cnt;i++) {
			sa[i].print();
		}
	}
	void sortDataPrint(Sawon[] s ,int cnt,int n) {//n=>1.오름차순 /2.내림차순 
		Sawon[] sa = new Sawon[cnt];
		for(int i=0;i<cnt;i++) {
			sa[i] = s[i];
		}
		System.out.println("sortData");
		for(int i=0;i<cnt-1;i++) {
			if(n==1) {
				for(int j=i+1;j<cnt;j++) {
					if(sa[i].sabun>sa[j].sabun) {
						Sawon temp = new Sawon();
						temp = sa[i]; //값을 바꾸는 것이 아니라 주소를 바꾸는 것 => 배열에 속해있는 값들 전부다 따라 바뀜
						sa[i] = sa[j];
						sa[j] = temp;
					}
				}
			}else {
				for(int j=i+1;j<cnt;j++) {
					if(sa[i].sabun<sa[j].sabun) {
						Sawon temp = new Sawon();
						temp = sa[i];
						sa[i] = sa[j];
						sa[j] = temp;
					}
				}
			}
			
		}
		for(int i=0;i<cnt;i++) {
			sa[i].print();
		}
	}
	
}
