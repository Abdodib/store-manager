package store;

import java.awt.Color;
import java.awt.Font;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    // Vérifier si l'email est valide
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Vérifier si le mot de passe est valide
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        
        if (!Character.isUpperCase(password.charAt(0))) {
            return false;
        }
        
        String specialChars = "!@#$%^&*()-+=<>?/{}[]|\\";
        int specialCharCount = 0;
        
        for (char c : password.toCharArray()) {
            if (specialChars.contains(String.valueOf(c))) {
                specialCharCount++;
            }
        }
        
        return specialCharCount == 1;
    }

}
