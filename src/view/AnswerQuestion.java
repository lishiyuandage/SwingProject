package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AnswerQuestion extends JFrame {
	private JRadioButton []answers;
	private JTextField [] answers_text;
	private JTextArea question;
	private JComboBox index;
	private JTextField lost_time;
	private JButton next;
	private JButton up;
	public AnswerQuestion() {
		this.setBounds(400, 200, 400, 300);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}
	private void init() {
		JLabel head=SF.getLabel("请认真答题：");
		head.setBounds(20,20,100,15);
		add(head);
		JLabel tip=SF.getLabel("剩余时间：");
		tip.setBounds(260,20,80,15);
		add(tip);
		lost_time=SF.getTextField();
		lost_time.setBounds(330, 18, 30, 20);
		lost_time.setEditable(false);
		lost_time.setBorder(null);
		add(lost_time);
		question=new JTextArea();
		question.setBounds(20,40,340, 40);
		question.setEditable(false);
		question.setBackground(getBackground());
		question.setLineWrap(true);
		add(question);
		answers=new JRadioButton[4];
		ButtonGroup g=new ButtonGroup();
		for(int i=0;i<answers.length;i++) {
			answers[i]=SF.getRadio();
			answers[i].setBounds(30, 90+i*20, 17, 15);
			g.add(answers[i]);
			add(answers[i]);
		}
		answers_text=new JTextField[4];
		for(int i=0;i<answers_text.length;i++) {
			answers_text[i]=SF.getTextField();
			answers_text[i].setBounds(50, 85+i*20, 300, 20);
			answers_text[i].setEditable(false);
			answers_text[i].setBorder(null);
			add(answers_text[i]);
		}
		next=SF.getButton("下一题");
		next.setBounds(250,200, 80, 30);
		up=SF.getButton("上一题");
		up.setBounds(50, 200, 80, 30);
		add(next);
		add(up);
		index=new JComboBox<>();
		index.setBounds(150, 200, 80, 30);
		add(index);
	}
	public JTextField[] getAnswers_text() {
		return answers_text;
	}
	public void setAnswers_text(JTextField[] answers_text) {
		this.answers_text = answers_text;
	}
	public JTextArea getQuestion() {
		return question;
	}
	public void setQuestion(JTextArea question) {
		this.question = question;
	}
	public JComboBox getIndex() {
		return index;
	}
	public void setIndex(JComboBox index) {
		this.index = index;
	}
	public JTextField getLost_time() {
		return lost_time;
	}
	public void setLost_time(JTextField lost_time) {
		this.lost_time = lost_time;
	}
	public JButton getNext() {
		return next;
	}
	public JButton getUp() {
		return up;
	}
	public JRadioButton[] getAnswers() {
		return answers;
	}
	public void setAnswers(JRadioButton[] answers) {
		this.answers = answers;
	}
	
}
