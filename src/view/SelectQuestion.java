package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import control.SelectControl;
import util.ReadFile;

public class SelectQuestion extends JFrame {
	private JRadioButton [] questions;
	private JRadioButton [] question_int;
	private SelectControl l;
	private final String int_text[]= {"10","30","50","80","100","150"};
	public SelectQuestion() {
		this.setBounds(400, 200, 400, 300);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}
	private void init() {
		l=new SelectControl();
		l.setSel_e_win(this);
		String []questions_text=ReadFile.getQuestions();
		JLabel head =SF.getLabel("请选择你的题型和题量：");
		head.setBounds(20, 20, 150, 15);
		add(head);
		questions=new JRadioButton[questions_text.length];
		ButtonGroup gq=new ButtonGroup();
		for(int i=0;i<questions.length;i++) {
			questions[i]=SF.getRadio(questions_text[i]);
			gq.add(questions[i]);
			questions[i].setBounds(20, 40+i*25, 150, 20);
			add(questions[i]);
		}
		question_int=new JRadioButton[int_text.length];
		ButtonGroup gi=new ButtonGroup();
		for(int i=0;i<question_int.length;i++) {
			question_int[i]=SF.getRadio(int_text[i]);
			gi.add(question_int[i]);
			question_int[i].setBounds(200, 40+i*25, 50, 20);
			add(question_int[i]);
		}
		JButton answer=SF.getButton("开始答题");
		answer.setBounds(200, 200, 100, 30);
		JButton quit=SF.getButton("退出");
		quit.setBounds(50, 200, 100, 30);
		answer.addActionListener(l);
		quit.addActionListener(l);
		add(answer);
		add(quit);
	}
	public JRadioButton[] getQuestions() {
		return questions;
	}
	public void setQuestions(JRadioButton[] questions) {
		this.questions = questions;
	}
	public JRadioButton[] getQuestion_int() {
		return question_int;
	}
	public void setQuestion_int(JRadioButton[] question_int) {
		this.question_int = question_int;
	}
	public SelectControl getL() {
		return l;
	}	
}
