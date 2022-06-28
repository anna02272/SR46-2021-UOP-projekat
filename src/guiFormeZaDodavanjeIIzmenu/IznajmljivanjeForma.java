package guiFormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;
import biblioteka.ClanBiblioteke;
import biblioteka.IznajmljivanjeKnjige;
import biblioteka.Knjiga;
import biblioteka.PrimerakKnjige;
import enumeracije.EnumTipPoveza;
import enumeracije.EnumJezik;

public class IznajmljivanjeForma extends JFrame{
	
	private JLabel lblIznaj = new JLabel("Datum iznajmljivanja");
	private JTextField txtIznaj = new JTextField(20);
	
	private JLabel lblVrac = new JLabel("Datum vracanja");
	private JTextField txtVrac = new JTextField(20);
	
	private JLabel lblObrisan = new JLabel("Obrisan");
	private JCheckBox txtObrisan = new JCheckBox("Obrisan");
	
	private JLabel lblPrimerak = new JLabel("Primerak knjige");
	private JComboBox cbPrimerak = new JComboBox();
	
	private JLabel lblClan = new JLabel("Clan Biblioteke");
	private JComboBox cbClan = new JComboBox();
	
	private JLabel lblAdmin = new JLabel("Administrator");
	private JComboBox cbAdmin = new JComboBox();
	
	private JLabel lblBibl = new JLabel("Bibliotekar");
	private JComboBox cbBibl = new JComboBox();
	
	
	

	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private IznajmljivanjeKnjige iznajmljivanjeKnjige;
	
	public IznajmljivanjeForma(Biblioteka biblioteka, IznajmljivanjeKnjige iznajmljivanjeKnjige) {
		this.biblioteka = biblioteka;
		this.iznajmljivanjeKnjige = iznajmljivanjeKnjige;
		if(iznajmljivanjeKnjige == null) {
			setTitle("Dodavanje iznajmljivanja");
		}else {
			setTitle("Izmena podataka - " + iznajmljivanjeKnjige.getDatumIznajmljivanja());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLocation(500,200);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		ArrayList<PrimerakKnjige> primerci = biblioteka.sviNeobrisaniPrimerak();
		for (PrimerakKnjige primerak: primerci) {
			cbPrimerak.addItem(primerak.getKnjiga().getNaslovKnjige());
		}
		
		ArrayList<ClanBiblioteke> clanovi = biblioteka.sviNeobrisaniClanovi();
		for (ClanBiblioteke clanBiblioteke: clanovi) {
			cbClan.addItem(clanBiblioteke.getImeIPrezime());
		}
		
		ArrayList<Administrator> admini = biblioteka.sviNeobrisaniAdministratori();
		for (Administrator administrator: admini) {
			cbAdmin.addItem(administrator.getImeIPrezime());
		}
		
		ArrayList<Bibliotekar> bibliotekari = biblioteka.sviNeobrisaniBibliotekari();
		for (Bibliotekar bibliotekar : bibliotekari) {
			cbBibl.addItem(bibliotekar.getImeIPrezime());
		}

		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(iznajmljivanjeKnjige != null) {
			popuniPolja();
		}
		add(lblIznaj);
		add(txtIznaj);
		
		add(lblVrac);
		add(txtVrac);
		
		add(lblObrisan);
		add(txtObrisan);
		
		add(lblPrimerak);
		add(cbPrimerak);
		
		add(lblClan);
		add(cbClan);
		
		add(lblAdmin);
		add(cbAdmin);
		
		add(lblBibl);
		add(cbBibl);
		
		
		
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCanel);
	}
	
	private void initActions() {
		btnCanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjeForma.this.dispose();
				IznajmljivanjeForma.this.setVisible(false);
			}
		});
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int primerakId = cbPrimerak.getSelectedIndex();
					int clanId = cbClan.getSelectedIndex();
					int adminId = cbAdmin.getSelectedIndex();
					int biblId = cbBibl.getSelectedIndex();
					LocalDate datumIznajmljivanja = LocalDate.parse(txtIznaj.getText().trim());
					LocalDate datumVracanja = LocalDate.parse(txtVrac.getText().trim());
					Boolean obrisan = txtObrisan.isSelected();
					PrimerakKnjige primerak= biblioteka.sviNeobrisaniPrimerak().get(primerakId);
					ClanBiblioteke clanBiblioteke = biblioteka.sviNeobrisaniClanovi().get(clanId);
					Administrator administrator = biblioteka.sviNeobrisaniAdministratori().get(adminId);
					Bibliotekar bibliotekar = biblioteka.sviNeobrisaniBibliotekari().get(biblId);
					 
					if(iznajmljivanjeKnjige == null) { // DODAVANJE:
						IznajmljivanjeKnjige novi = new IznajmljivanjeKnjige(datumIznajmljivanja, datumVracanja,false, primerak,clanBiblioteke,administrator, bibliotekar );
						biblioteka.dodajIznajmljivanje(novi);
					}else { // IZMENA:
						iznajmljivanjeKnjige.setDatumIznajmljivanja(datumIznajmljivanja);
						iznajmljivanjeKnjige.setDatumVracanja(datumVracanja);
						iznajmljivanjeKnjige.setObrisan(obrisan);
						iznajmljivanjeKnjige.setPrimerak(primerak);
						iznajmljivanjeKnjige.setClan(clanBiblioteke);
						iznajmljivanjeKnjige.setAdministrator(administrator);
						iznajmljivanjeKnjige.setBibliotekar(bibliotekar);
					}
					
					biblioteka.upisiIznajmljivanjeKnjige("fajlovi/iznajmljivanjeknjige.txt");
					IznajmljivanjeForma.this.dispose();
					IznajmljivanjeForma.this.setVisible(false);
					
					
				}
			}
		});
	}
	
	private void popuniPolja() {
		txtIznaj.setText(iznajmljivanjeKnjige.getDatumIznajmljivanja().toString());
		txtVrac.setText(iznajmljivanjeKnjige.getDatumVracanja().toString());
		txtObrisan.setSelected(iznajmljivanjeKnjige.isObrisan());
		cbPrimerak.setSelectedItem(iznajmljivanjeKnjige.getPrimerak());
		cbClan.setSelectedItem(iznajmljivanjeKnjige.getClan());
		cbAdmin.setSelectedItem(iznajmljivanjeKnjige.getAdministrator());
		cbBibl.setSelectedItem(iznajmljivanjeKnjige.getBibliotekar());
	
		
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtIznaj.getText().trim().equals("")) {
			poruka += "- Unesite datum iznajmljivanja\n";
			ok = false;
		}
		
		if (txtVrac.getText().trim().equals("")) {
			poruka += "- Unesite datum vracanja\n";
			ok = false;		
			}
	
		LocalDate datumIznajmljivanja = LocalDate.parse(txtIznaj.getText().trim());
		LocalDate datumVracanja = LocalDate.parse(txtVrac.getText().trim());
		
		if(datumIznajmljivanja.isAfter(datumVracanja)) {
			poruka += "- Datumi se ne poklapaju\n";
			ok = false;
			
			
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
}

