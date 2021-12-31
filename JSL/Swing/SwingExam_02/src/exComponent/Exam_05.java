package exComponent;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exam_05 {
	JFrame frm;
	JLabel lab1, lab2, lab3, lab4;
	JTextField tx1, tx2, tx3;
	JButton btn1, btn2;
	JPanel panel1, panel2;
	
	public Exam_05() {
		frm = new JFrame("로그인폼 만들기");
		lab1 = new JLabel("로그인 폼",JLabel.CENTER);
		frm.add(BorderLayout.NORTH, lab1);
		
		// 이름 [     ]
		lab2 = new JLabel("이 름",JLabel.RIGHT);
		tx1 = new JTextField();
		
		// 아이디 [    ]
		lab3 = new JLabel("아이디",JLabel.RIGHT);
		tx2 = new JTextField();
		
		// 비번 [    ]
		lab4 = new JLabel("비번",JLabel.RIGHT);
		tx3 = new JTextField();
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,2));
		panel1.add(lab2);
		panel1.add(tx1);
		panel1.add(lab3);
		panel1.add(tx2);
		panel1.add(lab4);
		panel1.add(tx3);
		frm.add(panel1);
		
		btn1 = new JButton("등록");
		btn2 = new JButton("취소");
		panel2 = new JPanel();
		panel2.add(btn1);
		panel2.add(btn2);
		frm.add(BorderLayout.SOUTH,panel2);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(300,200);
		frm.setVisible(true);
	}
	public static void main(String[] args) {
		new Exam_05();
	}
}
