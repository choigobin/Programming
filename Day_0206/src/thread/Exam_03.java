package thread;
class BeepTask implements Runnable{
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
public class Exam_03 {
	public static void main(String[] args) {
		Runnable beep = new BeepTask();
		Thread thread = new Thread(beep);
		thread.start();
		for(int i=0; i<10; i++) {
			System.out.println("짝");
			try {
				Thread.sleep(500);
			}catch (Exception e) {}
		}
		
		
	}
}
