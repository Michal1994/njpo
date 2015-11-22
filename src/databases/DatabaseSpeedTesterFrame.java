package databases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DatabaseSpeedTesterFrame extends JFrame implements WindowListener, DatabaseSpeedTestListener, ActionListener {
	
	private JTextArea text;
	private JTextField startelements;
	private JTextField repeats;
	
	private Thread thread;
	
	public DatabaseSpeedTesterFrame(){
		
		//basic parameters
		super("Speed Tester!");
		setBounds(100,100,600,500);
		setLayout(null);
		
		//listener
		addWindowListener(this);
		
		//text area declaration
		text = new JTextArea();
		text.setBounds(10, 90, 560, 360);
		text.setText("Click start button to begin test...");
		add(text);
		
		//text fields declarations
		startelements = new JTextField();
		startelements.setBounds(10, 50, 275, 30);
		startelements.setText("Start elements");
		add(startelements);
		
		repeats = new JTextField();
		repeats.setBounds(295, 50, 275, 30);
		repeats.setText("Repeats");
		add(repeats);
		
		//button declaration
		JButton button = new JButton("Start test");
		button.setBounds(10, 10, 560, 30);
		button.setActionCommand("start");
		button.addActionListener(this);
		add(button);
		
		//initialize tester
		DatabaseSpeedTester.getInstance().addDatabaseSpeedTestListener(this);
		
		setVisible(true);
		
	}

	@Override
	public void testComplete(String result) {
		// TODO Auto-generated method stub
		text.setText( text.getText() + result + "\n" );
		text.repaint();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("start")){
			
			int startele = 10;
			int repeat = 5;
			
			try{
				startele = Integer.parseInt( startelements.getText() );
				repeat = Integer.parseInt( repeats.getText() );
			}
			catch(NumberFormatException e1){ }
			
			//interrupt previous thread
			
			if(thread != null){
				if(thread.isAlive()){
					thread.interrupt();
					try {
						thread.join();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("INT!");
				}
			}
			
			text.setText("");
			
			final int fstartele = startele, frepeat = repeat;
			
			thread = new Thread(){
				public void run(){
					
					//set new values
					DatabaseSpeedTester.getInstance().initialize(fstartele, frepeat);
					DatabaseSpeedTester.getInstance().sort();
					
				}
			};
			thread.start();
		}
	}
	
}
