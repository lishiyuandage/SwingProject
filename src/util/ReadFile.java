package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class ReadFile {
	private static String path;
	private static String time;
	public static String [] getQuestions() {
		readConf();
		String [] paths=getPaths();
		String [] questions=new String[paths.length];
 		for(int i=0;i<paths.length;i++) {
 			int end=paths[i].lastIndexOf(".");
 			int start=paths[i].lastIndexOf("/");
			questions[i]=paths[i].substring(start+1, end);
		}
 		return questions;
		
	}
	public static String [] getPaths() {
		readConf();
		return path.replaceAll("path=", "").trim().split(";");
	}
	public static int getTime() {
		readConf();
		return Integer.valueOf(time.replaceFirst("time=", "").trim());
	}
	
	private static void readConf() {
		try {
			File file =new File("标准化考试.conf");
			FileReader read=new FileReader(file);
			BufferedReader in=new BufferedReader(read);
			path=in.readLine();
			time=in.readLine();
			in.close();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "文件错误");
		}
		
	}
}
