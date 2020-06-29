package exEvent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class Exam_01 extends JFrame{
	JTextField tx1; //이름 입력을 위한 컴포넌트
	JTextArea txar1;//이름 출력을 위한 컴포넌트
	JPanel p1,p2,p3;//컴포넌트를 묶기위한 컨테이너
	JButton btn1,btn2;
	
	public Exam_01() {
		tx1 = new JTextField(10);
		p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JLabel("이름"));
		p1.add(tx1);
		add(BorderLayout.NORTH,p1);
		
		txar1 = new JTextArea(5,20);
		p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(new JLabel("결과"));
		p2.add(txar1);
		add(BorderLayout.CENTER,p2);
		
		btn1 = new JButton("등록");
		btn2 = new JButton("취소");
		p3 = new JPanel();
		p3.add(btn1);
		p3.add(btn2);
		add(BorderLayout.SOUTH,p3);
		
		setTitle("이벤트 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam_01();
	}
}
