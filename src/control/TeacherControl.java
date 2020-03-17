package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import dao.QuestionDAO;
import dao.ScoreDAO;
import util.ReadFile;
import util.WriteFile;
import view.Login;
import view.TeacherWin;

public class TeacherControl extends WindowAdapter implements ActionListener {
	private TeacherWin tea_win;
	private JFileChooser file_chooser;
	private final String[] HEAD = { "姓名", "学号", "题型", "题量", "成绩" };
	private String[][] data;

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("选择路径")) {
			file_chooser = new JFileChooser();
			file_chooser.showOpenDialog(null);
			if (file_chooser.getSelectedFile() != null) {
				tea_win.getPath().setText(tea_win.getPath().getText() + file_chooser.getSelectedFile().toPath() + ";");
			}
		} else if (e.getActionCommand().equals("设置")) {
			String path = tea_win.getPath().getText().replaceAll("\\\\", "/");
			if (path != null && !path.isEmpty()) {
				String time = tea_win.getTime().getText();
				try {
					Double.valueOf(time);
					WriteFile.writeFile(path, time);
				} catch (NumberFormatException exp) {
					JOptionPane.showMessageDialog(null, "定时只能是阿拉伯数字");
				}
			} else {
				JOptionPane.showMessageDialog(null, "请选路径");
			}
		} else if (e.getActionCommand().equals("搜索")) {
			ScoreDAO score_dao = new ScoreDAO();
			data = score_dao.getData(tea_win.getSearch_text().getText());
			tea_win.setStudent_score(new JTable(data, HEAD));
		} else if (e.getActionCommand().equals("导出至Excel")) {
			QuestionDAO question_dao = new QuestionDAO();
			file_chooser = new JFileChooser();
			file_chooser.showSaveDialog(null);
			File file = file_chooser.getSelectedFile();
			if (file != null) {
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e1) {
					}
				}
				question_dao.createTable(file, data);
			}
		}
	}

	public void init() {
		ScoreDAO score_dao = new ScoreDAO();
		tea_win.getTime().setText(ReadFile.getTime() + "");
		data = score_dao.getAllData();
		tea_win.setStudent_score(new JTable(data, HEAD));
		tea_win.setl(this);
	}

	public TeacherWin getTea_win() {
		return tea_win;
	}

	public void setTea_win(TeacherWin tea_win) {
		this.tea_win = tea_win;
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		new Login();
	}

}
