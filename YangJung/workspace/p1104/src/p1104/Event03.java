package p1104;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class Event03 extends JFrame {
	public Event03() {
		setTitle("단추 시험");
		setLayout(new FlowLayout());
		JButton b1 = new JButton("확인");
		JButton b2 = new JButton("취소");
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JLabel l1 = new JLabel("");
		JLabel l2 = new JLabel("");
		l1.setPreferredSize(new Dimension(100, 10));
		l2.setPreferredSize(new Dimension(180, 30));
		add(new JLabel("원의 반지름"));
		add(t1);
		add(new JLabel("원의 넓이"));
		add(l1);
		add(l2);
		add(b1);
		add(b2);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float x = Float.valueOf(t1.getText());
				l1.setText(""+x*x*3.14);
				l2.setText(x+"*"+x+"*3.14="+x*x*3.14);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText("");
				l2.setText("");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,170);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Event03();

	}

}