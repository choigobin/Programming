package jslhrd;

public class ActionTest implements Action {

	@Override
	public void work() {
		System.out.println("[실행결과]");
		System.out.println("복사를 합니다.");
	}

	public static void main(String[] args) {
		ActionTest at = new ActionTest();
		at.work();

	}

}
