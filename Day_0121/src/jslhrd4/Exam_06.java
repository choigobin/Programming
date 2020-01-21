package jslhrd4;

import java.io.IOException;

class AA{
	
	char input() throws IOException {// try-catch 말고 메소드에서 throws로 처리 => throws는 예외를 떠넘기는 것
		char ch = (char)System.in.read();
		return ch;
	}
}
class BB{
	
	char input() {// try-catch는 예외를 직접 처리
		char ch = 0;
		try {
			ch = (char)System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ch;
	}
}
public class Exam_06 {
	public static void main(String[] args) {
		AA a = new AA();
		try {
			char c = a.input();// AA.input()은 throws를 사용했기 때문에 호출할 때 처리해줘야함
			System.out.println("입력 값 : "+c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BB b = new BB();
		char cc = b.input();// BB.input()은 try-catch로 직접 처리했기 때문에 호출만 하면 됨
		System.out.println("입력 값 : "+cc);
		
		/*
		if(조건식) {
			throw new Exception(); // 인위적으로 예외를 만들 때는 throw
		}
		*/
	}

}
