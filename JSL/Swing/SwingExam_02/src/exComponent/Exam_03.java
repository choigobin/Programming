package exComponent;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Exam_03 extends JFrame{
	public Exam_03() {
		setTitle("로그인 폼 만들기");
		JLabel title = new JLabel("로그인",JLabel.CENTER);
		JLabel title2 = new JLabel("Ver 2.0");
		
		JPanel p1 = new JPanel();// 기본값이 플로우 레이아웃
		p1.add(title);
		p1.add(title2);
		
		JPanel p2 = new JPanel();
		JTextField tx1 = new JTextField("아이디");
		JTextField tx2 = new JTextField(tx1.getText());
		p2.add(tx1);
		p2.add(tx2);
		
		add(BorderLayout.NORTH, p1);
		add(BorderLayout.SOUTH, p2);
		
		setSize(300, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam_03();
	}
}
