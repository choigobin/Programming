package p1104;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Event01 extends JFrame {
	Event01(){
setTitle("단추 시험");
		setLayout(new FlowLayout());
		JButton b1 = new JButton("확인");
		JButton b2 = new JButton("취소");
		JLabel l = new JLabel("");
		add(b1);
		add(b2);
		add(l);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l.setText("확인 단추가 눌러졌습니다.");
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l.setText("취소 단추가 눌러졌습니다.");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(260,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Event01();
	}
}