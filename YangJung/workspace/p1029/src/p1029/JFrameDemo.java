package p1029;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame{
	MyFrame(){
		setTitle("안녕, 스윙!!!");
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT,20,50));
		p.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		JLabel l = new JLabel("헬로월드");
		JButton b = new JButton("버튼1");
		JButton b2 = new JButton("버튼2");
		p.add(l);
		p.add(b);
		p.add(b2);
		p.add(new JButton("버튼3"));
		p.add(new JButton("버튼4"));
		add(p);
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class JFrameDemo {

	public static void main(String[] args) {
		new MyFrame();

	}

}