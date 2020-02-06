package thread;
class AA extends Thread{
	@Override
	public void run() {
		for(int x=0; x<10; x++) {
			for(int y=0; y<5; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
class BB implements Runnable{
	@Override
	public void run() {
		int s=0;
		for(int i=1; i<11; i++) {
			System.out.println(i);
			s+=i;
		}
		System.out.println("s= "+s);
	}
}
public class Exam_04 {
	public static void main(String[] args) {
		Thread aa = new AA();
		Thread bb = new Thread(new BB());
		aa.start();
		bb.start();
	}
}
