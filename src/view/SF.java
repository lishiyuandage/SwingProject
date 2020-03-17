package view;

import javax.swing.*;

public class SF {
	public static JButton getButton() {
		return new JButton();
	}
	public static JButton getButton(String name) {
		return new JButton(name);
	}
	public static JTextField getTextField() {
		return new JTextField();
	}
	public static JPasswordField getPasswordField() {
		return new JPasswordField();
	}
	public static JPanel getPanel() {
		return new JPanel();
	}
	public static JPasswordField getPasswordField(int i) {
		// TODO Auto-generated method stub
		return new JPasswordField(i);
	}
	public static JTextField getTextField(int i) {
		// TODO Auto-generated method stub
		return new JTextField(i);
	}
	public static JLabel getLabel(String name) {
		return new JLabel(name);
	}
	public static JRadioButton getRadio() {
		return new JRadioButton();
	}
	public static JRadioButton getRadio(String name) {
		return new JRadioButton(name);
	}
}
