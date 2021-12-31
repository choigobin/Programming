package exComponent;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Exam_08 extends JFrame{
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panelCenter;
	Exam_08(){
		panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel1.add(new JLabel("회원가입"));
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("이  름"));
		panel2.add(new JTextField(10));
		panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3.add(new JLabel("I       D"));
		panel3.add(new JTextField(10));
		panel3.add(new JButton("아이디중복체크"));
		panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel4.add(new JLabel("P       W"));
		panel4.add(new JTextField(10));
		panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel5.add(new JLabel("성  별"));
		ButtonGroup btnG1 = new ButtonGroup();
		JRadioButton btn1 = new JRadioButton("남자");
		JRadioButton btn2 = new JRadioButton("여자");
		btnG1.add(btn1);
		btnG1.add(btn2);
		panel5.add(btn1);
		panel5.add(btn2);
		panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel6.add(new JLabel("직  업"));
		JComboBox<String> combo = new JComboBox<String>();
		combo.addItem("직업을선택하세요");
		combo.addItem("대학생");
		combo.addItem("회사원");
		panel6.add(combo);
		
		panelCenter = new JPanel(new GridLayout(7,1));
		panelCenter.add(panel1);
		panelCenter.add(panel2);
		panelCenter.add(panel3);
		panelCenter.add(panel4);
		panelCenter.add(panel5);
		panelCenter.add(panel6);
		JPanel centerLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
		centerLeft.add(panelCenter);
		
		panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel7.add(new JLabel("자기소개"));
		JTextArea tx = new JTextArea(5,20);
		tx.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(tx);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel7.add(scrollPane);
		
		panel8 = new JPanel();
		panel8.add(new JButton("회원가입"));
		panel8.add(new JButton("가입취소"));
		
		add(BorderLayout.NORTH,centerLeft);
		add(BorderLayout.CENTER,panel7);
		add(BorderLayout.SOUTH,panel8);
		setTitle("회원가입 Ver1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam_08();
	}

}
