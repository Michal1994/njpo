package tests.casyno;

public class CasinoTesting {
	
	public static final int BLACKJACKLOSE = 12;
	public static final int BLACKJACKWIN = 1300;
	public static final int ONEHANDBANDITLOSE = 18;
	public static final int ONEHANDBANDITWIN = 2100;
	
	public static final double BLACKJACKWINCHANCE = 0.3;
	public static final double ONEHANDBANDITCHANCE = 0.2;
	
	private static CasinoTesting instance;
	
	private int money;
	
	private CasinoTesting(){
		money = 100000;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return money;
	}
	
	public int blackJackLose(){
		money += BLACKJACKLOSE;
		return -BLACKJACKLOSE;
	}
	
	public int blackJackWin(){
		money -= BLACKJACKWIN;
		return BLACKJACKWIN;
	}
	
	public int oneHandBanditLose(){
		money += ONEHANDBANDITLOSE;
		return -ONEHANDBANDITLOSE;
	}
	
	public int oneHandBanditWin(){
		money -= ONEHANDBANDITWIN;
		return ONEHANDBANDITWIN;
	}
	
	public static CasinoTesting getInstance(){
		if(instance == null) instance = new CasinoTesting();
		return instance;
	}
	
}