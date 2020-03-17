package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.TeacherControl;

public class TeacherWin extends JFrame {
	private JTextField path;
	private JTextField time;
	private JTable student_score;
	private JTextField search_text;
	private JScrollPane scroll;
	private JButton search;
	private JButton select_path;
	private JButton set;
	private JButton out;
	public TeacherWin(){
		this.setBounds(300, 100, 700, 400);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}
	private void init() {
		JTextArea info=new JTextArea();
		info.setText("˵����\n �����õ����·���Ͷ�ʱ���������� ����׼������.conf�� �У� �ļ���չ��Ϊ��.xls����.xlsx�����ļ����Ƽ��������"
				+ "\n �磺java.xls ��ʾ�������Ϊjava");
		JLabel set_time=SF.getLabel("��ʱʱ��(��)��");
		set_time.setBounds(480, 70, 90, 20);
		info.setBounds(10, 10, 660, 55);
		info.setEditable(false);
		info.setBackground(getBackground());
		add(info);
		path=SF.getTextField();
		select_path =SF.getButton("ѡ��·��");
		select_path.setBounds(375, 70, 100, 20);
		set=SF.getButton("����");
		set.setBounds(620, 70, 60, 20);
		time=SF.getTextField();
		time.setBounds(560, 70, 50, 20);
		path.setBounds(20, 70,350, 20);
		path.setEditable(false);
		search_text=SF.getTextField();
		search_text.setBounds(20, 95, 450, 20);
		search=SF.getButton("����");
		search.setBounds(480, 95, 60, 20);
		out=SF.getButton("������Excel");
		out.setBounds(550, 95, 120, 20);
		add(search_text);
		add(path);
		add(time);
		scroll=new JScrollPane();
		scroll.setBounds(20,120, 640, 240);
		add(scroll);
		add(out);
		add(search);
		add(set);
		add(set_time);
		add(select_path);
	}
	public JTextField getPath() {
		return path;
	}
	public void setPath(JTextField path) {
		this.path = path;
	}
	public JTextField getTime() {
		return time;
	}
	public void setTime(JTextField time) {
		this.time = time;
	}
	public void setStudent_score(JTable student_score) {
		this.student_score=student_score;
		scroll.setViewportView(this.student_score);
	}
	public JTextField getSearch_text() {
		return search_text;
	}
	public void setSearch_text(JTextField search_text) {
		this.search_text = search_text;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	public JTable getStudent_score() {
		return student_score;
	}
	public void setl(TeacherControl l) {
		this.set.addActionListener(l);
		this.search.addActionListener(l);
		this.out.addActionListener(l);
		this.select_path.addActionListener(l);
	}
}
