//package store;
//
//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//import javax.swing.UIManager;
//
//public class login {
//
//	public login(ArrayList<account> accounts, ArrayList<item> menu) {
//	JFrame frame = new JFrame("login");	
//	
//	try {
//		System.setProperty("sun.awt.noerasebackground", "true");
//		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		SwingUtilities.updateComponentTreeUI(frame);
//	}catch (Exception e) {
//		e.printStackTrace();
//	}
//	frame.getContentPane().setBackground(Main.foreground);	
//	frame.setSize(700, 550);
//	frame.setLayout(new BorderLayout());
//		frame.setLocationRelativeTo(null);
//	frame.setResizable(false);
//	((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//	JPanel panel = new JPanel(new GridLayout(4,2,20,20));
//	
//	JLabel email = Main.label("email");
//			JTextField e_mail = Main.textField();
//			panel.add(email);
//			panel.add(e_mail);
//			
//			JLabel mdps = Main.label("password");
//			JTextField motdepass = Main.textField();
//			panel.add(mdps);
//			panel.add(motdepass);
//			
//			JButton newacc = Main.button("create new account");
//					newacc.addActionListener(new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							new newAcc(accounts, menu);
//							frame.dispose();
//						}
//					});
//					panel.add(newacc);
//					
//					JButton login = Main.button("Login");
//					login.addActionListener(new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							String em = email.getText().toString();
//						String pass = mdps.getText().toString();
//						
//						if (em.equals("")) {
//							JOptionPane.showMessageDialog(null, "email cant be empty");
//							return;
//						}
//						if (pass.equals("")) {
//							JOptionPane.showMessageDialog(null, "password cant be empty");
//							return;
//						}
//							
//							account acc = null;
//							for(account a : accounts) {
//								
//								if(a.getEmail().equals(em) && a.getPassword().equals(pass)) {
//									acc = a;
//									break;
//								}
//							}
//							if(! acc.equals(null) ) {
//								
//								acc.menu(accounts,menu);
//								frame.dispose();
//							}else {
//								JOptionPane.showMessageDialog(null, "account doesnt exist");
//															}
//						}
//					});
//					panel.add(login);
//					panel.setBorder(BorderFactory.createEmptyBorder(140,140,140,140));
//	panel.setBackground(null);
//	frame.add(panel,BorderLayout.CENTER);
//	frame.setVisible(true);
//	}
//	
//}
	
	

package store;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class login {

	
	
    public login(ArrayList<account> accounts, ArrayList<item> menu) {
        JFrame frame = new JFrame("Login");
        
try {
		System.setProperty("sun.awt.noerasebackground", "true");
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		SwingUtilities.updateComponentTreeUI(frame);
	}catch (Exception e) {
		e.printStackTrace();
	}

        frame.setSize(700, 550);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        frame.getContentPane().setBackground(Main.foreground);
        JPanel panel = new JPanel(new GridLayout(4, 2, 20, 20));

        JLabel emailLabel = Main.label("Email");
        JTextField emailField = Main.textField();
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel passwordLabel = Main.label("Password");
        JTextField passwordField = Main.textField();
        panel.add(passwordLabel);
        panel.add(passwordField);

        JButton newAccountButton = Main.button("Create New Account");
        newAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new newAcc(accounts, menu);
                frame.dispose();
            }
        });
        panel.add(newAccountButton);

        JButton loginButton = Main.button("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText().trim();
                String password = emailField.getText().trim();

                if (email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Email can't be empty");
                    return;
                }
                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password can't be empty");
                    return;
                }

                try (Connection conn = DatabaseConnection.getConnection()) {
                    if (conn == null) {
                        JOptionPane.showMessageDialog(null, "Database connection failed!");
                        return;
                    }

                    // Query to fetch the stored hashed password and role
                    String sql = "SELECT name, phone, password, role FROM users WHERE email = ?";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, email);
                        ResultSet rs = pstmt.executeQuery();

                        if (rs.next()) {
                            String storedHashedPassword = rs.getString("password");
                            String name = rs.getString("name");
                            String phone = rs.getString("phone");
                            String role = rs.getString("role");

                            // Hash the input password and compare with stored hash
                            if (storedHashedPassword.equals(Main.hashPassword(password))) {
                                JOptionPane.showMessageDialog(null, "Login successful!");
                                frame.dispose(); // Close login window

                                // Open Admin or Guest menu based on role
                                if (role.equalsIgnoreCase("Admin")) {
                                    new admin(name, phone, email, storedHashedPassword).menu(accounts, menu);
                                } else {
                                    new guest(name, phone, email, storedHashedPassword).menu(accounts, menu);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid email or password.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid email or password.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
                }
            }
        });


        panel.add(loginButton);

        panel.setBorder(BorderFactory.createEmptyBorder(140, 140, 140, 140));
        panel.setBackground(null);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

