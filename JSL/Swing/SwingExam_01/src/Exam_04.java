import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
@SuppressWarnings("serial")
public class Exam_04 extends JFrame{
	public Exam_04() {
		setTitle("프레임에 컴포넌트 부착하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//컨텐트팬 알아내기
		Container contentPane = getContentPane();
		Button btn = new Button("Submit");// 컴포넌트
		JButton jbtn = new JButton("등록");// 컴포넌트
		contentPane.add(btn);//기본값은 center
		contentPane.add(BorderLayout.NORTH,jbtn);
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam_04();
		
	}
}
