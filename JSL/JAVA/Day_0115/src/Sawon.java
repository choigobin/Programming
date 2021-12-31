public class Sawon {
	int sabun;
	String name;
	int pay;
	
	Sawon(){}
	Sawon(int sabun,String name,int pay){
		this.sabun = sabun;
		this.name = name;
		this.pay = pay;
	}
	void print() {
		System.out.println(sabun+"\t"+name+"\t"+pay);
	}
}
