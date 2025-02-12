//package store;
//
//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import javax.swing.BorderFactory;
//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//
//public class newAcc {
//
//    public newAcc(ArrayList<account> accounts, ArrayList<item> menu) {
//        JFrame frame = new JFrame("sign up");
//
//        frame.getContentPane().setBackground(Main.foreground);
//        
//        frame.setSize(700, 550);
//        frame.setLayout(new BorderLayout());
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//
//        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
//
//        JLabel name = Main.label("your name");
//        name.setHorizontalAlignment(SwingConstants.CENTER);
//        JTextField nam = Main.textField();
//        panel.add(name);
//        panel.add(nam);
//
//        JLabel phone = Main.label("phone number");
//        JTextField fone = Main.textField();
//        phone.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(phone);
//        panel.add(fone);
//
//        JLabel email = Main.label("email");
//        JTextField e_mail = Main.textField();
//        email.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(email);
//        panel.add(e_mail);
//
//        JLabel mdps = Main.label("password");
//        JTextField motdepass = Main.textField();
//        mdps.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(mdps);
//        panel.add(motdepass);
//
//
//        ButtonGroup bg = new ButtonGroup();
//        JRadioButton admin = new JRadioButton("Admin");
//        admin.setHorizontalAlignment(SwingConstants.CENTER);
//        admin.setFont(new Font("Helvetica", Font.BOLD, 17));
//        admin.setBackground(null);
//        bg.add(admin);
//        panel.add(admin);
//
//        JRadioButton guest = new JRadioButton("Guest");
//        guest.setHorizontalAlignment(SwingConstants.CENTER);
//        guest.setFont(new Font("Helvetica", Font.BOLD, 17));
//        guest.setBackground(null);
//        bg.add(guest);
//        panel.add(guest);
//
//        JButton cancel = Main.button("cancel");
//        cancel.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new login(accounts, menu);
//                frame.dispose();
//            }
//        });
//        panel.add(cancel);
//
//        JButton creatacc = Main.button("sign up");
//        creatacc.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String nmbr = fone.getText();
//                String nom = nam.getText();
//                String em = e_mail.getText();
//                String pass = motdepass.getText();
//
//                if (nom.equals("")) {
//                    JOptionPane.showMessageDialog(null, "name cant be empty");
//                    return;
//                }
//                if (nmbr.equals("")) {
//                    JOptionPane.showMessageDialog(null, "enter your phone number");
//                    return;
//                }
//                if (em.equals("")) {
//                    JOptionPane.showMessageDialog(null, "email cant be empty");
//                    return;
//                }
//                if (pass.equals("")) {
//                    JOptionPane.showMessageDialog(null, "password cant be empty");
//                    return;
//                }
//                if (!admin.isSelected() && !guest.isSelected()) {
//                    JOptionPane.showMessageDialog(null, "select 'admin' or 'guest'");
//                    return;
//                }
//
//                account account;
//                if (admin.isSelected()) {
//                    account = new admin();
//                } else {
//                    account = new guest();
//                }
//
//                account.setName(nom);
//                account.setEmail(em);
//                account.setPassword(pass);
//                account.setPhonenumber(nmbr);
//                accounts.add(account);
//                for(account a : accounts) {
//                	System.out.println(a);
//                	System.out.println(a.getName());
//                	System.out.println(a.getPassword());
//                }
//               account.menu(accounts, menu);
//               frame.dispose();
//            }
//        });
//        panel.add(creatacc);
//
//        panel.setBorder(BorderFactory.createEmptyBorder(80, 100, 80, 100));
//        panel.setBackground(null);
//        frame.add(panel, BorderLayout.CENTER);
//        frame.setVisible(true);
//    }
//}
package store;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class newAcc {

    public newAcc(ArrayList<account> accounts, ArrayList<item> menu) {
        JFrame frame = new JFrame("Sign Up");

        frame.setSize(700, 550);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

        JLabel nameLabel = Main.label("Your Name");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField nameField = Main.textField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel phoneLabel = Main.label("Phone Number");
        JTextField phoneField = Main.textField();
        phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(phoneLabel);
        panel.add(phoneField);

        JLabel emailLabel = Main.label("Email");
        JTextField emailField = Main.textField();
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel passwordLabel = Main.label("Password");
        JTextField passwordField = Main.textField();
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(passwordLabel);
        panel.add(passwordField);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton adminRadio = new JRadioButton("Admin");
        adminRadio.setHorizontalAlignment(SwingConstants.CENTER);
        adminRadio.setFont(new Font("Helvetica", Font.BOLD, 17));
        adminRadio.setBackground(null);
        bg.add(adminRadio);
        panel.add(adminRadio);

        JRadioButton guestRadio = new JRadioButton("Guest");
        guestRadio.setHorizontalAlignment(SwingConstants.CENTER);
        guestRadio.setFont(new Font("Helvetica", Font.BOLD, 17));
        guestRadio.setBackground(null);
        bg.add(guestRadio);
        panel.add(guestRadio);

        JButton cancelButton = Main.button("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login(accounts, menu);
                frame.dispose();
            }
        });
        panel.add(cancelButton);
        
        JButton signUpButton = Main.button("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String phone = phoneField.getText().trim();
                String email = emailField.getText().trim();
                String password = passwordField.getText().trim();
                String role = adminRadio.isSelected() ? "Admin" : "Guest";

                if (name.equals("") || phone.equals("") || email.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "All fields are required!");
                    return;
                }
                
                if(! Main.isValidEmail(email)) {
                	JOptionPane.showMessageDialog(null, "please put a corect email!");
                    return;
                }
                
                if(Main.isValidPassword(password)) {
                	JOptionPane.showMessageDialog(null, "password should have capital later , constect from 8 character^, special character @$");
                    return;
                }
                
                if (!adminRadio.isSelected() && !guestRadio.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please select 'Admin' or 'Guest'");
                    return;
                }

                // Insert data into the database
                try (Connection conn = DatabaseConnection.getConnection()) {
                    if (conn == null) {
                        JOptionPane.showMessageDialog(null, "Database connection failed!");
                        return;
                    }

                    String sql = "INSERT INTO users (name, phone, email, password, role) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, name);
                        pstmt.setString(2, phone);
                        pstmt.setString(3, email);
                        pstmt.setString(4, Main.hashPassword(password));
                        pstmt.setString(5, role);

                        int rowsInserted = pstmt.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Account created successfully!");
                            frame.dispose();

                         
                            if (role.equals("Admin")) {
                                admin newAdmin = new admin(name, phone, email, password);
                                newAdmin.menu(accounts, menu);
                            }
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error saving account: " + ex.getMessage());
                }
            }
        });


        
        panel.add(signUpButton);

        panel.setBorder(BorderFactory.createEmptyBorder(80, 100, 80, 100));
        panel.setBackground(null);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
