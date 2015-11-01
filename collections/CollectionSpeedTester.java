package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionSpeedTester {
	
	private static CollectionSpeedTester instance;
	
	private List<String> arraylist;
	private List<String> linkedlist;
	private List<ArraySpeedTestListener> listener = new ArrayList<ArraySpeedTestListener>();
	private int startelements;
	private int repeats;
	
	private CollectionSpeedTester(){
		
	}
	
	public void addArraySpeedTestListener(ArraySpeedTestListener listener){
		this.listener.add(listener);
	}
	
	public void removeArraySpeedTestListener(ArraySpeedTestListener listener){
		this.listener.remove(listener);
	}
	
	public void initialize(int startelements, int repeats){
		//in this test i will use String objects - ""
		arraylist = new ArrayList<String>();
		linkedlist = new LinkedList<String>();
		
		this.startelements = startelements;
		this.repeats = repeats;
		
		//add some elements
		for(int i = 0; i < startelements; i++){
			arraylist.add("");
			linkedlist.add("");
		}
		
	}	
	
	public void insertAtBegine(){
	
		//time variables
		long arraylisttime, linkedlisttime;
		long tmp;
		
		//test insert on begin
		
		arraylisttime = linkedlisttime = 0;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			arraylist.add(0, "");
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			linkedlist.add(0, "");
			linkedlisttime += System.nanoTime() - tmp;
		}
		
		linkedlisttime /= repeats;
		
		String text = "Insert at begin - Arraylist: " + arraylisttime + " ns, LinkedList: " + linkedlisttime + " ns (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<ArraySpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		initialize(startelements, repeats);
		
	}
	
	public void insertInMiddle(){
		
		//time variables
		long arraylisttime, linkedlisttime;
		long tmp;
		
		//test insert on begin
		
		arraylisttime = linkedlisttime = 0;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			arraylist.add(startelements/2, "");
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			linkedlist.add(startelements/2, "");
			linkedlisttime += System.nanoTime() - tmp;
		}
		
		linkedlisttime /= repeats;
		
		String text = "Insert in the middle - Arraylist: " + arraylisttime + " ns, LinkedList: " + linkedlisttime + " ns (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<ArraySpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		initialize(startelements, repeats);
		
	}
	
	public void insertAtEnd(){
		
		//time variables
		long arraylisttime, linkedlisttime;
		long tmp;
		
		//test insert on begin
		
		arraylisttime = linkedlisttime = 0;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			arraylist.add("");
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			linkedlist.add("");
			linkedlisttime += System.nanoTime() - tmp;
		}
		
		linkedlisttime /= repeats;
		
		String text = "Insert at the end - Arraylist: " + arraylisttime + " ns, LinkedList: " + linkedlisttime + " ns (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<ArraySpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		initialize(startelements, repeats);
		
	}
	
	public void removeFromBegine(){
		
		//time variables
		long arraylisttime, linkedlisttime;
		long tmp;
		
		//test insert on begin
		
		arraylisttime = linkedlisttime = 0;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			arraylist.remove(0);
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			linkedlist.remove(0);
			linkedlisttime += System.nanoTime() - tmp;
		}
		
		linkedlisttime /= repeats;
		
		String text = "Remove from begin - Arraylist: " + arraylisttime + " ns, LinkedList: " + linkedlisttime + " ns (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<ArraySpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		initialize(startelements, repeats);
		
	}
	
	public void removeFromMiddle(){
		
		//time variables
		long arraylisttime, linkedlisttime;
		long tmp;
		
		//test insert on begin
		
		arraylisttime = linkedlisttime = 0;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			arraylist.remove(startelements/2);
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			linkedlist.remove(startelements/2);
			linkedlisttime += System.nanoTime() - tmp;
		}
		
		linkedlisttime /= repeats;
		
		String text = "Remove from middle - Arraylist: " + arraylisttime + " ns, LinkedList: " + linkedlisttime + " ns (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<ArraySpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		initialize(startelements, repeats);
		
	}
	
	public void removeFromEnd(){
		
		//time variables
		long arraylisttime, linkedlisttime;
		long tmp;
		int index;
		
		//test insert on begin
		
		arraylisttime = linkedlisttime = 0;
		
		for(int i = 0; i < repeats; i++){
			index = arraylist.size() - 1;
			tmp = System.nanoTime();
			arraylist.remove(index);
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			index = linkedlist.size() - 1;
			tmp = System.nanoTime();
			linkedlist.remove(index);
			linkedlisttime += System.nanoTime() - tmp;
		}
		
		linkedlisttime /= repeats;
		
		String text = "Remove from end - Arraylist: " + arraylisttime + " ns, LinkedList: " + linkedlisttime + " ns (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<ArraySpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		initialize(startelements, repeats);
		
	}
	
	public void getFromBegine(){
		
		//time variables
		long arraylisttime, linkedlisttime;
		long tmp;
		
		//test insert on begin
		
		arraylisttime = linkedlisttime = 0;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			arraylist.get(0);
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			linkedlist.get(0);
			linkedlisttime += System.nanoTime() - tmp;
		}
		
		linkedlisttime /= repeats;
		
		String text = "Get from begin - Arraylist: " + arraylisttime + " ns, LinkedList: " + linkedlisttime + " ns (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<ArraySpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		initialize(startelements, repeats);
		
	}
	
	public void getFromMiddle(){
		
		//time variables
		long arraylisttime, linkedlisttime;
		long tmp;
		
		//test insert on begin
		
		arraylisttime = linkedlisttime = 0;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			arraylist.get(startelements/2);
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			tmp = System.nanoTime();
			linkedlist.get(startelements/2);
			linkedlisttime += System.nanoTime() - tmp;
		}
		
		linkedlisttime /= repeats;
		
		String text = "Get from middle - Arraylist: " + arraylisttime + " ns, LinkedList: " + linkedlisttime + " ns (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<ArraySpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		initialize(startelements, repeats);
		
	}
	
	public void getFromEnd(){
		
		//time variables
		long arraylisttime, linkedlisttime;
		long tmp;
		int index;
		
		//test insert on begin
		
		arraylisttime = linkedlisttime = 0;
		
		for(int i = 0; i < repeats; i++){
			index = arraylist.size() - 1;
			tmp = System.nanoTime();
			arraylist.get(index);
			arraylisttime += System.nanoTime() - tmp;
		}
		
		arraylisttime /= repeats;
		
		for(int i = 0; i < repeats; i++){
			index = linkedlist.size() - 1;
			tmp = System.nanoTime();
			linkedlist.get(index);
			linkedlisttime += System.nanoTime() - tmp;
		}
		
		linkedlisttime /= repeats;
		
		String text = "Get from end - Arraylist: " + arraylisttime + " ns, LinkedList: " + linkedlisttime + " ns (Elements: " + startelements + ", Repeats: " + repeats + ")";
		
		Iterator<ArraySpeedTestListener> it = listener.iterator();
		
		while(it.hasNext())
			it.next().testComplete(text);
		
		initialize(startelements, repeats);
		
	}
	
	public static CollectionSpeedTester getInstance(){
		if(instance == null) instance = new CollectionSpeedTester();
		return instance;
	}
	
}
