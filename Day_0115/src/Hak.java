class Hak{
	int bun;
	String name;
	int score;
	
	Hak(){}//디폴트 생성자
	Hak(int bun, String name, int score){//생성자 오버로딩
		this.bun = bun;
		this.name = name;
		this.score = score;
	}
	void print() {
		System.out.println(bun+"\t"+name+"\t"+score);
	}
	void print(int sw) {// 메소드 오버로딩
		System.out.println(sw+"\t"+bun+"\t"+name+"\t"+score);
	}
}
