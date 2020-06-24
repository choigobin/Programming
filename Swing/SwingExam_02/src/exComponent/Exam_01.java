package exComponent;
import java.awt.BorderLayout;

//JLabel : 제목, 타이틀
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Exam_01 extends JFrame{
	
	public Exam_01() {
		JLabel lbl1 = new JLabel();
		lbl1.setText("제목");
		JLabel lbl2 = new JLabel("내용", JLabel.RIGHT);
		JLabel lbl3 = new JLabel("사진부분", JLabel.CENTER);
		
		add(BorderLayout.NORTH,lbl1);
		add(BorderLayout.SOUTH,lbl2);
		add(BorderLayout.CENTER,lbl3);
		setTitle("로그인 폼 만들기");
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam_01();
		
	}
}
