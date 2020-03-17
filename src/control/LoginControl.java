package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bll.LoginBLL;
import view.Login;

public class LoginControl implements ActionListener {
	private JTextField name;
	private JPasswordField password;
	private Login login;
	public void actionPerformed(ActionEvent e) {
		LoginBLL login_bus=new LoginBLL();
		password=login.getPassword();
		name=login.getTextField();
		String N=name.getText().trim();
		String P=new String(password.getPassword()).trim();
		if(!N.isEmpty()&&N!=null&&!P.isEmpty()&&P!=null) {
			if(e.getActionCommand().equals("ѧ����¼")&&login_bus.student_login(N, P)) {
				login.dispose();
			}else if(e.getActionCommand().equals("��ʦ��¼")&&login_bus.teacher_login(N, P)){
				login.dispose();
			}
		}else {
			JOptionPane.showMessageDialog(null, "������������¼��Ϣ��");
		}
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	

}
