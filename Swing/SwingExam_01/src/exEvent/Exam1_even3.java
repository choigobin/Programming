package exEvent;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
	//이벤트리스너 
public class Exam1_even3 extends JFrame{
	
	JTextField tx1; //입력받기 위한 컴포넌트
	JTextArea txar1; // 입력값을 출력할 컴포넌트
	JPanel p1,p2,p3;
	JButton btn1,btn2;
	
	public Exam1_even3() {
		tx1 = new JTextField(10); //글자수
		p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(new JLabel("이  름"));
		p1.add(tx1);
		add(BorderLayout.NORTH, p1);
		
		txar1 = new JTextArea(5,20); // 줄 , 글자수
		p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.add(new JLabel("결  과"));
		p2.add(txar1);
		add(BorderLayout.CENTER, p2);
		
		//액션리스너 클래스의 객체생성
		MyActionListener listener = new MyActionListener();
		//
		btn1 =new JButton("등록");
		btn1.addActionListener(listener);
		//
		btn2 =new JButton("취소");
		btn2.addActionListener(listener);
		//
		
		p3 = new JPanel();
		p3.add(btn1);
		p3.add(btn2);
		add(BorderLayout.SOUTH, p3);
		
		setTitle("이벤트 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	} //생성자의 끝
	
	//이너클래스(액션리스너를 구현하는 내부클래스)
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn1) {
				txar1.setText(tx1.getText());
				
			}else if(e.getSource() == btn2) {
				tx1.setText("");
				txar1.setText("");
			}
		}
	}
	public static void main(String[] args) {
		new Exam1_even3();
	}
}
