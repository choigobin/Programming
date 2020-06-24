/*   GridLayout() : 격자모양
 *   
 *   GridLayout(줄, 칸, vGap,hGap)
 */
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
@SuppressWarnings("serial")
public class Exam_08 extends JFrame{
	public Exam_08() {
		setTitle("GradLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4,3,5,5));
		c.add(new JButton("1"));
		c.add(new JButton("2"));
		c.add(new JButton("3"));
		c.add(new JButton("4"));
		c.add(new JButton("5"));
		c.add(new JButton("6"));
		c.add(new JButton("7"));
		c.add(new JButton("8"));
		c.add(new JButton("9"));
		c.add(new JButton("0"));

		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam_08();
	}

}
