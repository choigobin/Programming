public class HakData {
	Hak[] hak;
	
	HakData(){}
	HakData(Hak[] hak){
		this.hak = hak;
	}
	
	void print() {
		for(int x=0; x<hak.length; x++) {
			System.out.print(hak[x].bun+"\t");
			System.out.print(hak[x].name+"\t");
			System.out.print(hak[x].score+"\n");
		}
	}
	
	void printA() {
		for(int x=0; x<hak.length; x++) {
			hak[x].print();
		}
	}
	
}
