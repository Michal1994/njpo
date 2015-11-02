package collections;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAnalyzer extends JFrame implements WindowListener, ActionListener {
	
	//user in this program can choose encoding from available encodings list - default windows .txt encode is windows-1250
	
	private JTextArea textarea;
	private JComboBox<String> encoding;
	
	public TextAnalyzer() {
		
		//basic parameters
		super("Text analyzer");
		setBounds(100, 100, 300, 500);
		setLayout(null);
		
		//listener adding
		addWindowListener(this);
		
		//text area declaration
		textarea = new JTextArea("Click \"Load File\" button to load file");
		textarea.setEditable(false);
		JScrollPane pane = new JScrollPane(textarea);
		pane.setBounds(10, 50, 260, 400);
		add(pane);
		
		//button declaration
		JButton button = new JButton("Load File");
		button.setBounds(10, 10, 125, 30);
		button.setActionCommand("load");
		button.addActionListener(this);
		add(button);
		
		//encoding list declare
		List<Entry<String, Charset>> set = new ArrayList<Entry<String, Charset>>( Charset.availableCharsets().entrySet() );
		
		String[] elements = new String[set.size()];
		
		for( int i = 0; i < elements.length; i++ ){
			elements[i] = set.get(i).getKey();
		}
		
		encoding = new JComboBox<String>(elements);
		encoding.setBounds(145, 10, 125, 30);
		add(encoding);
		
		setVisible(true);
		
	}
	
	public void updateTextArea(List<Entry<Character, Integer>> list){
		
		//clear text area
		textarea.setText("");
		
		//iterator and temporary object
		Iterator<Entry<Character, Integer>> it = list.iterator();
		Entry<Character, Integer> listelement;
		
		//write objects
		while(it.hasNext()){
			
			listelement = it.next();
			
			//add line to text area
			textarea.setText( textarea.getText() + "Character: \"" + characterConversion( listelement.getKey() ) + "\" Amount: " + listelement.getValue() + "\n" );
			
		}
		
	}
	
	private String characterConversion(char c){
		
		String ret;
		
		//convert characters to text - if white character it will be represented by its name
		switch(c){
		
			case '\n':{
				ret = "ENTER";
				break;
			}
			case ' ':{
				ret = "SPACE";
				break;
			}
			case '\t':{
				ret = "TAB";
				break;
			}
			default : ret = c + "";
			
		}
		
		return ret;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("load")){
			//load file - file chooser
			JFileChooser filechooser = new JFileChooser();
			filechooser.setDialogTitle("Choose File");
			//user can only load files
			filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int result = filechooser.showOpenDialog(null);
			
			//if file selected
			if(result == JFileChooser.APPROVE_OPTION){
				//get file pointer
				File file = filechooser.getSelectedFile();
				
				//file analyze
				
				//declare map
				Map<Character, Integer> map = new TreeMap<Character, Integer>();
				
				//declare input
				InputStreamReader in = null;
				
				//reading
				try{
					in = new InputStreamReader(new FileInputStream(file), (String)encoding.getSelectedItem());
					
					int b;
					char character;
					while( ( b = in.read() ) != -1 ){
						
						//if enter character using two bytes skip second byte
						if(b == 13) continue;
						
						character = (char) b;
						
						//adding or increment map keys
						if(map.containsKey(character)){
							
							map.replace(character, map.get(character) + 1);
							
						}
						else{
							map.put(character, 1);
						}
						
					}
					
					List<Entry<Character, Integer>> set = new ArrayList<Entry<Character, Integer>>(map.entrySet());
					
					//sort set by value
					Collections.sort(set, new Comparator< Entry<Character, Integer> >() {

						//comparator using method compare method and compare o2 and o1 objects integer values 
						@Override
						public int compare(Entry<Character, Integer> o1,
								Entry<Character, Integer> o2) {
								
								return o2.getValue().compareTo(o1.getValue());
							
						}
					});
					
					updateTextArea(set);
					
				}
				catch(IOException e1){
					e1.printStackTrace();
				}
				finally{
					try {
						in.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
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
