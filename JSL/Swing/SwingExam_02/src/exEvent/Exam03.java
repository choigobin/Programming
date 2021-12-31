package exEvent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/*
 * JRadioButton, JCheckBox
 * ItemEvent -> ItemListener
 * 
 */
@SuppressWarnings("serial")
public class Exam03 extends JFrame{
	JRadioButton radio1,radio2;
	JCheckBox check1, check2,check3;
	JTextArea txar;
	JButton btn1, btn2;
	
	public Exam03() {
		radio1 = new JRadioButton("남");
		radio2 = new JRadioButton("여");
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JLabel("성  별"));
		p1.add(radio1);
		p1.add(radio2);
		
		check1 = new JCheckBox("야구");
		check2 = new JCheckBox("축구");
		check3 = new JCheckBox("농구");
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(new JLabel("스포츠"));
		p2.add(check1);
		p2.add(check2);
		p2.add(check3);
		
		
		txar = new JTextArea(5,20);
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3.add(new JLabel("출력"));
		p3.add(txar);
		
		JPanel p4 =new JPanel(new GridLayout(3,1));
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		
		btn1 = new JButton("등록");
		btn2 = new JButton("취소");
		JPanel p5 = new JPanel();
		p5.add(btn1);
		p5.add(btn2);
		
		add(BorderLayout.NORTH, new JLabel("ItemEvent Test Form",JLabel.CENTER));
		add(BorderLayout.CENTER, p4);
		add(BorderLayout.SOUTH, p5);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ItemEvent 테스트");
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam03();
	}

}
