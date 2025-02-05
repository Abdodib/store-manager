package store;

import java.awt.Color;
import java.awt.Font;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Main {
	
public static Scanner s;
private static ArrayList<account> accounts;
private static ArrayList<item> menu;

public static Color background = Color.decode("#D1E0E0");
public static Color foreground = Color.blue;
public static Color highlight = Color.CYAN;

public static void main(String[] args) {
	accounts = new ArrayList<>();
	menu = new ArrayList<>();
	new login(accounts, menu);

	}
public static JLabel label (String text) {
	JLabel label = new JLabel(text);
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setFont(new Font("Helvetica", Font.BOLD, 17));
	return label;
}
public static JTextField textField() {
	JTextField textfield = new JTextField();
	textfield.setHorizontalAlignment(SwingConstants.CENTER);
	textfield.setFont(new Font("Helvetica", Font.BOLD, 17));
	textfield.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	return textfield;
}
public static JButton button(String text) {
	JButton btn = new JButton (text);
	btn.setHorizontalAlignment(SwingConstants.CENTER);
	btn.setFont(new Font("Helvetica", Font.BOLD, 17));
	btn.setBorder(null);
	return btn;
}
public static String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
}

}
