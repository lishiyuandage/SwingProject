package dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bean.QuestionBean;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class QuestionDAO {
	private List<QuestionBean> question_list=null;
	
	public List<QuestionBean> getQuestionList(String path) {
		question_list=new ArrayList<QuestionBean>();
		try {
			Workbook excel=Workbook.getWorkbook(new File(path));
			Sheet sheet=excel.getSheet(0);
			int row=sheet.getRows();
			for(int i=0;i<row;i++) {
				QuestionBean question=new QuestionBean();
				question.setQuestion(sheet.getCell(0,i).getContents());
				question.setA(sheet.getCell( 1,i).getContents());
				question.setB(sheet.getCell(2,i).getContents());
				question.setC(sheet.getCell(3,i).getContents());
				question.setD(sheet.getCell(4,i).getContents());
				question.setAnswer(sheet.getCell(5,i).getContents().trim());
				question_list.add(question);
			}
		} catch (BiffException e) {
			JOptionPane.showMessageDialog(null, "读取表格异常");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "打开表格异常");
		}
		return question_list;
	}
	public int getRow(String path) {
		int row=-1;
		try {
			Workbook excel=Workbook.getWorkbook(new File(path));
			Sheet sheet=excel.getSheet(0);
			row=sheet.getRows();
		} catch (BiffException e) {
			JOptionPane.showMessageDialog(null, "读取表格异常");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "打开表格异常");
		}
		return row;
	}
	public void createTable(File file,String [][] score) {
		try {
			WritableWorkbook excel=Workbook.createWorkbook(file);
			WritableSheet sheet=excel.createSheet("test", 0);
			int i=0;
			int j=0;
			for(String []s:score) {
				for(String S:s) {
					Label l=new Label(j, i, S);
					try {
						sheet.addCell(l);
					} catch (WriteException e) {
						System.out.println(e.getMessage());
					}
					j++;
				}
				i++;
			}
			excel.write();// 从内从中写入文件中  
	       
				excel.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "打开表格异常");
		}catch (WriteException e) {
			JOptionPane.showMessageDialog(null, "写入表格错误");
		}
	}
}
