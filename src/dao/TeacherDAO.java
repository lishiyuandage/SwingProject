package dao;

import java.sql.*;

import javax.swing.JOptionPane;

import view.GetCon;

public class TeacherDAO {
	private Connection con;
	private PreparedStatement pre_sta;
	private ResultSet res;
	public TeacherDAO() {
		con=GetCon.getConnection();
	}
	public String getPassword(String name) {
		String password=null;
		if(con!=null) {
			try {
				pre_sta=con.prepareStatement("select password from teacher where ID=?");
				pre_sta.setString(1, name);
				res=pre_sta.executeQuery();
				if(res.next()) {
					password=res.getString("password");
				}else {
					JOptionPane.showMessageDialog(null, "查无此人");
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "查询错误");
			}
		}
		return password;
	}
}
