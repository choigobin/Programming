package p1029;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CardDemo extends JFrame{
	CardLayout layout;
	public void rotate() {
		while(true) {
			try {
				Thread.sleep(500);
			}catch(Exception e){
			}
			layout.next(this.getContentPane());
		}
	}
	CardDemo(){
		setTitle("카드 레이아웃");
		layout = new CardLayout();
		setLayout(layout);
		add("0",new JButton("버튼1"));
		add("1",new JButton("버튼2"));
		add("2",new JButton("버튼3"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,110);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CardDemo().rotate();

	}

}