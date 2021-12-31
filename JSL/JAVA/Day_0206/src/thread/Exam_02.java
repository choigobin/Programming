package thread;

class Beep extends Thread{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("쿵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {}
		}
	}
}
public class Exam_02 {
	public static void main(String[] args) {
		Beep beep = new Beep();
		beep.start();//start() 메소드를 써야 멀티스레드로 작동
		for(int i=0; i<10; i++) {
			System.out.println("짝");
			try {
				Thread.sleep(500);
			}catch (Exception e) {}
		}
		
		
	}
}
