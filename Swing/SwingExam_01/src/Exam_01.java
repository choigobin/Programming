// GUI(Graphic User Interface)
/* 1. AWT	- GUI 라이브러리, OS 종속
 * 2. Swing	- AWT 기반으로 순수 자바언어
 * 3. FX
 */ 
import javax.swing.*;

public class Exam_01 extends JFrame{
	public Exam_01() {
		setTitle("첫번째 프레임");
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam_01();
		
	}
}
