package exEvent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

//텍스트필드에서 포커스 이동시키자
public class Exam02 {
	JTextField tx1, tx2, tx3;
	JTextArea txar;
	JButton btn1, btn2;
	JPanel p1, p2, p3, p4, p5, p6;
	JFrame f;

	public Exam02() {
		f = new JFrame("이벤트 테스트2");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JLabel("이   름"));
		tx1 = new JTextField(15);
		tx1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tx2.requestFocus(); // 커서이동하는 역할
			}
		});
		p1.add(tx1);

		p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(new JLabel("아이디"));
		tx2 = new JTextField(15);
		tx2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tx3.requestFocus(); // 커서이동하는 역할
			}
		});
		p2.add(tx2);

		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3.add(new JLabel("비   번"));
		tx3 = new JTextField(15);
		tx3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btn1.requestFocus();
			}
		});
		p3.add(tx3);

		p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p5.add(new JLabel("결   과"));
		txar = new JTextArea(5, 15);
		p5.add(txar);

		p4 = new JPanel(new GridLayout(4, 1));
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		p4.add(p5);
		
		MyAction listener = new MyAction();
		
		p6 = new JPanel();
		btn1 = new JButton("등록");
		btn2 = new JButton("취소");
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		p6.add(btn1);
		p6.add(btn2);

		f.add(BorderLayout.CENTER, p4);
		f.add(BorderLayout.SOUTH, p6);

		f.setSize(300, 300);
		f.setVisible(true);
	}

	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn1) {			
				//txar.setText("이   름: " + tx1.getText());
				//txar.setText("아이디: " + tx2.getText());
				//txar.setText("비   번: " + tx3.getText());
				txar.append("이   름: " + tx1.getText() + "\n");  
				txar.append("아이디: " + tx2.getText() + "\n");  
				txar.append("비   번: " + tx3.getText());  
				
			}else if(e.getSource() == btn2) {
				tx1.setText("");
				tx2.setText("");
				tx3.setText("");
				txar.setText("");
				tx1.requestFocus();
			}
		}
			
	}
	
	public static void main(String[] args) {
		new Exam02();
	}

}
