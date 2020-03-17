package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import dao.QuestionDAO;
import util.ReadFile;
import view.AnswerQuestion;
import view.Login;
import view.SelectQuestion;

public class SelectControl implements ActionListener {
	private SelectQuestion sel_win;
	private String ID;
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("退出")) {
			int sel=JOptionPane.showConfirmDialog(null,"退出答题？","退出答题？", JOptionPane.YES_NO_OPTION);
			if(sel==0) {
				sel_win.dispose();
				new Login();
			}
		}else if(arg0.getActionCommand().equals("开始答题")) {
			int index=getSelectIndex(sel_win.getQuestions());
			int num=getSelctText(sel_win.getQuestion_int());
			String path=ReadFile.getPaths()[index];
			QuestionDAO question_dao=new QuestionDAO();
			int max=question_dao.getRow(path);
			if(num<=max) {
				AnswerQuestion answer_win=new AnswerQuestion();
				AnswerQuestionControl answer_control=new AnswerQuestionControl();
				answer_control.setAnswer_win(answer_win);
				answer_control.setQuestions(question_dao.getQuestionList(path));
				answer_control.getQuestion_index(num);
				answer_control.setID(ID);
				answer_control.setQUESTION_NUM(num);
				answer_control.init();
				answer_control.setTYPE(sel_win.getQuestions()[index].getText());
				if(ReadFile.getTime()>=0) {
					answer_control.setTime(ReadFile.getTime());
				}
				sel_win.dispose();
			}else {
				JOptionPane.showMessageDialog(null,"题库中没有那么多题目！！");
			}
		}
	}
	private int getSelectIndex(JRadioButton[] sel) {
		int index=-1;
		for(int i=0;i<sel.length;i++) {
			if(sel[i].isSelected()) {
				index=i;
			}
		}
		return index;
	}
	private int getSelctText(JRadioButton []sel) {
		int text=-1;
		for(int i=0;i<sel.length;i++) {
			if(sel[i].isSelected()) {
				text=Integer.valueOf(sel[i].getText());
			}
		}
		return text;
	}
	public void setSel_e_win(SelectQuestion sel_win) {
		this.sel_win=sel_win;
	}
	public void setID(String ID) {
		this.ID=ID;
	}
}
