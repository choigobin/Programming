package component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//선택상자(직업선택),selectBox = combobox펼침목록, 리스트상자

public class Exam07 {
	JFrame frm;
	JComboBox combo1, combo2;
	JPanel panel1, panel2, panel3, panel4, panelCenter, panel5;
	JList list1, list2;
	JTextArea txar;
	
	public Exam07() {
		//하나씩 넣어서 보여주는 방식
		frm = new JFrame("컴포넌트 테스트 1.1");
		combo1 = new JComboBox();
		combo1.addItem("교사");
		combo1.addItem("교원");
		combo1.addItem("공무원");
		combo1.addItem("기타");
		
		panel1 = new JPanel();
		panel1.add(new JLabel("직업선택:"));
		panel1.add(combo1);
		frm.add(BorderLayout.NORTH, panel1);
	
		//배열을 이용한 방법
		String[] str = {"학생","교사","학부모"};
		Vector<String> vc = new Vector();
		vc.add("AAA");
		vc.add("BBB");
		vc.add("CCC");
		//combo2 = new JComboBox(vc);
		
		combo2 = new JComboBox(str);
		panel2 = new JPanel();
		panel2 = new JPanel();
		panel2.add(new JLabel("옵션선택:"));
		panel2.add(combo2);
		frm.add(BorderLayout.SOUTH, panel2);

		panelCenter = new JPanel(new GridLayout(3,1)); // 세줄 한칸
		//리스트 생성해서 상자만들기
		list1 = new JList(str);
		
		panel3 = new JPanel();
		panel3.add(new Label());
		panel3.add(list1);
//		frm.add(BorderLayout.CENTER, panel3);
		panelCenter.add(panel3);
		
		list2 = new JList(new DefaultListModel());
		DefaultListModel model;
		model = (DefaultListModel)list2.getModel();
		model.addElement("aaaa");
		model.addElement("bbbb");
		model.addElement("cccc");
		model.addElement("dddd");
		
		panel4 = new JPanel();
		panel4.add(new JLabel("리스트 네스트2 :"));
		panel4.add(list2);
		panelCenter.add(panel4);
		
		//TextArea생성
		txar = new JTextArea(5,10);
		panel5 = new JPanel();
		panel5.add(new JLabel("소개입력 : "));
		panel5.add(txar);
		panelCenter.add(panel5);
		frm.add(BorderLayout.CENTER, panelCenter);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(300,400);
		frm.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Exam07();
	}

}
