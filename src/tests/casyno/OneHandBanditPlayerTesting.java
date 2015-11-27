package tests.casyno;

public class OneHandBanditPlayerTesting {
	
	private int money;
	private CasinoTesting casino;
	
	public OneHandBanditPlayerTesting(int money){
		this.money = money;
		casino = CasinoTesting.getInstance();
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return money;
	}
	
	public boolean playOneHandBandit(){
		if(Math.random() <= CasinoTesting.ONEHANDBANDITCHANCE){
			money += casino.oneHandBanditWin();
			return true;
		}
		else{
			money += casino.oneHandBanditLose();
			return false;
		}
	}
	
}
