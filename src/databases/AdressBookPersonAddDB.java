package databases;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdressBookPersonAddDB extends JFrame implements ActionListener {
	
	private JTextField field[];
	private JLabel label;
	
	public AdressBookPersonAddDB() {
		
		//basic parameters
		super("Text analyzer");
		setBounds(100, 100, 690, 240);
		setLayout(null);
		
		//declare text fields array
		field = new JTextField[7];
		
		//declare name field
		field[0] = new JTextField();
		field[0].setBorder(BorderFactory.createTitledBorder("Name"));
		field[0].setBounds(10, 10, 200, 40);
		
		//declare surname field
		field[1] = new JTextField();
		field[1].setBorder(BorderFactory.createTitledBorder("Surname"));
		field[1].setBounds(220, 10, 200, 40);
		
		//declare street field
		field[2] = new JTextField();
		field[2].setBorder(BorderFactory.createTitledBorder("Street"));
		field[2].setBounds(10, 60, 300, 40);
		
		//declare house number field
		field[3] = new JTextField();
		field[3].setBorder(BorderFactory.createTitledBorder("H num"));
		field[3].setBounds(320, 60, 60, 40);
		
		//declare flat number field
		field[4] = new JTextField();
		field[4].setBorder(BorderFactory.createTitledBorder("F num"));
		field[4].setBounds(390, 60, 60, 40);
		
		//declare city field
		field[5] = new JTextField();
		field[5].setBorder(BorderFactory.createTitledBorder("City"));
		field[5].setBounds(460, 60, 200, 40);
		
		//declare phone number field
		field[6] = new JTextField();
		field[6].setBorder(BorderFactory.createTitledBorder("Phone number"));
		field[6].setBounds(10, 110, 300, 40);
		
		//add all fields to frame and set background for each
		for(JTextField f:field){
			f.setBackground(getBackground());
			add(f);
		}
		
		//declare add button
		JButton button = new JButton("Add");
		button.setBounds(10, 160, 100, 30);
		button.addActionListener(this);
		button.setActionCommand("add");
		add(button);
		
		//declare add button
		button = new JButton("Cancel");
		button.setBounds(120, 160, 100, 30);
		button.addActionListener(this);
		button.setActionCommand("cancel");
		add(button);
		
		//declare label to display invalid data error
		label = new JLabel();
		label.setBounds(230, 160, 200, 30);
		label.setForeground( Color.red );
		add(label);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(JTextField f:field)
			System.out.println(f.getText());
		
		if(e.getActionCommand().equals("add")){
			
			int housenumber = -1;
			int flatnumber = -1;
			
			//check if data correct (numbers)
			boolean error = false;
			try{
				housenumber = Integer.parseInt(field[3].getText().trim());
				//it haven't to be store in any variable
				Integer.parseInt(field[6].getText().trim());
				//house number can't be negative
				if(housenumber <= 0) error = true;
			}
			catch(NumberFormatException e1){
				error = true;
			}
			
			if(error){
				label.setText("Invalid data");
				return;
			}
			
			//if flat number isn't empty
			if(!field[4].getText().trim().equals("")){
				try{
					flatnumber = Integer.parseInt(field[4].getText().trim());
					//flat number can't be negative
					if(flatnumber <= 0) error = true;
				}
				catch(NumberFormatException e1){
					error = true;
				}
				
				if(error){
					label.setText("Invalid data");
					return;
				}
				
			}
			else flatnumber = -1;
			
			//if program starts this instruction, there weren't any error before
			if(flatnumber != -1){
				new PersonDB(field[0].getText(), field[1].getText(), field[2].getText(), housenumber, flatnumber, field[5].getText(), field[6].getText());
			}
			else
				new PersonDB(field[0].getText(), field[1].getText(), field[2].getText(), housenumber, field[5].getText(), field[6].getText());
			
			dispose();
			
		}
		else if(e.getActionCommand().equals("cancel"))
			dispose();
		
	}

}
