package component;

import javax.swing.*;
import java.awt.*;

//Checkbox
//라디오버튼
public class Exam06 extends JFrame{
	JCheckBox chk1, chk2, chk3;
	JPanel panel; // 부착하고 싶은거-> 패널 모아서 -> 프레임에 붙임
	JRadioButton rad1, rad2;
	ButtonGroup btn;
	JPanel panel2;
	
	public Exam06() {
		setTitle("컴포넌트 테스트 Ver 1.0");
		
		//취미
		chk1 = new JCheckBox("야구",true);
		chk2 = new JCheckBox("축구");
		chk3 = new JCheckBox("농구");
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //디폴트가 Flowlayout
		panel.add(new JLabel("좋아하는 운동 : "));
		panel.add(chk1);
		panel.add(chk2);
		panel.add(chk3);
		add(BorderLayout.NORTH, panel);
		
		//성별
		rad1 = new JRadioButton("남자", true);
		rad2 = new JRadioButton("여자");
		btn = new ButtonGroup();
		btn.add(rad1);
		btn.add(rad2);
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("성별 : "));
		panel2.add(rad1);
		panel2.add(rad2);
		add(BorderLayout.SOUTH, panel2);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Exam06();
	}

}
