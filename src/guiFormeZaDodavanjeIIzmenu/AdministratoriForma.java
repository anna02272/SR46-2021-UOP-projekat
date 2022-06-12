package guiFormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import biblioteka.Administrator;
import biblioteka.Biblioteka;
import enumeracije.EnumPol;

public class AdministratoriForma extends JFrame{
	
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko Ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	
	private JLabel lblKorisnickaLozinka= new JLabel("Korisnicka Lozinka");
	private JPasswordField txtKorisnickaLozinka = new JPasswordField(20);
	
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	
	private JLabel lblImeIPrezime = new JLabel("Ime i prezime");
	private JTextField txtImeIPrezime= new JTextField(20);
	
	private JLabel lblJMBG = new JLabel("JMBG");
	private JTextField txtJMBG = new JTextField(20);
	
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	
	private JLabel lblEnumPol = new JLabel("Pol");
	private JComboBox<EnumPol> Pol = new JComboBox<EnumPol>(EnumPol.values());
	
	private JLabel lblObrisan = new JLabel("Obrisan");
	private JCheckBox txtObrisan = new JCheckBox("Obrisan");
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private Administrator administrator;
	
	public AdministratoriForma(Biblioteka biblioteka, Administrator administrator) {
		this.biblioteka = biblioteka;
		this.administrator = administrator;
		if(administrator == null) {
			setTitle("Dodavanje administratora");
		}else {
			setTitle("Izmena podataka - " + administrator.getId());
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
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(administrator != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		
		add(lblKorisnickaLozinka);
		add(txtKorisnickaLozinka);
		
		add(lblPlata);
		add(txtPlata);
		
		add(lblId);
		add(txtId);
		
		add(lblImeIPrezime);
		add(txtImeIPrezime);
		
		add(lblJMBG);
		add(txtJMBG);
		
		add(lblAdresa);
		add(txtAdresa);
		
		add(lblEnumPol);
		add(Pol);
		
		add(lblObrisan);
		add(txtObrisan);
		
		
		
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCanel);
	}
	
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String korisnickoIme = txtKorisnickoIme.getText().trim();
					String KorisnickaLozinka= new String(txtKorisnickaLozinka.getPassword()).trim();
					Double plata = Double.parseDouble(txtPlata.getText().trim());
					String id = txtId.getText().trim();
					String imeIPrezime = txtImeIPrezime.getText().trim();
					String JMBG = txtJMBG.getText().trim();
					String adresa = txtAdresa.getText().trim();
					EnumPol pol = (EnumPol)Pol.getSelectedItem();
					Boolean obrisan = txtObrisan.isSelected();
					
					if(administrator == null) { // DODAVANJE:
						Administrator novi = new Administrator(korisnickoIme, KorisnickaLozinka, plata, id, imeIPrezime, JMBG, adresa, pol , false);
						biblioteka.dodajAdministratora(novi); 
					}else { // IZMENA:
						administrator.setKorisnickoIme(korisnickoIme);
						administrator.setKorisnickaLozinka(KorisnickaLozinka);
						administrator.setPlata(plata);
						administrator.setId(id);
						administrator.setImeIPrezime(imeIPrezime);
						administrator.setJMBG(JMBG);
						administrator.setAdresa(adresa);
						administrator.setPol(pol);
						administrator.setObrisan(obrisan);
					}
//					
					biblioteka.upisiAdministratora(BibliotekaMain.ADMINISTRATOR_FAJL);
					AdministratoriForma.this.dispose();
					AdministratoriForma.this.setVisible(false);
					
					
				}
			}
		});
	}
	
	private void popuniPolja() {
		txtKorisnickoIme.setText(administrator.getKorisnickoIme());
		txtKorisnickaLozinka.setText(administrator.getKorisnickaLozinka());
		txtPlata.setText(String.valueOf(administrator.getPlata()));
		txtId.setText(administrator.getId());
		txtImeIPrezime.setText(administrator.getImeIPrezime());
		txtJMBG.setText(administrator.getJMBG());
		txtAdresa.setText(administrator.getAdresa());
		Pol.setSelectedItem(administrator.getPol());
		txtObrisan.setSelected(administrator.isObrisan());
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		//String korisnickoIme, String korisnickaLozinka, double plata, String id, String imeIPrezime,
		//String JMBG, String adresa, EnumPol pol, boolean obrisa
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite id\n";
			ok = false;
		}else if(administrator == null){
			String id = txtId.getText().trim();
			Administrator pronadjeni = biblioteka.nadjiAdministratora(id);
			if(pronadjeni != null) {
				poruka += "- Administrator sa tim id-om vec postoji\n";
				ok = false;
			}
		}
			
		try {
			Double.parseDouble(txtPlata.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Plata mora biti broj\n";
			ok = false;
		}
		if(txtKorisnickoIme.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime\n";
			ok = false;
		}
			
		if(txtImeIPrezime.getText().trim().equals("")) {
			poruka += "- Unesite ime i prezime\n";
			ok = false;
		}
		if(txtJMBG.getText().trim().equals("")) {
			poruka += "- Unesite JMBG\n";
			ok = false;
		} 
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Unesite adresu\n";
			ok = false;
			
		
		}
		
		String sifra = new String(txtKorisnickaLozinka.getPassword()).trim();
		if(sifra.equals("")) {
			poruka += "- Unesite sifru\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
}

