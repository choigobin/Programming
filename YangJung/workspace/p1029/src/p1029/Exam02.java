package p1029;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Exam02 extends JFrame {
	Exam02(){
		setTitle("액션 지정");
		JButton b = new JButton("버튼");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 눌렀습니다.");
				b.setBackground(Color.CYAN);
			}
		});
		add(b);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam02();

	}

}
