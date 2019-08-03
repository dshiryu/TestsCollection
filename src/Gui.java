import javax.swing.*;
import java.awt.*;	
import java.awt.event.*;

public class Gui implements ActionListener {

	JFrame frame ;
	JPanel contentPane ;
	
	JMenu file, help, extra;
	JMenuItem exit , info, extra1, extra2, extra3,extra4;
	JMenuBar bar ;
	
	JLabel loginL, passwordL;
	JTextField loginT, passwordT;
	JButton button;
	
	int count = 0;
	
	
	public void actionPerformed(ActionEvent ae) {
		 if (ae.getSource() == this.exit) {
			 System.exit(0);					 			 
		 }
		 
		 if (ae.getSource() == this.info) {
			 System.out.println("Info");					 			 
		 }
		 
		 if (ae.getSource() == this.button) {
			 count++;
			 if(count >= 3) {
				 System.out.println("WARNUNG");
			 }
		 }
		 
		 if (ae.getSource() == this.extra1) {
			 System.out.println("Extra1");					 			 
		 }
		 
		 if (ae.getSource() == this.extra2) {
			 System.out.println("Extra2");					 			 
		 }
		 
		 if (ae.getSource() == this.extra3) {
			 System.out.println("Extra3");					 			 
		 }
		 
		 if (ae.getSource() == this.extra4) {
			 System.out.println("Extra4");					 			 
		 }
		 		 
	}
	
	public Gui (){
		// create frame and set size
		this.frame = new JFrame("Login");
		this.frame.setSize(260, 300);
		
		//create panel
		this.contentPane = new JPanel();
		this.frame.add(this.contentPane);
		
		// create menus
		file = new JMenu("File");
		help = new JMenu("Help");
		extra = new JMenu("Extra");
		
		// create menu items
		exit = new JMenuItem("Exit");
		file.add(exit);
		this.exit.addActionListener(this) ;
		
		info = new JMenuItem("Info");
		help.add(info);
		this.info.addActionListener(this) ;
		
		extra1 = new JMenuItem("Extra 1");
		extra.add(extra1);
		this.extra1.addActionListener(this) ;
		extra.addSeparator();
		
		extra2 = new JMenuItem("Extra 2");
		extra.add(extra2);
		this.extra2.addActionListener(this) ;
		extra.addSeparator();
		
		extra3 = new JMenuItem("Extra 3");
		extra.add(extra3);
		this.extra3.addActionListener(this) ;
		extra.addSeparator();
		
		extra4 = new JMenuItem("Extra 4");
		this.extra4.addActionListener(this) ;
		extra.add(extra4);
		
		// create the menu bar and add its items (for some reason this must come after instead of before)
		bar = new JMenuBar();
		bar.add(file);
		bar.add(help);
		bar.add(extra);
		this.frame.setJMenuBar(bar);
		
		// create the labels to describe the fields
		loginL = new JLabel("Login: ");
		passwordL = new JLabel("Password: ");
		
		// create the fields to fill information with
		loginT = new JTextField(20);
		passwordT = new JTextField(20);
		
		// create button
		button = new JButton("Login");
		
		// add everything in order
		this.contentPane.add(loginL);
		this.contentPane.add(loginT);
		this.contentPane.add(passwordL);
		this.contentPane.add(passwordT);
		this.contentPane.add(button);
		this.button.addActionListener(this) ;
		
		
		// set visible at the end so all items load when the program starts
		this.frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Gui m = new Gui();

	}

}
