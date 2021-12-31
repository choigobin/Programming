package p1029;

import java.awt.FlowLayout;

import javax.swing.*;

public class test03 extends JFrame{
	test03(){
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(new JTextArea(7,20));
	
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new test03();

	}

}
