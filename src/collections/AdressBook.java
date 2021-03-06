package collections;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class AdressBook extends JFrame implements WindowListener, ActionListener {
	
	private JList<Person> list;
	
	public AdressBook(){
		
		//basic parameters
		super("Adress Book");
		setBounds(100, 100, 500, 500);
		setLayout(null);
				
		//listener adding
		addWindowListener(this);
		
		//text area declaration
		list = new JList<Person>();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setVisibleRowCount(-1);
		JScrollPane pane = new JScrollPane(list);
		pane.setBounds(10, 10, 260, 440);
		add(pane);
		
		//add button declaration
		JButton button = new JButton("Add");
		button.setBounds(280, 10, 150, 30);
		button.addActionListener(this);
		button.setActionCommand("add");
		add(button);
		
		//remove button declaration
		button = new JButton("Remove");
		button.setBounds(280, 50, 150, 30);
		button.addActionListener(this);
		button.setActionCommand("remove");
		add(button);
		
		//sort by surname button declaration
		button = new JButton("Sort By Surname");
		button.setBounds(280, 90, 150, 30);
		button.addActionListener(this);
		button.setActionCommand("surnamesort");
		add(button);
		
		//load database
		Person.readDB(new File("person.db"));
		
		//set data set for list
		list.setListData( Person.getPersonArray() );
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("add")){
			
			AdressBookPersonAdd popup = new AdressBookPersonAdd();
			
			//adding new window listener here to get access to JList
			popup.addWindowListener(new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent e) {}
				
				@Override
				public void windowIconified(WindowEvent e) {}
				
				@Override
				public void windowDeiconified(WindowEvent e) {}
				
				@Override
				public void windowDeactivated(WindowEvent e) {}
				
				@Override
				public void windowClosing(WindowEvent e) {}
				
				@Override
				public void windowClosed(WindowEvent e) {
					
					list.setListData( Person.getPersonArray() );
					
				}
				
				@Override
				public void windowActivated(WindowEvent e) {}
			});
			
		}
		else if(e.getActionCommand().equals("remove")){
			Person.removePerson( list.getSelectedValue() );
		}
		else if(e.getActionCommand().equals("surnamesort")){
			Person.sortBySurname();
		}
		
		//data must be set for every action
		list.setListData( Person.getPersonArray() );
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//save database before exit
		Person.writeDB(new File("person.db"));
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
