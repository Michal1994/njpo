package decorator.game;

public class Pedestrian extends PlayerDecorator {
	
	//private static final int MAX_MOVE = 1;
	
	public Pedestrian(BasicPlayer player) throws InternalPlayerDecoratorException{
		super(player);
	}
	
	@Override
	public char getChar() {
		return 'p';
	}
	
}
