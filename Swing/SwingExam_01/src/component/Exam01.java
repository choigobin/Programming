package component;
import java.awt.BorderLayout;

//JLabel : 제목 , 타이틀 만들 때 사용
import javax.swing.JFrame;
import javax.swing.JLabel;


//J프레임 상속받아서 쓰는 방법
public class Exam01 extends JFrame {
	public Exam01() {
		JLabel lbl1 = new JLabel();
		lbl1.setText("제목");
		
		JLabel lbl2 = new JLabel("내용",JLabel.RIGHT); //미리 값주기
		JLabel lbl3 = new JLabel("사진부분",JLabel.CENTER);
		
		add(BorderLayout.NORTH,lbl1);
		add(BorderLayout.SOUTH,lbl2);
		add(BorderLayout.CENTER, lbl3);
		
		setTitle("로그인 폼 만들기");
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam01();
	}

}
