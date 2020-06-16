/*	BorderLayout
 * 	BorderLayout.EAST	: 동
 * 	BorderLayout.WEST	: 서
 * 	BorderLayout.SOUTH	: 남
 * 	BorderLayout.NORTH	: 북
 * 	BorderLayout.CENTER	: 중앙
 */
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Exam_07 extends JFrame{
	public Exam_07() {
		setTitle("BorderLayout 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(BorderLayout.NORTH,new JButton("Add"));
		c.add(BorderLayout.WEST,new JButton("Sub"));
		c.add(BorderLayout.SOUTH,new JButton("Multi"));
		c.add(BorderLayout.EAST,new JButton("Divide"));
		c.add(BorderLayout.CENTER,new JButton("Cal"));
		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam_07();
	}
}
