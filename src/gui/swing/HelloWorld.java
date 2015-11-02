package gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HelloWorld extends JFrame implements WindowListener, ActionListener {
	
	private JTextField text;
	
	public HelloWorld(){
		
		//basic parameters
		super("Hello!");
		setBounds(100,100,240,150);
		setLayout(null);
		
		//listener
		addWindowListener(this);
		
		//text label
		JLabel label = new JLabel("Enter your name");
		label.setBounds(10, 0, 100, 20);
		add(label);
		
		//text field
		text = new JTextField();
		text.setBounds(10, 30, 200, 20);
		add(text);
		
		//button
		JButton button = new JButton("Click me!");
		button.setActionCommand("click");
		button.addActionListener(this);
		button.setBounds(10, 70, 200, 30);
		add(button);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//click action open new window
		if(e.getActionCommand().equals("click")){
			new HelloWorldPopUp(text.getText());
		}
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
