package jslhrd2;

public class HakData extends Hak implements Account {
	//상속받은 멤버변수 super.변수
	//상속받은 멤버변수와 같은 이름의 변수를 만들지 않으면 this.변수 = super.변수
	//상복받은 멤버변수와 같은 이름의 변수를 만드는 순간 super.변수 와 this.변수가 구분된다.
	boolean check;
	int[] score; //조상클래스에 있는 score를 자식클래스에서 정의 => score를 상속받지 않음 => 조상클래스의 score를 쓰려면 super.score로 불러야함.
	int total = 0;
	double ave;
	public HakData(int bun,String name,int score) {
		this.bun = bun;
		this.name = name;
		super.score = score;
		check = true;
	}
	HakData(int bun,String name,int score[]){
		this.bun = bun;
		this.name = name;
		this.score = score;
		check = false;
	}
	@Override
	public void total(int[] score) {
		for(int i=0; i<score.length; i++) {
			total+=score[i];
		}
		ave = (double)total/score.length;
	}
	@Override
	public void total(int score) {
		total = score;
		ave = score;
	}
	void print(){
		System.out.print("번호\t이름\t점수");
		if(check) {
			total(super.score);
			System.out.println("\t합계\t평균");
			super.print();
			System.out.print("\t"+total+"\t"+ave+"\n");
		}else {
			total(score);
			for(int i=0; i<score.length; i++) {
				System.out.print("\t");
			}
			System.out.println("합계\t평균");
			System.out.print(bun+"\t"+name+"\t");
			for(int i=0; i<score.length; i++) {
				System.out.print(score[i]+"\t");
			}
			System.out.println(total+"\t"+ave+"\n");
		}
		
	}
	
}
