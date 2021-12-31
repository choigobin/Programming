package exComponent;
//checkbox : 여러개 선택
// 좋아하는 운동 선택 ㅁ야구 ㅁ축구 ㅁ농구
// 성별 : ㅇ남자 ㅇ여자 -> RadioButton
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Exam_06 extends JFrame{
	JCheckBox chk1, chk2, chk3;
	JPanel panel,panel2;
	
	JRadioButton rad1, rad2;
	ButtonGroup btnG;
	
	public Exam_06() {
		setTitle("컴포넌트 테스트 Ver 1.0");
		chk1 = new JCheckBox("야구");
		chk2 = new JCheckBox("축구");
		chk3 = new JCheckBox("농구");
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(new JLabel("좋아하는 운동 :"));
		panel.add(chk1);
		panel.add(chk2);
		panel.add(chk3);
		
		rad1 = new JRadioButton("남자");
		rad2 = new JRadioButton("여자");
		btnG = new ButtonGroup();
		btnG.add(rad1);
		btnG.add(rad2);
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("성별 :"));
		panel2.add(rad1);
		panel2.add(rad2);
		
		add(BorderLayout.NORTH,panel);
		add(BorderLayout.SOUTH,panel2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam_06();
	}
}
