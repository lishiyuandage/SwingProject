package view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import control.LoginControl;

public class Login extends JFrame {
	private JTextField name;
	private JPasswordField password;
	public Login() {
		this.setBounds(400, 200, 400, 300);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}
	public void init() {
		LoginControl l=new LoginControl();//监听器
		l.setLogin(this);
		JLabel HEAD =SF.getLabel("欢迎使用");
		HEAD.setFont(new Font("黑体",20,20));
		HEAD.setBounds(150, 20, 100, 40);
		add(HEAD);
		name=SF.getTextField();
		name.setBounds(120, 80, 200, 20);
		password=SF.getPasswordField();
		password.setBounds(120, 110, 200, 20);
		JLabel name_text =SF.getLabel("职工号/学号：");
		JLabel password_text=SF.getLabel("密码：");
		password_text.setBounds(50, 110, 50, 15);
		name_text.setBounds(30,80,90,15);
		add(password_text);
		add(password);
		add(name_text);
		add(name);
		JButton student_login=SF.getButton("学生登录");
		JButton teacher_login=SF.getButton("老师登录");
		student_login.setBounds(70, 150	, 100, 30);
		teacher_login.setBounds(200, 150, 100, 30);
		student_login.addActionListener(l);
		teacher_login.addActionListener(l);
		add(student_login);
		add(teacher_login);
	}
	public JTextField getTextField() {
		return name;
	}
	public void setTextField(JTextField name) {
		this.name = name;
	}
	public JPasswordField getPassword() {
		return password;
	}
	public void setPassword(JPasswordField password) {
		this.password = password;
	}
}
