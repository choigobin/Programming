package exEvent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class Exam3_event2 extends JFrame implements ActionListener {
	JRadioButton radio1, radio2;
	JCheckBox check1, check2, check3;
	JTextArea txar;
	JButton btn1, btn2;
	JPanel p2;

	public Exam3_event2() {
		//성별
		radio1 = new JRadioButton("남");
		radio1.setSelected(true);//기본선택
		radio2 = new JRadioButton("여");

		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JLabel("성  별"));
		p1.add(radio1);
		p1.add(radio2);
		
		//취미
		check1 = new JCheckBox("야구");
		check1.setSelected(true);
		check2 = new JCheckBox("축구");
		check3 = new JCheckBox("농구");

		p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(new JLabel("스포츠"));
		p2.add(check1);
		p2.add(check2);
		p2.add(check3);

		// p2.setVisible(false);

		//출력
		txar = new JTextArea(5, 20);
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3.add(new JLabel("출력"));
		p3.add(txar);

		//붙이기
		JPanel p4 = new JPanel(new GridLayout(3, 1));
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);

		btn1 = new JButton("등록");
		btn2 = new JButton("취소");
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		JPanel p5 = new JPanel();
		p5.add(btn1);
		p5.add(btn2);

		add(BorderLayout.NORTH, new JLabel("ItemEvent Test Form", JLabel.CENTER));
		add(BorderLayout.CENTER, p4);
		add(BorderLayout.SOUTH, p5);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ItemEvent 테스트");
		setSize(300, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String gender = "";
		String sport = "";
		
		if(e.getSource() == btn1) {
			if(radio1.isSelected()) {
				gender = "남";
			}else {
				gender = radio2.getText();
			}
			
			//Check
			if(check1.isSelected()) {
				sport ="야구";
			}
			if(check2.isSelected()) {
				sport +="축구";
			}
			if(check3.isSelected()) {
				sport +="농구";
			}
			
			txar.setText("성별 : " + gender + "\n스포츠 : " + sport);
		}else if(e.getSource() == btn2) {
			radio1.setSelected(true);
			check1.setSelected(true);
			check2.setSelected(false);
			check2.setSelected(false);
			txar.setText("");
		}
	}
	
	//콤보 박스
	//getSelectedIndex()
	//getSelectedItem()

	
	public static void main(String[] args) {
		new Exam3_event2();
	}

}
