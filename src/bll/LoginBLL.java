package bll;

import control.TeacherControl;
import dao.StudentDAO;
import dao.TeacherDAO;
import view.SelectQuestion;
import view.TeacherWin;

public class LoginBLL {
	public boolean student_login(String ID,String password) {
		StudentDAO stu=new StudentDAO();
		boolean return_value=false;
		if(password.equals(stu.getPassword(ID))) {
			SelectQuestion sel_win=new SelectQuestion();
			sel_win.getL().setID(ID);
			return_value=true;
		}
		return return_value;
	} 
	public boolean teacher_login(String ID,String password) {
		TeacherDAO teacher =new TeacherDAO();
		boolean return_value=false;
		if(password.equals(teacher.getPassword(ID))) {
			TeacherWin tea_win=new TeacherWin();
			TeacherControl tea_con=new TeacherControl();
			tea_con.setTea_win(tea_win);
			tea_con.init();
			return_value= true;
		}
		return return_value;
	}
}
