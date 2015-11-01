package decorator.game;

public class Car extends PlayerDecorator {
	
	private static final int MAX_MOVE = 4;
	
	public Car(BasicPlayer player) throws InternalPlayerDecoratorException {
		super(player);
	}
	
	@Override
	public void move() {
		int x = super.getX();
		int y = super.getY();
		
		while(x == super.getX() && y == super.getY()){
			super.move();
			int dx = (super.getX() - x)*(MAX_MOVE - 1);
			int dy = (super.getY() - y)*(MAX_MOVE - 1);
			
			if(dx + super.getX() >= 0 && dx + super.getX() < BasicPlayer.MAX_W && dy + super.getY() >= 0 && dy + super.getY() < BasicPlayer.MAX_H){
				super.setX(dx + super.getX());
				super.setY(dy + super.getY());
			}
			else{
				super.setX(x);
				super.setY(y);
			}
			
		}
	}
	
	@Override
	public char getChar() {
		return 'c';
	}
	
}
