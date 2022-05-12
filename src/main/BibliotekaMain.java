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
import enumeracije.EnumPol;
import enumeracije.EnumTipPoveza;
import enumeracije.EnumJezik;

public class BibliotekaMain {
		private static final String KNJIGE_FAJL = "fajlovi/knjige.txt";
		private static final String ADMINISTRATOR_FAJL = "fajlovi/administratori.txt";
		private static final String BIBLIOTEKAR_FAJL = "fajlovi/bibliotekar.txt";
		private static final String CLANBIBLIOTEKE_FAJL = "fajlovi/clanBiblioteke.txt";
		private static final String IZNAJMLJIVANJEKNJIGE_FAJL = "fajlovi/iznajmljivanjeknjige.txt";
		private static final String PRIMERAKKNJIGE_FAJL = "fajlovi/primerakKnjige.txt";
		private static final String TIPCLANARINE_FAJL = "fajlovi/tipClanarine.txt";
		private static final String ZANR_FAJL = "fajlovi/zanr.txt";
		private static final String BIBLIOTEKA_FAJL = "fajlovi/biblioteka.txt";
	
	
	
	public static void main(String[] args) throws IOException {
		Biblioteka biblioteka = new Biblioteka();
		System.out.println("PODACI IZ DATOTEKA:");
	
		Administrator testAdministrator = new Administrator("korisnickoIme", "korisnickaLozinka", 300000, "id123", "imeIPrezime",
				"JMBG", "adresa", EnumPol.ZENSKI, false) ;
		ArrayList<Administrator> sviAdmini = new ArrayList<Administrator>();
		sviAdmini.add(testAdministrator);
		biblioteka.upisiAdministratora(sviAdmini);
		
		ArrayList<Administrator> admin = biblioteka.ucitajAdministratora(ADMINISTRATOR_FAJL);
		biblioteka.setAdministratori(admin);
		System.out.println(biblioteka.getAdministratori());
		System.out.println("_________________________________________");
		
		
		Bibliotekar testBibliotekar = new Bibliotekar("korisnickoIme", "korisnickaLozinka", 300000, "id123", "imeIPrezime",
				"JMBG", "adresa", EnumPol.ZENSKI, false) ;
		ArrayList<Bibliotekar> sviBibliotekari = new ArrayList<Bibliotekar>();
		sviBibliotekari.add(testBibliotekar);
		biblioteka.upisiBibliotekara(sviBibliotekari);

		ArrayList<Bibliotekar> bibl = biblioteka.ucitajBibliotekara(BIBLIOTEKAR_FAJL);
		biblioteka.setBibliotekari(bibl);
		System.out.println(biblioteka.getBibliotekari());
		System.out.println("_________________________________________");
		
		
		ZanrKnjige testZanrKnjige = new ZanrKnjige("id098","oznaka", "opis", false) ;
		ArrayList<ZanrKnjige> sviZanrovi = new ArrayList<ZanrKnjige>();
		sviZanrovi.add(testZanrKnjige);
		biblioteka.upisiZanrKnjige(sviZanrovi);
		
		ArrayList<ZanrKnjige>zanr = biblioteka.ucitajZanrKnjige(ZANR_FAJL);
		biblioteka.setZanroviKnjiga(zanr);
		System.out.println(biblioteka.getZanroviKnjiga());
		System.out.println("_________________________________________");
		
		PrimerakKnjige testPrimerakKnjige = new PrimerakKnjige("idjsj","nazivKnjige",123, EnumTipPoveza.MEK ,EnumJezik.ENGLESKI ,LocalDate.parse("2002-01-01"), true, false) ;
		ArrayList<PrimerakKnjige> sviPrimerci = new ArrayList<PrimerakKnjige>();
		sviPrimerci.add(testPrimerakKnjige);
		biblioteka.upisiPrimerakKnjige(sviPrimerci);
		
		ArrayList<PrimerakKnjige> primerak = biblioteka.ucitajPrimerakKnjige(PRIMERAKKNJIGE_FAJL);
		biblioteka.setPrimerakKnjiga(primerak);
		System.out.println(biblioteka.getPrimerakKnjiga());
		System.out.println("_________________________________________");
		
		Knjiga testKnjiga = new Knjiga("id234", "naslovKnjige", "originalniNaslovKnjige", "pisac", 2002, "opis", EnumJezik.ENGLESKI,false, testZanrKnjige);
		ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
		sveKnjige.add(testKnjiga);
		biblioteka.upisiKnjige(sveKnjige);
		
		ArrayList<Knjiga> knjig = biblioteka.ucitajKnjige(KNJIGE_FAJL);
		biblioteka.setKnjige(knjig);
		System.out.println(biblioteka.getKnjige());
		System.out.println("_________________________________________");
		
		TipClanarine testTipClanarine = new TipClanarine("id23", "naziv", 30000, false) ;
		ArrayList<TipClanarine> sviTipovi = new ArrayList<TipClanarine>();
		sviTipovi.add(testTipClanarine);
		biblioteka.upisiTipClanarine(sviTipovi);

		ArrayList<TipClanarine> tip = biblioteka.ucitajTipClanarine(TIPCLANARINE_FAJL);
		biblioteka.setTipoviClanarine(tip);
		System.out.println(biblioteka.getTipoviClanarine());
		System.out.println("_________________________________________");
		
		ClanBiblioteke testClanBiblioteke = new ClanBiblioteke("br123", LocalDate.parse("2002-01-01"),122 ,true, "id2345", "imeIPrezime", "1234567898765432", "adresa", EnumPol.ZENSKI,false, testTipClanarine) ;
		ArrayList<ClanBiblioteke> sviClanovi = new ArrayList<ClanBiblioteke>();
		sviClanovi.add(testClanBiblioteke);
		biblioteka.upisiClanBiblioteke(sviClanovi);
		
		ArrayList<ClanBiblioteke> clan = biblioteka.ucitajClanBiblioteke(CLANBIBLIOTEKE_FAJL);
		biblioteka.setClanoviBiblioteke(clan);
		System.out.println(biblioteka.getClanoviBiblioteke());
		System.out.println("_________________________________________");
//		
//		IznajmljivanjeKnjige testIznajmljivanjeKnjige = new IznajmljivanjeKnjige(LocalDate.parse("2002-01-01"), LocalDate.parse("2002-01-01"),false,testPrimerakKnjige, testClanBiblioteke, testAdministrator, testBibliotekar) ;
//		ArrayList<IznajmljivanjeKnjige> sveIznajmljivanje = new ArrayList<IznajmljivanjeKnjige>();
//		sveIznajmljivanje.add(testIznajmljivanjeKnjige);
//		biblioteka.upisiIznajmljivanjeKnjige(sveIznajmljivanje);
//		
//		ArrayList<IznajmljivanjeKnjige> iznajmljivanje = biblioteka.ucitajIznajmljivanjeKnjige(IZNAJMLJIVANJEKNJIGE_FAJL);
//		biblioteka.setIznajmljivanjeKnjige(iznajmljivanje);
//		System.out.println(biblioteka.getIznajmljivanjeKnjige());
//		System.out.println("_________________________________________");
//
//		
		
////		Biblioteka testBiblioteka = new Biblioteka() ;
//		ArrayList<Biblioteka> sveBiblioteke = new ArrayList<Biblioteka>();
//		sveBiblioteke.add(testBiblioteka);
//		biblioteka.upisiBiblioteka(sveBiblioteke);
		
//		ArrayList<Biblioteka>bibliotek = biblioteka.ucitajBiblioteka(BIBLIOTEKA_FAJL);
//		biblioteka.setBiblioteke(bibliotek);
//		System.out.println(biblioteka.getBiblioteke());
//		System.out.println("_________________________________________");
	}
	
	
	
	

	

}
