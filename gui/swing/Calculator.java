package gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculator extends JFrame implements WindowListener, ActionListener {
	
	private JTextField[] textfield = new JTextField[3];
	private JRadioButton[] radiobutton  = new JRadioButton[4];
	private ButtonGroup buttongroup;
	private JButton resultbutton;
	
	public Calculator(){
		
		//basic parameters
		super("Calculator");
		setBounds(100,100,360,300);
		setLayout(null);
		
		//listener
		addWindowListener(this);
		
		//text fields
		
		//variables field
		textfield[0] = new JTextField();
		textfield[0].setBounds(10, 10, 100, 30);
		add(textfield[0]);
		
		textfield[1] = new JTextField();
		textfield[1].setBounds(230, 10, 100, 30);
		add(textfield[1]);
		
		//result field
		textfield[2] = new JTextField();
		textfield[2].setEditable(false);
		textfield[2].setBounds(10, 200, 320, 30);
		add(textfield[2]);
		
		//declare button group
		buttongroup = new ButtonGroup();
		
		//declare button for add
		radiobutton[0] = new JRadioButton("Add");
		radiobutton[0].setMnemonic(KeyEvent.VK_E);
		radiobutton[0].setBounds(120, 10, 100, 20);
		radiobutton[0].setSelected(true);
		buttongroup.add(radiobutton[0]);
		
		//declare button for subtract
		radiobutton[1] = new JRadioButton("Subtract");
		radiobutton[1].setMnemonic(KeyEvent.VK_H);
		radiobutton[1].setBounds(120, 40, 100, 20);
		buttongroup.add(radiobutton[1]);
		
		//declare button for multiply
		radiobutton[2] = new JRadioButton("Multiply");
		radiobutton[2].setMnemonic(KeyEvent.VK_L);
		radiobutton[2].setBounds(120, 70, 100, 20);
		buttongroup.add(radiobutton[2]);
		
		//declare button for divide
		radiobutton[3] = new JRadioButton("Divide");
		radiobutton[3].setMnemonic(KeyEvent.VK_L);
		radiobutton[3].setBounds(120, 100, 100, 20);
		buttongroup.add(radiobutton[3]);
		
		add(radiobutton[0]);
		add(radiobutton[1]);
		add(radiobutton[2]);
		add(radiobutton[3]);
		
		//declare result button
		resultbutton = new JButton("Result");
		resultbutton.setBounds(120, 130, 100, 30);
		resultbutton.setActionCommand("result");
		resultbutton.addActionListener(this);
		add(resultbutton);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("result")){
			
			//variables
			double a = 0;
			double b = 0;
			
			try{
				a = Double.parseDouble( textfield[0].getText().trim() );
				b = Double.parseDouble( textfield[1].getText().trim() );
			}
			catch(NumberFormatException e1){
				textfield[2].setText("Error!");
				return;
			}
			
			if(radiobutton[0].isSelected()){
				textfield[2].setText( (a + b) + "");
			}
			else if(radiobutton[1].isSelected()){
				textfield[2].setText( (a - b) + "");
			}
			else if(radiobutton[2].isSelected()){
				textfield[2].setText( (a * b) + "");
			}
			else if(radiobutton[3].isSelected()){
				textfield[2].setText( (a / b) + "");
			}
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
