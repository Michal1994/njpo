package factory.html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GallerySite extends Site {
	
	public boolean generate(File file){

		BufferedWriter bw = null;
		
		try{
			bw = new BufferedWriter(new FileWriter(file));
			
			//write start default tags
			bw.write("<html>\n<head>\n<title>");
			bw.write("GALLERY");
			bw.write("\n</title>\n</head>\n<body>\n");
			
			int size = (int)(Math.random()*100);
			
			for(int i = 0; i < size; i++){
				bw.write("<img src = \"image/"+(int)(Math.random()*5)+".jpg\">\n<br>\n<hr>\n");
			}
			
			bw.write("</body>\n</html>");
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
