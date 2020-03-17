package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GetCon {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/standardtest?useSSL=true","root","1997126");
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "连接数据库错误");
			return null;
		}
		
	}
}
