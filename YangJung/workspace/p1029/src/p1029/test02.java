package p1029;

import java.awt.FlowLayout;

import javax.swing.*;

public class test02 extends JFrame {
	test02(){
		setTitle("텍스트필드 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		add(new JLabel("이름"));
		add(new JTextField(20));
		add(new JLabel("학과"));
		add(new JTextField(20));
		add(new JLabel("주소"));
		add(new JTextField(20));
		
		setSize(300,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new test02();

	}

}