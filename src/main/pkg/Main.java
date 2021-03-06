package main.pkg;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import profiling.AdressBookDBProfiling;
import profiling.ZipBombProfiling;
import collections.AdressBook;
import collections.CollectionSpeedTester;
import collections.CollectionSpeedTesterFrame;
import collections.TextAnalyzer;
import databases.AdressBookDB;
import databases.DBConnector;
import databases.DatabaseSpeedTesterFrame;
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
		
		//DEKORATOR LICZENIE S��W
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
		GameBoard.getInstance().stepWork();
		
		
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
		
		
		
		//SILNIA
		
		new FactorialWindow();
		
		//BAZA SINGLETON
		
		DBConnector.getInstance().connect("org.sqlite.JDBC", "jdbc:sqlite:baza.db");
		System.out.println(DBConnector.getInstance().excuteUpdate("drop table test"));
		System.out.println(DBConnector.getInstance().excuteUpdate("create table test (id NUMBER(4), name VARCHAR2(25))"));
		System.out.println(DBConnector.getInstance().excuteUpdate("insert into test values (1, 'aaa')"));
		System.out.println(DBConnector.getInstance().excuteUpdate("insert into test values (2, 'bbb')"));
		System.out.println(DBConnector.getInstance().excuteUpdate("insert into test values (3, 'ccc')"));
		ResultSet rs = DBConnector.getInstance().excuteQuery("select * from test");
		
		try {
			while(rs.next()){
				
				System.out.println(rs.getInt("id") + " " + rs.getString("name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//KSIAZKA TELEFONICZNA Z BAZA DANYCH
		new AdressBookDB();
		
		//TESTER PREDKOSCI BAZY
		new DatabaseSpeedTesterFrame();
		
		//PROFILOWANIE KSIAZKI ADRESOWEJ
		new AdressBookDBProfiling();
		
		*/
		
		//PROFILOANIE ZIP BOMBY
		new ZipBombProfiling();
		
	}

}
