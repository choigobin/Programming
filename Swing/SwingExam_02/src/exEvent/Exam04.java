package exEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Exam04 extends JFrame implements ActionListener{
	JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8,panelCenter;
	JTextArea tx;
	Exam04(){
		panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel1.add(new JLabel("회원가입"));
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("이  름"));
		panel2.add(new JTextField(10));
		panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3.add(new JLabel("I       D"));
		panel3.add(new JTextField(10));
		JButton idCh = new JButton("아이디중복체크");
		idCh.addActionListener(this);
		panel3.add(idCh);
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
		tx = new JTextArea(5,20);
		tx.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(tx);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel7.add(scrollPane);
		
		panel8 = new JPanel();
		JButton btn3 = new JButton("회원가입");
		JButton btn4 = new JButton("가입취소");
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		panel8.add(btn3);
		panel8.add(btn4);
		
		add(BorderLayout.NORTH,centerLeft);
		add(BorderLayout.CENTER,panel7);
		add(BorderLayout.SOUTH,panel8);
		setTitle("회원가입 Ver1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam04();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name,id,pw,gender,job;
		
		if(e.getSource() == panel3.getComponent(2) ) {
			JTextField j1 = (JTextField) panel3.getComponent(1);
			if(j1.getText().equals("asd")) {
				JOptionPane.showMessageDialog(null, "아이디가 중복입니다.");
				j1.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "사용할 수 있는 아이디입니다.");
			}
		}
		if(e.getSource() == panel8.getComponent(0)) {
			JTextField name0 = (JTextField) panel2.getComponent(1);
			name = name0.getText();
			JTextField id0 = (JTextField) panel3.getComponent(1);
			id = id0.getText();
			JTextField pw0 = (JTextField) panel4.getComponent(1);
			pw = pw0.getText();
			JRadioButton gender0 = new JRadioButton();
			String[] gender1 = {"남자","여자"};
			int gender2 = 1;
			for(int i=1; i<3; i++) {
				gender0 = (JRadioButton)panel5.getComponent(i);
				gender2 = i;
				if(gender0.isSelected()) {
					break;
				}
			}
			gender = gender1[gender2];
			@SuppressWarnings("unchecked")
			JComboBox<String> job0 = (JComboBox<String>)panel6.getComponent(1);
			job = job0.getSelectedItem().toString();
			
			tx.setText("이름 : "+name+"\nID : "+id+"\nPW : "+pw+"\n성별 : " + gender+"\n직업 : "+job);
		}
		if(e.getSource() == panel8.getComponent(1)) {
			tx.setText("");
		}
		
	}

}
