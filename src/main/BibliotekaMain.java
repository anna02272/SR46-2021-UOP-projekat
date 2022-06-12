package main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;
import biblioteka.ClanBiblioteke;
import biblioteka.IznajmljivanjeKnjige;
import biblioteka.Knjiga;
import biblioteka.PrimerakKnjige;
import biblioteka.TipClanarine;
import biblioteka.ZanrKnjige;
import biblioteka.Zaposleni;
import enumeracije.EnumPol;
import enumeracije.EnumTipPoveza;
//import gui.BibliotekaGUI;
import gui.Login;
import enumeracije.EnumJezik;

public class BibliotekaMain {
		public static final String KNJIGE_FAJL = "fajlovi/knjige.txt";
		public static final String ZAPOSLENI_FAJL = "fajlovi/zaposleni.txt";
		public static final String ADMINISTRATOR_FAJL = "fajlovi/administratori.txt";
		public static final String BIBLIOTEKAR_FAJL = "fajlovi/bibliotekar.txt";
		public static final String CLANBIBLIOTEKE_FAJL = "fajlovi/clanBiblioteke.txt";
		public static final String IZNAJMLJIVANJEKNJIGE_FAJL = "fajlovi/iznajmljivanjeknjige.txt";
		public static final String PRIMERAKKNJIGE_FAJL = "fajlovi/primerakKnjige.txt";
		public static final String TIPCLANARINE_FAJL = "fajlovi/tipClanarine.txt";
		public static final String ZANR_FAJL = "fajlovi/zanr.txt";
		public static final String BIBLIOTEKA_FAJL = "fajlovi/biblioteka.txt";
	
	
	
