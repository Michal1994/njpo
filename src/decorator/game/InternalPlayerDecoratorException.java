package decorator.game;

public class InternalPlayerDecoratorException extends Exception {
	
	public InternalPlayerDecoratorException(){
		super("Once decorated object can't be decorate more");
	}
	
}
