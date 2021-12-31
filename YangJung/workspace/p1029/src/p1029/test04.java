package p1029;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.*;

public class test04 extends JFrame{
	test04(){
		setTitle("컴포넌트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		add(new JButton("버튼1",new ImageIcon("images/java1.png")));
		add(new JLabel("레이블1입니다"));
		add(new JLabel(new ImageIcon("images/java2.png")));
		add(new JCheckBox("C++"));
		add(new JCheckBox("Java"));
		add(new JCheckBox("C#",true));
		
		ButtonGroup g = new ButtonGroup();
		JRadioButton a = new JRadioButton("고래");
		JRadioButton b = new JRadioButton("상어",true);
		JRadioButton c = new JRadioButton("새우");
		g.add(a);g.add(b);g.add(c);
		add(a);
		add(b);
		add(c);
		
		setSize(200,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new test04();

	}

}
