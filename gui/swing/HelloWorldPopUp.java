package gui.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldPopUp extends JFrame {
	
	public HelloWorldPopUp(String name){
		
		//basic
		super("Hello!");
		setBounds(120,120,200+name.length()*8,110);
		setLayout(null);
		
		//label
		JLabel label = new JLabel("Hello "+name+"! Have a nice day!");
		label.setBounds(10, 0, 150+name.length()*8, 20);
		add(label);
		
		setVisible(true);
		
	}
	
}
