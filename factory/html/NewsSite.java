package factory.html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewsSite extends Site {
	
	public boolean generate(File file){

		BufferedWriter bw = null;
		
		try{
			bw = new BufferedWriter(new FileWriter(file));
			
			//write start default tags
			bw.write("<html>\n<head>\n<title>");
			bw.write("NEWS");
			bw.write("\n</title>\n</head>\n<body>\n");
			
			int size = (int)(Math.random()*100+50);
			for(int i = 0; i < size; i++){
				bw.write("\nNews number: "+(i+1)+"\n<br><br>\n");
				int length = (int)(Math.random()*1000+500);		
				for(int j = 0; j < length; j++){
					bw.write(generateCharacter());
				}
				bw.write("\n<br>\n<hr>\n<hr>\n<hr>");
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
