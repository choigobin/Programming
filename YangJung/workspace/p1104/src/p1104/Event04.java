package p1104;

import javax.swing.*;

public class Event04 extends JFrame{
	Event04(){
		setTitle("메뉴 구성하기");
		createMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,200);
		setVisible(true);
	}
	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenu Color = new JMenu("색상");
		
		file.add(new JMenuItem("새 파일"));
		file.add(new JMenuItem("파일 열기"));
		file.add(new JMenuItem("파일 저장"));
		file.addSeparator();
		file.add(new JMenuItem("종료"));
		
		Color.add(new JMenuItem("파란색"));
		Color.add(new JMenuItem("빨간색"));
		Color.add(new JMenuItem("노란색"));
		
		mb.add(file);
		mb.add(Color);
		setJMenuBar(mb);
	}
	public static void main(String[] args) {
		new Event04();
	}
}
