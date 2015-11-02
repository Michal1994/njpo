package singleton.kasyno;

public class OneHandBanditPlayer {
	
	private int money;
	private Casino casino;
	
	public OneHandBanditPlayer(int money){
		this.money = money;
		casino = Casino.getInstance();
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return money;
	}
	
	public boolean playOneHandBandit(){
		if(Math.random() <= Casino.ONEHANDBANDITCHANCE){
			money += casino.oneHandBanditWin();
			return true;
		}
		else{
			money += casino.oneHandBanditLose();
			return false;
		}
	}
	
}
