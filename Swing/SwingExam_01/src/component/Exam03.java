package component;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class Exam03 extends JFrame{
	public Exam03() {
		setTitle("로그인 폼 만들기");
		JLabel title = new JLabel("로그인 ",JLabel.CENTER);
		JLabel title2 = new JLabel("Ver 2.0 ",JLabel.RIGHT);
		
		JPanel p1 = new JPanel(); //디폴트가 플로우 레이아웃으로 되어있음
		//컨테이너 = 패널 = 여러개의 컴포넌트를 묶을 수 있는 기능
		p1.add(title);
		p1.add(title2);
		
		JPanel p2 = new JPanel();
		JTextField tx1 = new JTextField("아이디"); //문자열 입력받을 때
		JTextField tx2 = new JTextField(tx1.getText());//값을 줄 때 set 값을 받을 때는 get
		p2.add(tx1);
		p2.add(tx2);
		add(BorderLayout.NORTH,p1);
		add(BorderLayout.SOUTH,p2);
		add(BorderLayout.WEST,tx1);
		//add(BorderLayout.NORTH,title2);
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam03();
	}
}
