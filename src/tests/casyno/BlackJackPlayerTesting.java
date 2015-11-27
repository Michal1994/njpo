package tests.casyno;

public class BlackJackPlayerTesting {
	
	private int money;
	private CasinoTesting casino;
	
	public BlackJackPlayerTesting(int money){
		this.money = money;
		casino = CasinoTesting.getInstance();
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return money;
	}
	
	public boolean playBlackJack(){
		if(Math.random() <= CasinoTesting.BLACKJACKWINCHANCE){
			money += casino.blackJackWin();
			return true;
		}
		else{
			money += casino.blackJackLose();
			return false;
		}
	}
	
}
