package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bean.BF;
import bean.StudentBean;
import view.GetCon;

public class StudentDAO {
	private List<StudentBean> student_list;
	private Connection con;
	private PreparedStatement pre_sta;
	private ResultSet res;
	public StudentDAO() {
		con=GetCon.getConnection();
	}
	public String getPassword(String name) {
		String password=null;
		if(con!=null) {
			try {
				pre_sta=con.prepareStatement("select * from student where ID=?");
				pre_sta.setString(1, name);
				res=pre_sta.executeQuery();
				if(res.next()) {
					password=res.getString("password").trim();
				}
				con.close();
			} catch (SQLException e) {
				JOptionPane.showConfirmDialog(null, "≤È—Ø¥ÌŒÛ£°£°");
			}
		}
		return password;
	}
	public List<StudentBean> getStudeent(String name ,String key){
		if(con!=null) {
			try {
				pre_sta=con.prepareStatement("select * from student where ?=?");
				pre_sta.setString(0, name);
				pre_sta.setString(1, key);
				res=pre_sta.executeQuery();
				student_list=new ArrayList<StudentBean>();
				while(res.next()) {
					StudentBean student=BF.getStudentBean();
					student.setID(res.getString("ID"));
					student.setName(res.getString("name"));
					student.setName(res.getString("password"));
					student_list.add(student);
				}
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "≤È—Ø ß∞‹!!");
			}
		}
		return student_list;
	}
	public List<StudentBean> getAllStudent(){
		if(con!=null) {
			try {
				pre_sta=con.prepareStatement("select * from student");
				res=pre_sta.executeQuery();
				student_list=new ArrayList<StudentBean>();
				while(res.next()) {
					StudentBean student=BF.getStudentBean();
					student.setID(res.getString("ID"));
					student.setName(res.getString("name"));
					student.setName(res.getString("password"));
					student_list.add(student);
				}
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "≤È—Ø ß∞‹!!");
			}
		}
		return student_list;
	}
}
