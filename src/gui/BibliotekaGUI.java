package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import biblioteka.Biblioteka;
import biblioteka.ClanBiblioteke;
import biblioteka.Knjiga;
import biblioteka.Zaposleni;

public class BibliotekaGUI extends JFrame {
		private static final String putanjaKnjiga = null;
		public ClanBiblioteke selektovanClan;
		public Zaposleni selektovanZaposleni;
		public Knjiga SelektovanKnjige;
		
		private Biblioteka biblioteka;
		private Zaposleni prijavljeniKorisnik;
		private boolean isAdministrator;
		
		String putanjaClanovi, putanjaZaposleni, putanjaKnjige, putanjaPrimerak, putanjaZanr, putanjaClanarina, putanjaIznajmljivanje,putanjaBiblioteka;
		ImageIcon slClanovi, slZaposleni, slKnjige, slPrimerak, slZanr, slClanarina, slIznajmljivanje, slBiblioteka;
		
		JMenuBar 	jLinijaGlavnogMenija;
		JTabbedPane tabbedPane;
		
		//PRVA KARTICA
		JPanel panelClan;
		JLabel labelaClan;
		JPanel 			jPanelSearchAndSortClan;
		
		JScrollPane 	jScrolClan;
		JTable 			jTableClan;
//		ClanTabeleModel modelClan;
		JPanel jPanelZadnjiClan;
		JButton jBtnAddNewClan;
		JButton jBtnEditExistingClan;
		JButton jBtnRemoveExistingClan;
		JButton jBtnViewExistingClan;
		
		//DRUGA KARTICA
		JPanel panelZaposleni;
		JLabel labelaZaposleni;
		JPanel 			jPanelSearchAndSortZaposleni;
		
		JScrollPane 	jScrolZAposleni;
		JTable 			jTableZaposleni;
//		ZaposleniTabeleModel modelZaposleni;
		
		JPanel 			jPanelZadnjiZaposleni;
		JButton 		jBtnAddNewZaposleni;
		JButton 		jBtnEditExistingZaposleni;
		JButton 		jBtnRemoveExistingZaposleni;
		JButton 		jBtnViewExistingZaposleni;
		
		//TRECA KARTICA
		JPanel panelKnjiga;
		JLabel labelaKnjiga;
		
		JPanel 			jPanelSearchAndSortKnjiga;
		
		JScrollPane 	jScrolKnjiga;
		JTable 			jTableKnjiga;
//		KnjigaTabeleModel modelKnjiga;
		
		JPanel 			jPanelZadnjiKnjiga;
		JButton 		jBtnAddNewKnjiga;
		JButton 		jBtnEditExistingKnjiga;
		JButton 		jBtnRemoveExistingKnjiga;
		JButton 		jBtnViewExistingKnjiga;
		
		//	CETVRTA KARTICA
		
		JPanel panel4;
		JLabel labela4;
		
		JPanel panel5;
		JLabel labela5;
		
		JPanel panel6;
		JLabel labela6;
		
		JPanel panel7;
		JLabel labela7;
		
		JPanel panel8;
		JLabel labela8;
		
		
	  public BibliotekaGUI(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik, boolean isAdministrator) {
		putanjaClanovi = "slike/teamwork.png";
		putanjaZaposleni = "slike/employee.png";
		putanjaKnjige = "slike/books.png";
		putanjaPrimerak = "slike/book.png";
		putanjaZanr= "slike/genres.png";
		putanjaClanarina = "slike/money.png";
		putanjaIznajmljivanje= "slike/for-rent.png";
		putanjaBiblioteka = "slike/library.png";
		slClanovi = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaClanovi).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		slZaposleni = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaZaposleni).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		slKnjige= new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaKnjige).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		slPrimerak= new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaPrimerak).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		slZanr= new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaZanr).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		slClanarina= new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaClanarina).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		slIznajmljivanje= new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaIznajmljivanje).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		slBiblioteka= new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaBiblioteka).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		
		setTitle("Biblioteka");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocation(250,100);					
	    postaviProstorZaCrtanjeKomponenti();
	    pack();
	    setSize(900, 550);
	    setVisible(true);
	}
	public void postaviProstorZaCrtanjeKomponenti(){
	  
	    tabbedPane = new JTabbedPane();
	    getContentPane().add(tabbedPane, BorderLayout.CENTER);
	
	    //PRVA KARTICA
	    panelClan = new JPanel(false);
	    labelaClan = new JLabel("");
	    panelClan.add(labelaClan);
	    
	    tabbedPane.addTab("Clanovi Biblioteke", slClanovi, panelClan, "Clanovi Biblioteke");
	    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	    
	    //DRUGA KARTICA
	    panelZaposleni = new JPanel(false); 
	    labelaZaposleni = new JLabel("");
	    panelZaposleni.add(labelaZaposleni);
	    
	    tabbedPane.addTab("Zaposleni", slZaposleni, panelZaposleni, "Zaposleni");
	    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
	    
	    //TRECA KARTICA
	    panelKnjiga = new JPanel(false); 
	    labelaKnjiga = new JLabel("");
	    panelKnjiga.add(labelaKnjiga);
	    
	    tabbedPane.addTab("Knjige", slKnjige, panelKnjiga, "Knjige");
	    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
	    
	    panel4 = new JPanel(false); 
	    labela4 = new JLabel("");
	    panel4.add(labela4);
	    
	    tabbedPane.addTab("Primerak Knjige", slPrimerak, panel4, "Primerak Knjige");
	    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
	    
	    panel5 = new JPanel(false); 
	    labela5 = new JLabel("");
	    panel5.add(labela5);
	    
	    tabbedPane.addTab("Zanr Knjige", slZanr, panel5, "Zanr Knjige");
	    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
	    
	    panel6 = new JPanel(false); 
	    labela6 = new JLabel("");
	    panel6.add(labela6);
	    
	    tabbedPane.addTab("Clanarina", slClanarina, panel5, "Clanarina");
	    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
	    
	    panel7 = new JPanel(false); 
	    labela7 = new JLabel("");
	    panel7.add(labela7);
	    
	    tabbedPane.addTab("Iznajmljivanje Knjige", slIznajmljivanje, panel7, "Iznajmljivanje Knjige");
	    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
	    
	    panel8 = new JPanel(false); 
	    labela8 = new JLabel("");
	    panel8.add(labela8);
	    
	    tabbedPane.addTab("Biblioteka", slBiblioteka, panel8, "Biblioteka");
	    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

	//ZADNJI PANEL
			jPanelZadnjiClan = new JPanel();
			jPanelZadnjiClan.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Opcije rada sa tabelom", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			getContentPane().add(jPanelZadnjiClan, BorderLayout.SOUTH);
			
			jBtnAddNewClan = new JButton("Dodaj Novog");
			jBtnEditExistingClan = new JButton("Izmeni selektovanog");
			jBtnRemoveExistingClan = new JButton("Obrisi selektovanog");
			jBtnViewExistingClan = new JButton("Pregled selektovanog");
			
			jPanelZadnjiClan.add(jBtnAddNewClan);
			jPanelZadnjiClan.add(jBtnRemoveExistingClan);
			jPanelZadnjiClan.add(jBtnViewExistingClan);
			jPanelZadnjiClan.add(jBtnEditExistingClan);
		


		
		
		
		
		
		
		
		
		
		
		
}
}
