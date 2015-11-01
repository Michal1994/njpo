package decorator.game;

import java.awt.Point;
import java.util.Random;

public abstract class BasicPlayer {
	
	public static final int MAX_W = 30;
	public static final int MAX_H = 30;
	
	private int x;
	private int y;
	
	public void move(){

		Random r = new Random();
		
		int tx = BasicPlayer.MAX_W;
		int ty = BasicPlayer.MAX_H;
		
		while(tx < 0 || tx >= BasicPlayer.MAX_W){
			tx = r.nextInt(5) - 2;
			tx += x;
		}
		
		while(ty < 0 || ty >= BasicPlayer.MAX_H){
			ty = r.nextInt(5) - 2;
			ty += y;
		}
		
		x = tx;
		y = ty;
		
		System.out.println(x+" "+y);
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean isCollide(BasicPlayer p){
		if(x == p.x && y == p.y) return true;
		return false;
	}
	
	public char getChar(){
		return ' ';
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
}
