package collections;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CollectionSpeedTesterFrame extends JFrame implements WindowListener, ArraySpeedTestListener, ActionListener {
	
	private JTextArea text;
	private JTextField startelements;
	private JTextField repeats;
	
	private Thread thread;
	
	public CollectionSpeedTesterFrame(){
		
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
		CollectionSpeedTester.getInstance().addArraySpeedTestListener(this);
		
		setVisible(true);
		
	}

	@Override
	public void testComplete(String result) {
		// TODO Auto-generated method stub
		text.setText( text.getText() + result + "\n" );
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
			
			int startele = 200000;
			int repeat = 20000;
			
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
			
			//set new values
			CollectionSpeedTester.getInstance().initialize(startele, repeat);
			
			thread = new Thread(){
				public void run(){
					int i = 0;
					while(i < 9){
						//run each function in other while ineration
						switch(i){
							case 0:{
								CollectionSpeedTester.getInstance().insertAtBegine();
								break;
							}
							case 1:{
								CollectionSpeedTester.getInstance().insertInMiddle();
								break;
							}
							case 2:{
								CollectionSpeedTester.getInstance().insertAtEnd();
								break;
							}
							case 3:{
								CollectionSpeedTester.getInstance().removeFromBegine();
								break;
							}
							case 4:{
								CollectionSpeedTester.getInstance().removeFromMiddle();
								break;
							}
							case 5:{
								CollectionSpeedTester.getInstance().removeFromEnd();
								break;
							}
							case 6:{
								CollectionSpeedTester.getInstance().getFromBegine();
								break;
							}
							case 7:{
								CollectionSpeedTester.getInstance().getFromMiddle();
								break;
							}
							case 8:{
								CollectionSpeedTester.getInstance().getFromEnd();
								break;
							}
						}
						
						//break if interrupted
						if(Thread.currentThread().isInterrupted()) break;
						
						i++;
						
					}
				}
			};
			thread.start();
		}
	}
	
}
