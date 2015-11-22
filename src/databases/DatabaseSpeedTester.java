package databases;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DatabaseSpeedTester {
	
	private static DatabaseSpeedTester instance;
	
	private List<Long> arraylist;
	private DBConnector connector;
	private List<DatabaseSpeedTestListener> listener = new ArrayList<DatabaseSpeedTestListener>();
	private int startelements;
	private int repeats;
	private Random r;
	
	private DatabaseSpeedTester(){
		
	}
	
	public void addDatabaseSpeedTestListener(DatabaseSpeedTestListener listener){
		this.listener.add(listener);
	}
	
	public void removeDatabaseSpeedTestListener(DatabaseSpeedTestListener listener){
		this.listener.remove(listener);
	}
	
	public void initialize(int startelements, int repeats){
		//in this test i will use String objects - ""
		arraylist = new ArrayList<Long>();
		connector = DBConnector.getInstance();
		connector.connect("org.sqlite.JDBC", "jdbc:sqlite:baza.db");
		
		this.startelements = startelements;
		this.repeats = repeats;
		
		r = new Random();
		
		connector.excuteUpdate("CREATE TABLE TESTER(ID BIGINT)");
		
		//add some elements
		
		long inserttime = 0;
		long tmp = 0;
		
		connector.excuteUpdate("DELETE FROM TESTER");
		
		for(int i = 0; i < startelements; i++){
			arraylist.add(r.nextLong());
			tmp = System.nanoTime();
			connector.excuteUpdate("INSERT INTO TESTER VALUES("+r.nextLong()+")");
			
			inserttime += System.nanoTime() - tmp;
			
			//show progress
			if(i % (startelements/10) == 0){
				Iterator<DatabaseSpeedTestListener> it = listener.iterator();
				
				while(it.hasNext())
					it.next().testComplete( "Insert progress: " + ( ( 100*i ) / startelements ) + "%" );
			}
			
		}
		
		String text = "Insert progress: " + 100 + "%\nDatabase insert time:" + inserttime/1000000 + " ms (Elements: " + startelements + ")";
		
		Iterator<DatabaseSpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
	}	
	
	public void sort(){
		
		//time variables
		long arraylisttime, databasetime;
		long tmp;
		
		//test insert on begin
		
		arraylisttime = databasetime = 0;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			Collections.sort(arraylist);
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			connector.excuteQuery("SELECT * FROM TESTER ORDER BY ID ASC");
			databasetime += System.nanoTime() - tmp;
		}
		
		databasetime /= repeats;
		
		String text = "Ascending sort - Arraylist: " + arraylisttime/1000 + " us, Database: " + databasetime/1000 + " us (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<DatabaseSpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		//reinitialize array
		arraylist.clear();
		for(int i = 0; i < startelements; i++)
			arraylist.add(r.nextLong());
		
	}
	
	public static DatabaseSpeedTester getInstance(){
		if(instance == null) instance = new DatabaseSpeedTester();
		return instance;
	}
	
}
