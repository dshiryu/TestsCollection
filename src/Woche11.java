import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Eintrag {
	String name ;
	String addresse ;
}
//na verdade semana 12
public class Woche11 implements ActionListener {
	JFrame frame;
	JPanel contentPane, top, middle, bottom;
		
	JMenu datei;
	JMenuItem neu, ende;
	JMenuBar bar;
	
	JLabel nameL, addresseL;
	JTextField nameTF, addresseTF;
	JButton left, createNew, right;
	
	ArrayList<Eintrag> database = new ArrayList<Eintrag>() ;
	int index = 0 ;
	
	
	public void actionPerformed(ActionEvent ae) {
		this.saveFieldsToDB() ;
		if(ae.getSource() == this.neu) {
			
		}
		
		if(ae.getSource() == this.ende) {
			System.exit(0);
		}
		
		if(ae.getSource() == this.left) {
			if (index >= 1) {
		        this.index-- ;
		        this.fillFieldsFromDB() ;
		    } else {
		    	this.index = database.size()-1;
				this.fillFieldsFromDB() ;
			}
		}
		
		if(ae.getSource() == this.createNew) {
			Eintrag e = new Eintrag() ;
		      e.name = "" ;
		      e.addresse= "" ;
		      this.database.add(e) ;
		      this.index = this.database.size()-1 ;
		      this.fillFieldsFromDB() ;
		}
		
		if(ae.getSource() == this.right) {
			if (index < this.database.size()-1) {
		        this.index++ ;
		        this.fillFieldsFromDB() ;
		    } else {
				this.index = 0;
				this.fillFieldsFromDB() ;
			}
		}
	}
	
	void saveFieldsToDB() {
	    Eintrag e = this.database.get(this.index) ;
	    e.name = this.nameTF.getText() ;
	    e.addresse = this.addresseTF.getText() ;    
	}
	
	void fillFieldsFromDB() {
	    Eintrag e = this.database.get(index) ;
	    this.nameTF.setText(e.name) ;
	    this.addresseTF.setText(e.addresse) ;
	}
	
	public Woche11() {
		//database
		Eintrag e1 = new Eintrag();
		e1.name = "n1";
		e1.addresse = "n1";
		Eintrag e2 = new Eintrag();
		e2.name = "n2";
		e2.addresse = "n2";
		this.database.add(e1);
		this.database.add(e2);
		
		
		//window
		this.frame = new JFrame("KlausurAufgabe");
		this.frame.setSize(800, 200);
		
		this.contentPane = new JPanel();
		this.top = new JPanel();
		this.middle = new JPanel();
		this.bottom = new JPanel();
		
		this.frame.add(this.contentPane);
		this.contentPane.add(this.top);
		this.contentPane.add(this.middle);
		this.contentPane.add(this.bottom);
	    
		this.contentPane.setLayout(new BoxLayout(this.contentPane, BoxLayout.Y_AXIS));

		
		//menu
		this.datei = new JMenu("Datei");
		
		this.neu = new JMenuItem("Neu");
		this.datei.add(neu);
		this.neu.addActionListener(this);
		
		this.ende = new JMenuItem("Ende");
		this.datei.add(ende);
		this.ende.addActionListener(this);
		
		this.bar = new JMenuBar();
		this.bar.add(datei);
		
		this.frame.setJMenuBar(bar);
		
		//fields and labels
		this.nameL = new JLabel("Name");
		this.nameTF = new JTextField(20);
		this.addresseL = new JLabel("Addresse");
		this.addresseTF = new JTextField(20);
		
		this.top.add(this.nameL);
		this.top.add(this.nameTF);
		
		this.middle.add(this.addresseL);
		this.middle.add(this.addresseTF);
		
		//buttons
		this.left = new JButton("<--");
		this.createNew = new JButton("Neu");
		this.right = new JButton("-->");
		
		this.bottom.add(this.left);
		this.bottom.add(this.createNew);
		this.bottom.add(this.right);
		
		this.left.addActionListener(this);
		this.createNew.addActionListener(this);
		this.right.addActionListener(this);
		
		this.fillFieldsFromDB() ;
		
		//visible
		this.frame.setVisible(true);
	}

	public static void main(String[] args) {
		Woche11 waac = new Woche11();

	}

}
