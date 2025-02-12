package store;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class newitem {
	
	String filepath = "Data/logo.png" ;
	
	
public newitem(ArrayList<item> menu) {

	  JFrame frame = new JFrame("Sign Up");

      frame.setSize(700, 550);
      frame.setLayout(new BorderLayout());
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

      JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));

      JLabel nameLabel = Main.label("item name");
      nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
      JTextField nameField = Main.textField();
      panel.add(nameLabel);
      panel.add(nameField);
      
      JLabel priceLabel = Main.label("item price");
      nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
      JTextField priceField = Main.textField();
      panel.add(priceLabel);
      panel.add(priceField);
      
      JLabel  quantityLabel = Main.label("item quantity");
      nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
      JTextField quantityField = Main.textField();
      panel.add( quantityLabel);
      panel.add( quantityField);
      
      JLabel pic = new JLabel();
      pic.setHorizontalAlignment(SwingConstants.CENTER);
      panel.add(pic);
      
      JButton pick = Main.button("pick image");
      pick.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String ne = nameField.getText().toString();
			String pe = priceField.getText().toString();
		
		
if(ne.equals("")) {
	JOptionPane.showMessageDialog(null, "itemName cannot be empty");
return;
}
		try {
			Double.parseDouble(pe);
		}catch(Exception w) {
			JOptionPane.showMessageDialog(null, "price must be number");
			return;
		}
		File dir = new File("Data/");
		if(!dir.exists()) dir.mkdir();
		pickFile("Data/" + ne, pic);
		}
	});
      
      panel.add(pick);
      
      JButton save = Main.button("save");
      save.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		String n = nameField.getText().toString();
		String p = priceField.getText().toString();
		String q = quantityField.getText().toString();
		item  m = new item(n, Double.parseDouble(p), filepath, q);		
			menu.add(m);
			JOptionPane.showMessageDialog(null, "Item added succesfully");
			frame.dispose();
		}
      
	});
      panel.add(save);
      
      JButton cancel = Main.button("Cancel");
      cancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		frame.dispose();
		}
	});
      
      panel.add(cancel);
      
      panel.setBorder(BorderFactory.createEmptyBorder(140, 100, 140, 100));
      panel.setBackground(null);
      frame.add(panel, BorderLayout.CENTER);
      frame.setVisible(true);
	
}
private void pickFile(String filename, JLabel lb) {
	JFileChooser a = new JFileChooser();
	a.setFileSelectionMode(JFileChooser.FILES_ONLY);
	a.addChoosableFileFilter(new FileNameExtensionFilter("Images","jpg","png"));
	a.setAcceptAllFileFilterUsed(true);
	int i = a.showOpenDialog(null);
	if(i==JFileChooser.APPROVE_OPTION) {
		File f = a.getSelectedFile();
		filepath = filename + getFileExtension(f);
		File dest = new File(filepath);
		if(f.getName().contains(".jpg") || f.getName().contains(".png")) {
			try {
				if(!dest.exists()) dest.createNewFile();
				Files.copy(f.toPath(), new FileOutputStream(dest));
				BufferedImage img = ImageIO.read(dest);
				Image dimg = img.getScaledInstance(lb.getHeight(),
						lb.getHeight(),Image.SCALE_AREA_AVERAGING);
				lb.setIcon(new ImageIcon(dimg));
			}catch(Exception r) {
				r.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, ".jpg or .png only");
		}
	}
}
private static String getFileExtension(File file) {
	String name = file.getName();
	int lastindexOf = name.lastIndexOf(".");
	if (lastindexOf==-1) {
		return"";
	}
	return name.substring(lastindexOf);
}
}
	


