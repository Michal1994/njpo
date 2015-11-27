package tests.casyno;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasinoTestingTest {
	
	BlackJackPlayerTesting bj = new BlackJackPlayerTesting(1000);
	OneHandBanditPlayerTesting ohb = new OneHandBanditPlayerTesting(1000);
	
	@Test
	public void testGetInstance() {
		assertNotNull(CasinoTesting.getInstance());
	}
	
	@Test
	public void testSetMoney() {
		CasinoTesting.getInstance().setMoney(5000);
		assertEquals(5000, CasinoTesting.getInstance().getMoney());
	}
	
	@Test
	public void testBlackJack() {
		CasinoTesting.getInstance().setMoney(5000);
		bj.setMoney(1000);
		boolean b = bj.playBlackJack();
		if(b){
			assertEquals(1000 + CasinoTesting.BLACKJACKWIN, bj.getMoney());
			assertEquals(5000 - CasinoTesting.BLACKJACKWIN, CasinoTesting.getInstance().getMoney());
		}
		else{
			assertEquals(1000 - CasinoTesting.BLACKJACKLOSE, bj.getMoney());
			assertEquals(5000 + CasinoTesting.BLACKJACKLOSE, CasinoTesting.getInstance().getMoney());
		}
	}
	
	@Test
	public void testOneHandBandit() {
		CasinoTesting.getInstance().setMoney(5000);
		ohb.setMoney(1000);
		boolean b = ohb.playOneHandBandit();
		if(b){
			assertEquals(1000 + CasinoTesting.ONEHANDBANDITWIN, ohb.getMoney());
			assertEquals(5000 - CasinoTesting.ONEHANDBANDITWIN, CasinoTesting.getInstance().getMoney());
		}
		else{
			assertEquals(1000 - CasinoTesting.ONEHANDBANDITLOSE, ohb.getMoney());
			assertEquals(5000 + CasinoTesting.ONEHANDBANDITLOSE, CasinoTesting.getInstance().getMoney());
		}
	}

}
