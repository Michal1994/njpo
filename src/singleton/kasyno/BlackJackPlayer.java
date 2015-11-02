package singleton.kasyno;

public class BlackJackPlayer {
	
	private int money;
	private Casino casino;
	
	public BlackJackPlayer(int money){
		this.money = money;
		casino = Casino.getInstance();
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return money;
	}
	
	public boolean playBlackJack(){
		if(Math.random() <= Casino.BLACKJACKWINCHANCE){
			money += casino.blackJackWin();
			return true;
		}
		else{
			money += casino.blackJackLose();
			return false;
		}
	}
	
}
