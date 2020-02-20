class Account{ // 두개의 인수를 가지고 + - * / 실행
	int n;
	int m;
	
	void add() { 
		System.out.println(n+" + "+ m + " = " +(n+m));
	}
	void sub() { 
		if(n>m) {
			System.out.println(n+" - "+ m + " = "+(n-m));
		}else {
			System.out.println(m+" - "+ n + " = "+(m-n));
		}
	}
	void mul() { 
		System.out.println(n+" * "+ m + " = "+(n*m));
	}
	void div() { 
		System.out.println(n+" / "+ m + " = "+(n/m));
	}
	
	
}


public class Exam_05 {
	public static void main(String[] args) {
		
		Account a = new Account();
		a.n = 400;
		a.m = 200;
		
		a.add();
		a.sub();
		a.mul();
		a.div();
		
		
		
	}
}