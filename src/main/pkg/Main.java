package main.pkg;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import collections.AdressBook;
import collections.CollectionSpeedTester;
import collections.CollectionSpeedTesterFrame;
import collections.TextAnalyzer;
import decorator.LineCounterStream;
import decorator.WordCounterStream;
import decorator.game.GameBoard;
import factory.html.SiteFactory;
import factory.html.SiteFactory.SiteType;
import gui.swing.Calculator;
import gui.swing.HelloWorld;
import gui.swing.PeselCheck;
import gui.swing.RunAwayButton;
import singleton.kasyno.BlackJackPlayer;
import singleton.kasyno.Casino;
import singleton.kasyno.OneHandBanditPlayer;
import threads.FactorialWindow;
import threads.ZipBomb;

public class Main {

	public static void main(String[] args) {
		
		/*
		
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
		
		//DEKORATOR LICZENIE LINII
		InputStream in = null;
		try {
			in = new LineCounterStream(new BufferedInputStream(new FileInputStream(new File("test.txt"))));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int l = 0;
		byte[] b = new byte[1024];
		try {
			System.out.println(in.read(b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//DEKORATOR LICZENIE S£ÓW
		try {
			in = new WordCounterStream(new BufferedInputStream(new FileInputStream(new File("test.txt"))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		l = 0;
		try {
			System.out.println(in.read(b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//DEKORATOR GRA
		GameBoard.getInstance().normalWork();
		
		
		
		//GUI POWITANIE
		new HelloWorld();
		
		
		
		//GUI KALKULATOR
		new Calculator();
		
		
		
		//GUI UCIEKAJACY PRZYCISK
		new RunAwayButton();
		
		
		
		//GUI PESEL
		
		new PeselCheck();
		
		
		
		//TEST PREDKOSCI LIST
		
		new CollectionSpeedTesterFrame();
		
		//LICZENIE ZNAKOW W TEKSCIE
		
		new TextAnalyzer();
		
		//KSIAZKA ADRESOWA
		
		new AdressBook();
		
		//ZIP BOMBA
		
		new ZipBomb();
		
		*/
		
		//SILNIA
		
		new FactorialWindow();
		
	}

}
