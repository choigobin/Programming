import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;
@SuppressWarnings("serial")
public class Exam_05 extends JFrame{
	Exam_05(){
		setTitle("컴포넌트 배치 테스트");
		/*
		Container ff = getContentPane();
		ff.setBackground(Color.orange);
		ff.setLayout(new FlowLayout());
		
		ff.add(new JButton("OK"));
		ff.add(new JButton("Cancle"));
		ff.add(new JButton("Ignore"));
		*/
		setBackground(Color.orange);//컨텐트팬이 없으면 적용되지 않음
		setLayout(new FlowLayout());//좌->우로 자동으로 줄바꿈까지
		
		add(new JButton("OK"));
		add(new JButton("Cancle"));
		add(new JButton("Ignore"));
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam_05();
	}
}
