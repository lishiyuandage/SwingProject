package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import bean.QuestionBean;
import dao.ScoreDAO;
import view.AnswerQuestion;
import view.Login;

public class AnswerQuestionControl extends WindowAdapter implements ActionListener, ItemListener {
	private String TYPE;
	private int QUESTION_NUM;
	private Timer time;
	private int lost_time;
	private String ID;
	private List<QuestionBean> questions;
	private int index;
	private int[] question_index;
	private char []ANSWERS;
	private char [] student_answers;
	private AnswerQuestion answer_win;
	public void init() {
		answer_win.getQuestion().setText(questions.get(question_index[0]).getQuestion());
		answer_win.getAnswers_text()[0].setText(questions.get(question_index[0]).getA());
		answer_win.getAnswers_text()[1].setText(questions.get(question_index[0]).getB());
		answer_win.getAnswers_text()[2].setText(questions.get(question_index[0]).getC());
		answer_win.getAnswers_text()[3].setText(questions.get(question_index[0]).getD());
		ANSWERS=new char[question_index.length];
		for(int i=0;i<ANSWERS.length;i++) {
			ANSWERS[i]=questions.get(question_index[i]).getAnswer().charAt(0);
		}
		for(int i=1;i<=question_index.length;i++) {
			answer_win.getIndex().addItem(i+"");
		}
		student_answers=new char[question_index.length];
		index=0;
		answer_win.addWindowListener(this);
		answer_win.getUp().addActionListener(this);
		answer_win.getNext().addActionListener(this);
		answer_win.getIndex().addItemListener(this);
	}
	public void itemStateChanged(ItemEvent e) {
		getAnswer(answer_win.getAnswers());
		index=answer_win.getIndex().getSelectedIndex();
		setQuestion();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(time)) {
			if(lost_time<=0) {
				getAnswer(answer_win.getAnswers());
				ScoreDAO stu_sco=new ScoreDAO();
				stu_sco.insertScore(ID, TYPE, QUESTION_NUM, getScore());
				JOptionPane.showConfirmDialog(null, "时间到：你的成绩是："+getScore());
				answer_win.dispose();
				time.stop();
				new Login();
			}else{
				lost_time=lost_time-1;
				answer_win.getLost_time().setText(lost_time+"");
			}
		}else if(e.getActionCommand().equals("下一题")) {
			getAnswer(answer_win.getAnswers());
			if(index+1>=question_index.length) {
				int massage=JOptionPane.showConfirmDialog(null, "无下一题，是否提交");
				if(massage==0) {
					ScoreDAO stu_sco=new ScoreDAO();
					stu_sco.insertScore(ID, TYPE, QUESTION_NUM, getScore());
					JOptionPane.showMessageDialog(null, "你的成绩是："+getScore());
					answer_win.dispose();
					new Login();
					time.stop();
				}
			}else{
				index++;
				setQuestion();
				answer_win.getIndex().setSelectedIndex(index);
			}
		}else if(e.getActionCommand().equals("上一题")) {
			getAnswer(answer_win.getAnswers());
			if(index<=0) {
				JOptionPane.showMessageDialog(null, "无上一题");
			}else{
				index--;
				setQuestion();
				answer_win.getIndex().setSelectedIndex(index);
			}
		}
		
	}
	
	public void windowClosing(WindowEvent arg0) {
		
	}
	private void getAnswer(JRadioButton [] answer) {
		int a=-1;
		for(int i=0;i<answer.length;i++) {
			if(answer[i].isSelected()) {
				a=i;
			}
		}
		switch(a) {
			case 0:
				student_answers[index]='A';
				break;
			case 1:
				student_answers[index]='B';
				break;
			case 2:
				student_answers[index]='C';
				break;
			case 3:
				student_answers[index]='D';
				break;
			default :
				student_answers[index]='E';
				break;
		}
	}
	private void setQuestion() {
		answer_win.getQuestion().setText(questions.get(question_index[index]).getQuestion());
		answer_win.getAnswers_text()[0].setText(questions.get(question_index[index]).getA());
		answer_win.getAnswers_text()[1].setText(questions.get(question_index[index]).getB());
		answer_win.getAnswers_text()[2].setText(questions.get(question_index[index]).getC());
		answer_win.getAnswers_text()[3].setText(questions.get(question_index[index]).getD());
	}
	private int getScore() {
		double single_score=100.0/question_index.length;
		int sum=0;
		for(int i=0;i<ANSWERS.length;i++) {
			if(ANSWERS[i]==student_answers[i]) {
				sum++;
			}
		}
		return (int) (single_score*sum);
	}
	public void getQuestion_index(int max) {
		question_index=new int[max];
		int max_index=questions.size();
		for(int i=0;i<max;i++) {
			Random rand=new Random();
			boolean get=true;
			int index=-1;
			while(get) {
				index=rand.nextInt(max_index);
				for(int j=0;j<=i;j++) {
					if(question_index[j]==index) {
						break;
					}
				}
				get=false;
			}
			question_index[i]=index;
		}
	}
	public void setTime(int lost_time) {
		this.lost_time=lost_time*60;
		time=new Timer(1000, this);
		answer_win.getLost_time().setText(this.lost_time+"");
		time.start();
	}
	public List<QuestionBean> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionBean> questions) {
		this.questions = questions;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setAnswer_win(AnswerQuestion answer_win) {
		this.answer_win = answer_win;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public int getQUESTION_NUM() {
		return QUESTION_NUM;
	}
	public void setQUESTION_NUM(int qUESTION_NUM) {
		QUESTION_NUM = qUESTION_NUM;
	}
}