	public static void main(String[] args) throws IOException {
		Biblioteka bibliotekaNova = new Biblioteka();
		bibliotekaNova.ucitajAdministratora(ADMINISTRATOR_FAJL);
		bibliotekaNova.ucitajBibliotekara(BIBLIOTEKAR_FAJL);
		bibliotekaNova.ucitajBiblioteka(BIBLIOTEKA_FAJL);
		bibliotekaNova.ucitajClanBiblioteke(CLANBIBLIOTEKE_FAJL);
		bibliotekaNova.ucitajIznajmljivanjeKnjige(IZNAJMLJIVANJEKNJIGE_FAJL);
		bibliotekaNova.ucitajZanrKnjige(ZANR_FAJL);
		bibliotekaNova.ucitajKnjige(KNJIGE_FAJL);
		bibliotekaNova.ucitajPrimerakKnjige(PRIMERAKKNJIGE_FAJL);
		bibliotekaNova.ucitajTipClanarine(PRIMERAKKNJIGE_FAJL);
		
		bibliotekaNova.ucitajClanBiblioteke(CLANBIBLIOTEKE_FAJL);
		
		
//		BibliotekaGUI mf = new BibliotekaGUI();
//	    mf.setVisible(true);
//		}
	
		Login lp = new Login(bibliotekaNova);
		lp.setVisible(true);
		
		
		
//		System.out.println("PODACI IZ DATOTEKA:");
//	
//		Administrator testAdministrator = new Administrator("korisnickoIme", "korisnickaLozinka", 300000, "id123", "imeIPrezime",
//				"JMBG", "adresa", EnumPol.ZENSKI, false) ;
//		ArrayList<Administrator> sviAdmini = new ArrayList<Administrator>();
//		sviAdmini.add(testAdministrator);
//		bibliotekaNova.upisiAdministratora(sviAdmini);
//		
//		ArrayList<Administrator> admin = bibliotekaNova.ucitajAdministratora(ADMINISTRATOR_FAJL);
//		bibliotekaNova.setAdministratori(admin);
//		System.out.println(bibliotekaNova.getAdministratori());
//		System.out.println("_________________________________________");
		
		
//		Bibliotekar testBibliotekar = new Bibliotekar("korisnickoIme", "korisnickaLozinka", 300000, "id123", "imeIPrezime",
//				"JMBG", "adresa", EnumPol.ZENSKI, false) ;
//		ArrayList<Bibliotekar> sviBibliotekari = new ArrayList<Bibliotekar>();
//		sviBibliotekari.add(testBibliotekar);
//		bibliotekaNova.upisiBibliotekara(sviBibliotekari);
//
//		ArrayList<Bibliotekar> bibl = bibliotekaNova.ucitajBibliotekara(BIBLIOTEKAR_FAJL);
//		bibliotekaNova.setBibliotekari(bibl);
//		System.out.println(bibliotekaNova.getBibliotekari());
//		System.out.println("_________________________________________");
			
		
//		ZanrKnjige testZanrKnjige = new ZanrKnjige("id098","oznaka", "opis", false) ;
//		ArrayList<ZanrKnjige> sviZanrovi = new ArrayList<ZanrKnjige>();
//		sviZanrovi.add(testZanrKnjige);
//		bibliotekaNova.upisiZanrKnjige(sviZanrovi);
//		
//		ArrayList<ZanrKnjige>zanr = bibliotekaNova.ucitajZanrKnjige(ZANR_FAJL);
//		bibliotekaNova.setZanroviKnjiga(zanr);
//		System.out.println(bibliotekaNova.getZanroviKnjiga());
//		System.out.println("_________________________________________");
//		
//		
//		Knjiga testKnjiga = new Knjiga("id234", "naslovKnjige", "originalniNaslovKnjige", "pisac", 2002, "opis", EnumJezik.ENGLESKI,false, testZanrKnjige);
//		ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
//		sveKnjige.add(testKnjiga);
//		bibliotekaNova.upisiKnjige(sveKnjige);
//		
//		ArrayList<Knjiga> knjig = bibliotekaNova.ucitajKnjige(KNJIGE_FAJL);
//		bibliotekaNova.setKnjige(knjig);
//		System.out.println(bibliotekaNova.getKnjige());
//		System.out.println("_________________________________________");
//		
//		
//		PrimerakKnjige testPrimerakKnjige = new PrimerakKnjige("idjsj",testKnjiga,123, EnumTipPoveza.MEK ,EnumJezik.ENGLESKI ,LocalDate.parse("2002-01-01"), true, false) ;
//		ArrayList<PrimerakKnjige> sviPrimerci = new ArrayList<PrimerakKnjige>();
//		sviPrimerci.add(testPrimerakKnjige);
//		bibliotekaNova.upisiPrimerakKnjige(sviPrimerci);
//		
//		ArrayList<PrimerakKnjige> primerak = bibliotekaNova.ucitajPrimerakKnjige(PRIMERAKKNJIGE_FAJL);
//		bibliotekaNova.setPrimerakKnjiga(primerak);
//		System.out.println(bibliotekaNova.getPrimerakKnjiga());
//		System.out.println("_________________________________________");
//		
//		TipClanarine testTipClanarine = new TipClanarine("id23", "naziv", 30000, false) ;
//		ArrayList<TipClanarine> sviTipovi = new ArrayList<TipClanarine>();
//		sviTipovi.add(testTipClanarine);
//		bibliotekaNova.upisiTipClanarine(sviTipovi);

//		ArrayList<TipClanarine> tip = bibliotekaNova.ucitajTipClanarine(TIPCLANARINE_FAJL);
//		bibliotekaNova.setTipoviClanarine(tip);
//		System.out.println(bibliotekaNova.getTipoviClanarine());
//		System.out.println("_________________________________________");
//		
//		ClanBiblioteke testClanBiblioteke = new ClanBiblioteke("br123", LocalDate.parse("2002-01-01"),122 ,true, "id2345", "imeIPrezime", "1234567898765432", "adresa", EnumPol.ZENSKI,false, testTipClanarine) ;
//		ArrayList<ClanBiblioteke> sviClanovi = new ArrayList<ClanBiblioteke>();
//		sviClanovi.add(testClanBiblioteke);
//		bibliotekaNova.upisiClanBiblioteke(sviClanovi);
//		
//		ArrayList<ClanBiblioteke> clan = bibliotekaNova.ucitajClanBiblioteke(CLANBIBLIOTEKE_FAJL);
//		bibliotekaNova.setClanoviBiblioteke(clan);
//		System.out.println(bibliotekaNova.getClanoviBiblioteke());
//		System.out.println("_________________________________________");
//		
//		IznajmljivanjeKnjige testIznajmljivanjeKnjige = new IznajmljivanjeKnjige(LocalDate.parse("2002-01-01"), LocalDate.parse("2002-01-01"),false,testPrimerakKnjige, testClanBiblioteke, testAdministrator, testBibliotekar) ;
//		ArrayList<IznajmljivanjeKnjige> sveIznajmljivanje = new ArrayList<IznajmljivanjeKnjige>();
//		sveIznajmljivanje.add(testIznajmljivanjeKnjige);
//		bibliotekaNova.upisiIznajmljivanjeKnjige(sveIznajmljivanje);
//		
//		ArrayList<IznajmljivanjeKnjige> iznajmljivanje = bibliotekaNova.ucitajIznajmljivanjeKnjige(IZNAJMLJIVANJEKNJIGE_FAJL);
//		bibliotekaNova.setIznajmljivanjeKnjige(iznajmljivanje);
//		System.out.println(bibliotekaNova.getIznajmljivanjeKnjige());
//		System.out.println("_________________________________________");
		
		
//		Biblioteka testBiblioteka = new Biblioteka("id", " naziv", "adresa", "telefon","Od 9 Do 9") ;
//		ArrayList<Biblioteka> sveBiblioteke = new ArrayList<Biblioteka>();
//		sveBiblioteke.add(testBiblioteka);
//		bibliotekaNova.upisiBiblioteka(sveBiblioteke);
//		
//		ArrayList<Biblioteka>bibliotek = bibliotekaNova.ucitajBiblioteka(BIBLIOTEKA_FAJL);
//		bibliotekaNova.setBiblioteke(bibliotek);
//		System.out.println(bibliotekaNova.getBiblioteke());
//		System.out.println("_________________________________________");
	}
}
		
		

	
	
	

	

