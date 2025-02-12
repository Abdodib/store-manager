package store;
//
//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
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
//public class admin extends account {
//
//	
//	public admin() {
//		
//	}
//
//	public admin(String name, String phonenumber, String email, String password) {
//	super(name, phonenumber, email, password);
//	}
//
//	@Override
//	void menu(ArrayList<account>account,ArrayList<item> menu) {
//		  JFrame frame = new JFrame("admin");
//
//	        frame.getContentPane().setBackground(Main.foreground);
//	        
//	        frame.setSize(700, 550);
//	        frame.setLayout(new BorderLayout());
//	        frame.setLocationRelativeTo(null);
//	        frame.setResizable(false);
//	        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//
//	        JPanel panel = new JPanel(new GridLayout(5, 1, 20, 20));
//
//	        JButton showmenu = Main.button("show menu");
//	        JButton additem = Main.button("additem");
//	        JButton edititem = Main.button("edit item");
//	        JButton delitem = Main.button("delete item");
//	        JButton exit = Main.button("exit");
//	    
//	        
//	        showmenu.addActionListener(new ActionListener() {
//	        	
//	        		
//				@Override
//							public void actionPerformed(ActionEvent e) {
//				String msg = "";
//				if(menu.size() !=0) {
//					for (item m : menu) {
//						int index = menu.indexOf(m) + 1;
//						msg = msg + index + "."+ m.getItemName()+" "
//						+m.getPrice() + "$\n";
//					}
//				
//				}
//				JOptionPane.showMessageDialog(null, msg);
//				}
//			});
//	        
//	        additem.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					new newitem(menu);
//	        }
//			});
//	        
//	        edititem.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//				new edititem(menu);
//	        }
//			});
//	        
//	        delitem.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					new delitem(menu);
//	        }
//			});
//	      
//	        exit.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					new login(account,menu);
//					frame.dispose();
//				}
//			});
//	        
//	        
//	        
//	        
//	        
//	        
//	        
//	        
//panel.add(showmenu);
//panel.add(additem);
//panel.add(edititem);
//panel.add(delitem);
//panel.add(exit);
//	        panel.setBorder(BorderFactory.createEmptyBorder(80, 100, 80, 100));
//	        panel.setBackground(null);
//	        frame.add(panel, BorderLayout.CENTER);
//	        frame.setVisible(true);
//	    }
//
//	}
//	package store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class admin extends account {
    public admin() {}

    public admin(String name, String phoneNumber, String email, String password) {
        super(name, phoneNumber, email, password);
    }
@Override
    void menu(ArrayList<account> accounts, ArrayList<item> menu) {
        JFrame frame = new JFrame("Admin Panel");
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        JPanel panel = new JPanel(new GridLayout(5, 1, 20, 20));

        JButton showMenu = new JButton("Show Menu");
        JButton addItem = new JButton("Add Item");
        JButton editItem = new JButton("Edit Item");
        JButton delItem = new JButton("Delete Item");
        JButton exit = new JButton("Exit");

        showMenu.addActionListener(e -> displayItems(menu));
        addItem.addActionListener(e -> new newitem(menu));
        editItem.addActionListener(e -> new edititem(menu));
        delItem.addActionListener(e -> new delitem(menu));
        exit.addActionListener(e -> {
            new login(accounts, menu);
            frame.dispose();
        });

        panel.add(showMenu);
        panel.add(addItem);
        panel.add(editItem);
        panel.add(delItem);
        panel.add(exit);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void displayItems(ArrayList<item> menu) {
        JFrame frame = new JFrame("Menu Items");
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        String[] columns = {"Image", "Item Name", "Price ($)", "Quantity"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (item item : menu) {
            ImageIcon icon = new ImageIcon(item.getPic());
            Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            model.addRow(new Object[]{new ImageIcon(img), item.getItemName(), item.getPrice(), item.getQuantity()});
        }

        JTable table = new JTable(model);
        table.setRowHeight(50);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

//	
//
