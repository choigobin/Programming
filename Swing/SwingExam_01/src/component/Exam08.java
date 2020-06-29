package component;

import java.awt.*;
import javax.swing.*;

public class Exam08 {
	JFrame frm;
	JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7;
	JTextField tx1, tx2, tx3;
	ButtonGroup btng;
	JButton btn1, btn2, btn3;
	JPanel panel,panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	JList list;
	JTextArea txar;
	JComboBox combo;
	JRadioButton rad1, rad2;
//이제 간격벌어지는 이유는 grid로 정렬했을 때 가장 큰 칸 기준으로 전부다 크키가 같아져버려서 자기소개부분때문에 저렇게 되요
	//자기소개만 지우면 잘 돌아가죠 저는 grid에서 자기소개 빼고 처리했어요. North에 회원가입부터 자기소개앞까지 넣고 center에는 자기소개만 넣었어요

	public Exam08() {
		frm = new JFrame("회원가입 Ver1.0");

		panel1 = new JPanel();
		panel1.add(new JLabel("회원가입"));
		frm.add(BorderLayout.CENTER, panel1);
		
		panel = new JPanel(new GridLayout(7,1));//이게 문제???넵 Grid 특성이 같은 크기 칸으로 나누어진다.
		
		// 이름
		tx1 = new JTextField(10);
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));//이런식으로 왼쪽 정렬 ㄱㄱ ㅇㅋ
		panel2.add(new JLabel("이    름"));
		panel2.add(tx1);
		frm.add(BorderLayout.NORTH, panel2);

		// 아이디, 아이디 중복체크
		tx3 = new JTextField(10);
		panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3.add(new JLabel("I   D"));
		btn3 = new JButton("아이디중복체크");
		panel3.add(tx3);
		panel3.add(btn3);
		frm.add(BorderLayout.NORTH, panel3);

		// 비밀번호
		tx3 = new JTextField(10);
		panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel4.add(new JLabel("P   W"));
		panel4.add(tx3);
		frm.add(BorderLayout.NORTH, panel4);

		// 성별
		rad1 = new JRadioButton("남", true);
		rad2 = new JRadioButton("여");
		btng = new ButtonGroup();
		btng.add(rad1);
		btng.add(rad2);
		panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel5.add(new JLabel("성   별"));
		panel5.add(rad1);
		panel5.add(rad2);
		frm.add(BorderLayout.NORTH, panel5);

		// 직업
		combo = new JComboBox();
		combo.addItem("직업을 선택하세요");
		combo.addItem("교사");
		combo.addItem("교원");
		combo.addItem("공무원");
		combo.addItem("기타");

		panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel6.add(new JLabel("직   업"));
		panel6.add(combo);
		frm.add(BorderLayout.NORTH, panel6);

		// 자기소개
		txar = new JTextArea(5, 20);
		panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel7.add(new JLabel("자기소개"));
		panel7.add(txar);
		frm.add(BorderLayout.NORTH, panel7);

		panel8 = new JPanel();
		panel8.setLayout(new GridLayout(7, 1));
		panel8.add(panel1);
		panel8.add(panel2);
		panel8.add(panel3);
		panel8.add(panel4);
		panel8.add(panel5);
		panel8.add(panel6);
		//panel8.add(panel7);
		frm.add(BorderLayout.NORTH, panel8);
		frm.add(panel7);
		btn1 = new JButton("회원가입");
		btn2 = new JButton("가입취소");
		panel9 = new JPanel();
		panel9.add(btn1);
		panel9.add(btn2);
		frm.add(BorderLayout.SOUTH, panel9);

		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(300, 450);
		frm.setVisible(true);
	}

	public static void main(String[] args) {
		new Exam08();
	}
}
