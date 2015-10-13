package main.pkg;

import java.io.File;

import factory.html.SiteFactory;
import factory.html.SiteFactory.SiteType;
import singleton.kasyno.BlackJackPlayer;
import singleton.kasyno.Casino;
import singleton.kasyno.OneHandBanditPlayer;

public class Main {

	public static void main(String[] args) {
		
		//KASYNO SINGLETON
		BlackJackPlayer player1 = new BlackJackPlayer(1000);
		OneHandBanditPlayer player2 = new OneHandBanditPlayer(1000);
		
		System.out.println(player1.playBlackJack());
		System.out.println(player2.playOneHandBandit());
		
		System.out.println(player1.getMoney());
		System.out.println(player2.getMoney());
		System.out.println(Casino.getInstance().getMoney());
		
		//FABRYKA STRON
		SiteFactory.makeSite(SiteType.Gallery).generate(new File("gallery.html"));
		SiteFactory.makeSite(SiteType.Info).generate(new File("info.html"));
		SiteFactory.makeSite(SiteType.News).generate(new File("news.html"));
		SiteFactory.makeSite(SiteType.Contact).generate(new File("contact.html"));
		
	}

}
