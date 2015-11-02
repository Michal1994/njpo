package factory.html;

import java.io.File;

public abstract class Site {
	
	public boolean generate(File file){
		return true;
	}
	
	protected static String generateCharacter(){
		double rand = Math.random();
		return ( rand > 0.49 ? ( rand > 0.98 ? "\n<br>\n" : (char)((int)(Math.random()*26)+65)+"" ) : (char)((int)(Math.random()*26)+97)+"" );
	}
	
}
