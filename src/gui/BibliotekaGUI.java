package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import biblioteka.Biblioteka;
import biblioteka.Zaposleni;
import guiFormeZaPrikaz.AdministratoriProzor;
import guiFormeZaPrikaz.BibliotekaProzor;
import guiFormeZaPrikaz.BibliotekariProzor;
import guiFormeZaPrikaz.ClanProzor;
import guiFormeZaPrikaz.ClanarinaProzor;
import guiFormeZaPrikaz.IznajmljivanjeProzor;
import guiFormeZaPrikaz.KnjigaProzor;
import guiFormeZaPrikaz.PrimerakProzor;
import guiFormeZaPrikaz.ZanrProzor;


public class BibliotekaGUI extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	
	String putanjaClanovi, putanjaAdministrator, putanjaBibliotekar,
	putanjaKnjige, putanjaPrimerak, putanjaZanr, putanjaClanarina, 
	putanjaIznajmljivanje,putanjaBiblioteka;

	private JMenu clanoviMenu = new JMenu("Clan Biblioteke");
	private JMenuItem clanoviItem = new JMenuItem("Clan Biblioteke");

	private JMenu zaposleniMenu = new JMenu("Zaposleni");
	private JMenuItem administratorItem = new JMenuItem("Administrator");
	private JMenuItem bibliotekarItem = new JMenuItem("Bibliotekar");
	
	private JMenu knjigeMenu = new JMenu("Knjige");
	private JMenuItem knjigeItem = new JMenuItem("Knjiga");
	private JMenuItem primerciItem = new JMenuItem("Primerak Knjige");
	
	private JMenu zanrMenu = new JMenu("Zanr");
	private JMenuItem zanrItem = new JMenuItem("Zanr");
	
	private JMenu clanarinaMenu = new JMenu("Clanarina");
	private JMenuItem clanarinaItem = new JMenuItem("Clanarina");
	
	private JMenu iznajmljivanjeMenu = new JMenu("Iznajmljivanje");
	private JMenuItem iznajmljivanjeItem = new JMenuItem("Iznajmljivanje");
	
	private JMenu bibliotekaMenu = new JMenu("Biblioteka");
	private JMenuItem bibliotekaItem = new JMenuItem("Biblioteka");
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniKorisnik;
	
	public BibliotekaGUI(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik,boolean isAdministrator) {
		this.biblioteka = biblioteka;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Biblioteka: " + prijavljeniKorisnik.getKorisnickoIme());
		setSize(700, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(clanoviMenu);
		clanoviMenu.add(clanoviItem);
		
		mainMenu.add(zaposleniMenu);
		zaposleniMenu.add(administratorItem);
		zaposleniMenu.add(bibliotekarItem);
		
		mainMenu.add(knjigeMenu);
		knjigeMenu.add(knjigeItem);
		knjigeMenu.add(primerciItem);
		
		mainMenu.add(zanrMenu);
		zanrMenu.add(zanrItem);
		
		mainMenu.add(clanarinaMenu);
		clanarinaMenu.add(clanarinaItem);
		
		mainMenu.add(iznajmljivanjeMenu);
		iznajmljivanjeMenu.add(iznajmljivanjeItem);
		
		mainMenu.add(bibliotekaMenu);
		bibliotekaMenu.add(bibliotekaItem);
		//if(isAdministrator) {}
		

	}
	
	private void initActions() {
		administratorItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratoriProzor pp = new AdministratoriProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		bibliotekarItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekariProzor pp = new BibliotekariProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		
		clanarinaItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanarinaProzor pp = new ClanarinaProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		clanoviItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanProzor pp = new ClanProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		iznajmljivanjeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjeProzor pp = new IznajmljivanjeProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		bibliotekaItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekaProzor pp = new BibliotekaProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		knjigeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigaProzor pp = new KnjigaProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		primerciItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerakProzor pp = new PrimerakProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		zanrItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanrProzor pp = new ZanrProzor(biblioteka);
				pp.setVisible(true);
			}
		});
		
		
	}
}

