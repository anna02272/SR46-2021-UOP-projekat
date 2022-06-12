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

public class BibliotekaForma extends JFrame{
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	
	private JLabel lblNaziv = new JLabel("Naziv");
	private JTextField txtNaziv = new JTextField(20);
	
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	
	private JLabel lblTelefon = new JLabel("Telefon");
	private JTextField txtTelefon = new JTextField(20);
	
	private JLabel lblRadnoVreme = new JLabel("Radno vreme");
	private JTextField txtRadnoVreme= new JTextField(20);
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private Biblioteka bibliotekaa;
	
	public BibliotekaForma(Biblioteka biblioteka, Biblioteka bibliotekaa) {
		this.biblioteka = biblioteka;
		this.bibliotekaa = bibliotekaa;
		if(biblioteka == null) {
//			setTitle("Dodavanje biblioteke");
//		}else {
			setTitle("Izmena podataka - " + bibliotekaa.getId());
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
		
		if(bibliotekaa != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		
		add(lblNaziv);
		add(txtNaziv);
		
		add(lblAdresa);
		add(txtAdresa);
		
		add(lblTelefon);
		add(txtTelefon);
		
		add(lblRadnoVreme);
		add(txtRadnoVreme);
		
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCanel);
	}
	
	private void initActions() {
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String id = txtId.getText().trim();
					String naziv = txtNaziv.getText().trim();
					String adresa = txtAdresa.getText().trim();
					String telefon = txtTelefon.getText().trim();
					String radnoVreme = txtRadnoVreme.getText().trim();
					
					if(bibliotekaa == null) { // DODAVANJE:
						Biblioteka novi = new Biblioteka(id, naziv,adresa,telefon, radnoVreme);
						biblioteka.dodajBiblioteku(novi); 
					}else { // IZMENA:
						bibliotekaa.setId(id);
						bibliotekaa.setNaziv(naziv);
						bibliotekaa.setAdresa(adresa);
						bibliotekaa.setTelefon(telefon);
						bibliotekaa.setRadnoVreme(radnoVreme);
					}
					biblioteka.upisiBiblioteka(BibliotekaMain.BIBLIOTEKA_FAJL);
					BibliotekaForma.this.dispose();
					BibliotekaForma.this.setVisible(false);
					
					
				}
			}
		});
	}
	
	private void popuniPolja() {
		txtId.setText(bibliotekaa.getId());
		txtNaziv.setText(bibliotekaa.getNaziv());
		txtAdresa.setText(bibliotekaa.getAdresa());
		txtTelefon.setText(bibliotekaa.getTelefon());
		txtRadnoVreme.setText(bibliotekaa.getRadnoVreme());
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite id\n";
			ok = false;
		}else if(bibliotekaa == null){
			String id = txtId.getText().trim();
			Biblioteka pronadjeni = biblioteka.nadjiBiblioteku(id);
			if(pronadjeni != null) {
				poruka += "- Biblioteka sa tim id-om vec postoji\n";
				ok = false;
			}
		}
			
		if(txtNaziv.getText().trim().equals("")) {
			poruka += "- Unesite naziv\n";
			ok = false;
		}
			
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Unesite adresu\n";
			ok = false;
		}
		if(txtTelefon.getText().trim().equals("")) {
			poruka += "- Unesite telefon\n";
			ok = false;
		} 
		if(txtRadnoVreme.getText().trim().equals("")) {
			poruka += "- Unesite radno vreme\n";
			ok = false;
			
		
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
}

