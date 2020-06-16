/*	배치 관리자 : BorderLayout, FlowLayout, GridLayout, CardLayout
 * 	컨테이너 (기본값) 
 *	Window(BorderLayout)
 *	Frame(BorderLayout)
 *	Panel(FlowLayout)
 *	Dialog(FlowLayout)
 */
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class Exam_06 extends JFrame{
	public Exam_06() {
		setTitle("FlowLayout 테스트");
		setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(new JButton("Add"));
		c.add(new JButton("Sub"));
		c.add(new JButton("Multi"));
		c.add(new JButton("Divide"));
		c.add(new JButton("Cal"));
		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam_06();
	}
}
