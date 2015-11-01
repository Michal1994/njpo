package gui.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RunAwayButton extends JFrame implements WindowListener, MouseListener {
	
	private JButton button;
	private Random rand;
	
	public RunAwayButton(){
		
		//basic parameters
		super("Crazy Button");
		setBounds(100,100,500,500);
		setLayout(null);
				
		//listener
		addWindowListener(this);
		
		//button declaration
		button = new JButton("Click me!");
		button.setBounds(200, 235, 100, 30);
		button.addMouseListener(this);
		add(button);
		
		//random declaration
		rand = new Random();
		
		setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = -1, y = -1;
		while(y < 0 || y > getHeight()-button.getHeight()){
			y = button.getY() + rand.nextInt(100)*( (rand.nextBoolean())?1:-1 );
		}
		while(x < 0 || x > getWidth()-button.getWidth()){
			x = button.getX() + rand.nextInt(100)*( (rand.nextBoolean())?1:-1 );
		}
		button.setLocation(x, y);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
