package decorator.game;

import java.awt.Point;

public abstract class PlayerDecorator extends BasicPlayer {
	
	private BasicPlayer player;
	
	public PlayerDecorator(BasicPlayer player) throws InternalPlayerDecoratorException {
		if( !(player instanceof Player || player instanceof Pedestrian) ) throw new InternalPlayerDecoratorException();
		this.player = player;
	}
	
	@Override
	public void move() {
		player.move();
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return player.getX();
	}
	
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return player.getY();
	}
	
	@Override
	public boolean isCollide(BasicPlayer p) {
		return player.isCollide(p);
	}
	
	@Override
	public char getChar(){
		return player.getChar();
	}
	
	@Override
	public void setX(int x) {
		player.setX(x);
	}
	
	@Override
	public void setY(int y) {
		player.setY(y);
	}
	
}
