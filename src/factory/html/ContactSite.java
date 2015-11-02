package factory.html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class ContactSite extends Site {
	
	private static String[] name = {
		"Marcin","£ukasz","Micha³","Magda","Ola","Kasia","Robert",
		"Julia","W³odek","Karol","Tomek","Marta", "Krzysiek"
	};
	
	private static String[] surname = {
		"Krawczyk", "Adamczyk", "Szczepaniak", "Król", "Kasprzyk",
		"Stêpieñ", "Bednarczyk", "Bia³ek", "Szymczak", "Polak"
	};
	
	private static String[] street = {
		"Dworcowa", "Naftowa", "Miarki", "Sucha", "Pusta",
		"Ciasna", "Œliska", "Tabelna", "3 Maja", "11 Listopada"
	};
	
	private static String[] city = {
		"Sosnowiec", "Katowice", "Kraków", "Warszawa", "Lublin",
		"Zamoœæ", "Malbork", "Wroc³aw", "Budgoszcz", "Bêdzin"
	};
	
	public boolean generate(File file){

		BufferedWriter bw = null;
		
		try{
			bw = new BufferedWriter(new FileWriter(file));
			
			//write start default tags
			bw.write("<html>\n<head>\n<title>");
			bw.write("CONTACTS");
			bw.write("\n</title>\n</head>\n<body>\n");
			
			Random rand = new Random();
			DecimalFormat formatter = new DecimalFormat("000000000");
			
			int size = (int)(Math.random()*100+50);
			for(int i = 0; i < size; i++){
				bw.write("Name: "+name[rand.nextInt(name.length)]);
				bw.write(" Surname: "+surname[rand.nextInt(surname.length)]);
				bw.write(" Street: "+street[rand.nextInt(street.length)] + " " + rand.nextInt(99)+1);
				bw.write(" City: "+city[rand.nextInt(city.length)]);
				bw.write(" Phone Number: " + formatter.format(rand.nextInt(500000000)+500000000) + "\n<br>\n");
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
