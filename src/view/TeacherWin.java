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
		info.setText("说明：\n 所设置的题库路径和定时将被保存在 “标准化考试.conf” 中； 文件扩展名为“.xls”或“.xlsx”，文件名称即是题库名"
				+ "\n 如：java.xls 显示的题库名为java");
		JLabel set_time=SF.getLabel("定时时长(分)：");
		set_time.setBounds(480, 70, 90, 20);
		info.setBounds(10, 10, 660, 55);
		info.setEditable(false);
		info.setBackground(getBackground());
		add(info);
		path=SF.getTextField();
		select_path =SF.getButton("选择路径");
		select_path.setBounds(375, 70, 100, 20);
		set=SF.getButton("设置");
		set.setBounds(620, 70, 60, 20);
		time=SF.getTextField();
		time.setBounds(560, 70, 50, 20);
		path.setBounds(20, 70,350, 20);
		path.setEditable(false);
		search_text=SF.getTextField();
		search_text.setBounds(20, 95, 450, 20);
		search=SF.getButton("搜索");
		search.setBounds(480, 95, 60, 20);
		out=SF.getButton("导出至Excel");
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
