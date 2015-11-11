package decorator.game;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
	
	private static GameBoard instance;
	
	private BasicPlayer[] player;
	
	private GameBoard(){
		
		try{
		
			player = new BasicPlayer[3];
			player[0] = new Pedestrian(new Player());
			player[0].setX(0);
			player[0].setY(5);
			
			//pedestrian get on the bike
			player[1] = new Bike(new Pedestrian(new Player()));
			player[1].setX(10);
			player[1].setY(15);
			
			//pedestrian get into the car
			player[2] = new Car(new Pedestrian(new Player()));
			player[2].setX(20);
			player[2].setY(0);
		
		}
		
		catch(InternalPlayerDecoratorException e){
			e.printStackTrace();
		}
	}
	
	public void stepWork(){
		Scanner s = new Scanner(System.in);
		while(work()){
			s.next();
		}
	}
	
	public void normalWork(){
		while(work()){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private boolean work(){
		for(BasicPlayer p: player){
			p.move();
		}
		
		boolean ctrl = true;
		
		for(int i = 0; i < player.length; i++){
			for(int j = i + 1; j < player.length; j++){
				if(player[i].isCollide(player[j])) ctrl = false;
			}
		}
		
		System.out.println(ctrl);

		char[][] array = new char[BasicPlayer.MAX_W][BasicPlayer.MAX_H];
			
		for(int i = 0; i < array.length; i++) Arrays.fill(array[i], ' ');
			
		array[player[0].getX()][player[0].getY()] = player[0].getChar();
		array[player[1].getX()][player[1].getY()] = player[1].getChar();
		array[player[2].getX()][player[2].getY()] = player[2].getChar();
			
		for(int i = 0, size = BasicPlayer.MAX_H*BasicPlayer.MAX_W; i < size; i++){
			if(i%BasicPlayer.MAX_W == 0) System.out.println();
			System.out.print(array[i%BasicPlayer.MAX_W][i/BasicPlayer.MAX_W]);
		}
		
		System.out.println("\n\n");
		
		return ctrl;
		
	}
	
	public static GameBoard getInstance(){
		if(instance == null) instance = new GameBoard();
		return instance;
	}
	
}
