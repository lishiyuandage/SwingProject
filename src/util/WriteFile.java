package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class WriteFile {
	public static void writeFile(String path,String time) {
		try {
			File file =new File("��׼������.conf");
			FileWriter write=new FileWriter(file);
			BufferedWriter out=new BufferedWriter(write);
			out.write("path="+path);
			out.newLine();
			out.write("time="+time);
			out.close();
			JOptionPane.showMessageDialog(null, "���óɹ�");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "д������ʧ�ܣ����ֶ��޸� ��׼������.conf");
		}
	}
}
