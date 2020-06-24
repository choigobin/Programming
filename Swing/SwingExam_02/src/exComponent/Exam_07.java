package exComponent;
//선택상자, 리스트상자

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Exam_07 {
	JFrame frm;
	JComboBox<String> combo1, combo2;
	JPanel panel1, panel2, panel3, panel4;
	JList<String> list1, list2;
	
	public Exam_07() {
		frm = new JFrame("컴포넌트 테스트 Ver 1.1");
		combo1 = new JComboBox<String>();
		combo1.addItem("회사원");
		combo1.addItem("공무원");
		combo1.addItem("교수");
		combo1.addItem("기타");
		panel1 = new JPanel();
		panel1.add(new JLabel("직업선택 :"));
		panel1.add(combo1);
		
		String[] str = {"학생","교사","학부모"};
		Vector<String> vc = new Vector<String>();
		vc.add("AAA");
		vc.add("BBB");
		vc.add("CCC");
		combo2 = new JComboBox<String>(str);
		//combo2 = new JComboBox<String>(vc);
		panel2 = new JPanel();
		panel2.add(new JLabel("옵션선택 :"));
		panel2.add(combo2);
		
		frm.add(BorderLayout.NORTH,panel1);
		frm.add(BorderLayout.SOUTH,panel2);
		
		//리스트 생성
		list1 = new JList<String>(str);
		panel3 = new JPanel();
		panel3.add(new JLabel("리스트 :"));
		panel3.add(list1);
		frm.add(BorderLayout.CENTER, panel3);
		
		list2 = new JList<String>(new DefaultListModel<String>());
		DefaultListModel<String> model;
		model = (DefaultListModel<String>)list2.getModel();
		model.addElement("aaaaa");
		model.addElement("bbbbb");
		model.addElement("ccccc");
		panel4 = new JPanel();
		panel4.add(new JLabel("리스트2 :"));
		panel4.add(list2);
		frm.add(BorderLayout.WEST, panel4);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(300,400);
		frm.setVisible(true);
	}
	public static void main(String[] args) {
		new Exam_07();
	}
}
