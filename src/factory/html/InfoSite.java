package factory.html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InfoSite extends Site {

	public boolean generate(File file){

		BufferedWriter bw = null;
		
		try{
			bw = new BufferedWriter(new FileWriter(file));
			
			//write start default tags
			bw.write("<html>\n<head>\n<title>");
			bw.write("INFO");
			bw.write("\n</title>\n</head>\n<body>\n");
			
			int size = (int)(Math.random()*10000+5000);
			
			for(int i = 0; i < size; i++){
				bw.write( generateCharacter() );
			}
			
			bw.write("\n</body>\n</html>");
		}
		catch(IOException e){
			return false;
		}
		finally{
			try {
				bw.close();
			} catch (IOException e) {}
		}
		
		return true;

	}
	
}
