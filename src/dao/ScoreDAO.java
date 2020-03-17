package dao;

import java.sql.*;

import javax.swing.JOptionPane;

import view.GetCon;

public class ScoreDAO {
	private Connection con;
	private PreparedStatement pre_sta;
	private ResultSet res;
	private String [][]data;
	public ScoreDAO() {
		con=GetCon.getConnection();
	}
	public int insertScore(String ID,String course,int num,int score) {
		int i=-1;
		try {
			pre_sta=con.prepareStatement("insert into score value(?,?,?,?)");
			pre_sta.setString(1, ID);
			pre_sta.setString(2, course);
			pre_sta.setInt(3,num);
			pre_sta.setInt(4, score);
			i=pre_sta.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				pre_sta=con.prepareStatement("update score score=? where ID=? and course=? and num=?");
				pre_sta.setInt(1, score);
				pre_sta.setString(2,ID);
				pre_sta.setString(3,course);
				pre_sta.setInt(4, num);
				i=pre_sta.executeUpdate();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "存入成绩失败");
			}
		}
		return i;
	}
	
	//有待完善
	public int getOrder(String ID,String course,int num) {
		int i=-1;
		try {
			pre_sta=con.prepareStatement("select * from score order by score where course=? and num=?");
			pre_sta.setString(0,ID);
			pre_sta.setString(1,course);
			pre_sta.setInt(2, num);
			
		} catch (SQLException e1) {
		}
		return i;
	}
	public String [][] getAllData(){
		try {
			pre_sta=con.prepareStatement("select name,score.ID,course,num,score  from score join student on score.ID=student.ID");
			res=pre_sta.executeQuery();
			int rows=0;
			while (res.next()) {
				rows++;
			}
			data=new String[rows][5];
			res=pre_sta.executeQuery();
			for(int i=0;res.next();i++) {
				data[i][0]=res.getString("name");
				data[i][1]=res.getString("score.ID");
				data[i][2]=res.getString("course");
				data[i][3]=res.getString("num");
				data[i][4]=res.getString("score");
			}
			con.close();
			return data;
		} catch (SQLException | ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	public String[][] getData(String key){
		try {
			pre_sta=con.prepareStatement("select name,score.ID,course,num,score  from score join student on score.ID=student.ID where name like '%"+key+"%' or score.ID like '%"+key+"%' or course like '%"+key+"%' or num like '%"+key+"%' or score like '%"+key+"%'");
			res=pre_sta.executeQuery();
			int rows=0;
			while (res.next()) {
				rows++;
			}
			data=new String[rows][5];
			res=pre_sta.executeQuery();
			for(int i=0;res.next();i++) {
				data[i][0]=res.getString("name");
				data[i][1]=res.getString("score.ID");
				data[i][2]=res.getString("course");
				data[i][3]=res.getString("num");
				data[i][4]=res.getString("score");
			}
			return data;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
