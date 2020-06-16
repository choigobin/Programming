import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Exam_09 extends JFrame{
	public Exam_09() {
		setTitle("GridLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(3,2);
		
		Container c = getContentPane();
		c.setLayout(grid);
		
		c.add(new JLabel("이름"));
		c.add(new JTextField());
		c.add(new JLabel("아이디"));
		c.add(new JTextField());
		c.add(new JLabel("비번"));
		c.add(new JTextField());
		
		setSize(300, 200);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Exam_09();

	}

}
