package gui.swing;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PeselCheck extends JFrame implements WindowListener, ActionListener {
	
	//declare pesel positions weights
	public static final int[] WEIGHT = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
	
	private JTextField text;
	private JLabel label;
	private int[] pesel = new int[11];
	
	public PeselCheck(){
		
		//basic parameters
		super("Pesel");
		setBounds(100,100,350,100);
		setLayout(null);
						
		//listener
		addWindowListener(this);
		
		//text field declaration
		text = new JTextField();
		text.setBounds(10, 10, 100, 30);
		add(text);
		
		//button declare
		JButton button = new JButton("Check");
		button.setBounds(120, 10, 100, 30);
		button.setActionCommand("check");
		button.addActionListener(this);
		add(button);
		
		//label declare
		label = new JLabel("Enter Pesel");
		label.setBounds(230, 10, 100, 30);
		add(label);
		
		setVisible(true);
		
	}
	
	public void peselCheckResult(boolean b){
		
		//set status
		if(b){
			label.setText("Pesel correct!");
		}
		else label.setText("Pesel incorrect!");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("check")){
			
			String t = text.getText();
			
			//check length
			if(t.length() == 11){
				
				//try to write numbers to pesel array
				for(int i = 0, size = t.length(); i < size; i++){
					
					try{
						pesel[i] = Integer.parseInt(t.charAt(i)+"");
					}
					catch(NumberFormatException e1){
						peselCheckResult(false);
					}
					
				}
				
				//lunch algorithm
				
				int sum = 0;
				
				for(int i = 0; i < WEIGHT.length; sum += pesel[i]*WEIGHT[i++]);
				
				if(sum % 10 == pesel[ pesel.length - 1 ]) peselCheckResult(true);
				else peselCheckResult(false);
				
			}
			else peselCheckResult(false);
			
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
