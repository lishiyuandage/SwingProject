package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class WriteFile {
	public static void writeFile(String path,String time) {
		try {
			File file =new File("标准化考试.conf");
			FileWriter write=new FileWriter(file);
			BufferedWriter out=new BufferedWriter(write);
			out.write("path="+path);
			out.newLine();
			out.write("time="+time);
			out.close();
			JOptionPane.showMessageDialog(null, "设置成功");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "写入配置失败，请手动修改 标准化考试.conf");
		}
	}
}
