package p1029;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderDemo extends JFrame {

	BorderDemo(){
		setTitle("Border Layout");
		setLayout(new BorderLayout(5,5));
		
		JButton b1 = new JButton("동");
		add("East",b1);
		add("West",new JButton("서"));
		add("South",new JButton("남"));
		add(new JButton("북"), BorderLayout.NORTH);
		add("Center",new JButton("중앙"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,110);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderDemo();

	}

}
