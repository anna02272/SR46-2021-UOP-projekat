package main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;
import biblioteka.Knjiga;
import biblioteka.ZanrKnjige;
import enumeracije.EnumJezik;
import enumeracije.EnumPol;

public class BibliotekaMain {
		private static final String KNJIGE_FAJL = "fajlovi/knjige.txt";
		private static final String BIBLIOTEKA_FAJL = "fajlovi/biblioteka.txt";
		private static final String ADMINISTRATOR_FAJL = "fajlovi/administratori.txt";
		private static final String BIBLIOTEKAR_FAJL = "fajlovi/bibliotekar.txt";
		private static final String CLANBIBLIOTEKE_FAJL = "fajlovi/clanBiblioteke.txt";
		private static final String IZNAJMLJIVANJEKNJIGE_FAJL = "fajlovi/iznajmljivanjeknjige.txt";
		private static final String PRIMERAKKNJIGE_FAJL = "fajlovi/primerakKnjige.txt";
		private static final String TIPCLANARINE_FAJL = "fajlovi/tipClanarine.txt";
		private static final String ZANR_FAJL = "fajlovi/zanr.txt";
	
	
	
	public static void main(String[] args) throws IOException {
		Biblioteka biblioteka = new Biblioteka();
		System.out.println("PODACI IZ DATOTEKA:");
	
		Administrator testAdministrator = new Administrator("korisnickoIme", "korisnickaLozinka", 300000, "id123", "imeIPrezime",
				"JMBG", "adresa", EnumPol.ZENSKI, false) ;
		ArrayList<Administrator> admin = biblioteka.ucitajAdministratora(ADMINISTRATOR_FAJL);
		biblioteka.setAdministratori(admin);
		System.out.println(biblioteka.getAdministratori());
		
		Bibliotekar testBibliotekar = new Bibliotekar("korisnickoIme", "korisnickaLozinka", 300000, "id123", "imeIPrezime",
				"JMBG", "adresa", EnumPol.ZENSKI, false) ;
		ArrayList<Bibliotekar> bibl = biblioteka.ucitajBibliotekara(BIBLIOTEKAR_FAJL);
		biblioteka.setBibliotekari(bibl);
		System.out.println(biblioteka.getBibliotekari());
	}
	
	
	
	
	

	

}
