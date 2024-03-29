package guiFormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import biblioteka.Biblioteka;
import biblioteka.ClanBiblioteke;
import biblioteka.TipClanarine;
import enumeracije.EnumPol;

public class ClanForma extends JFrame{
	private JLabel lblBrojClanskeKarte = new JLabel("Broj Clanske Karte");
	private JTextField txtBrojClanskeKarte = new JTextField(20);
	
    private JLabel lblDatumPoslednjeUplate= new JLabel("Datum Poslednje Uplate");
    private JTextField txtDatumPoslednjeUplate = new JTextField(20);	
	
	private JLabel lblBrojMeseciClanarine = new JLabel("Broj Meseci Clanarine");
	private JTextField txtBrojMeseciClanarine = new JTextField(20);

	
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
	
	private JLabel lblTipClanarine= new JLabel("Tip clanarine ");
	private JComboBox cbTip=new JComboBox();
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	
	
	
	private Biblioteka biblioteka;
	private ClanBiblioteke clanBiblioteke;
	
	public ClanForma(Biblioteka biblioteka, ClanBiblioteke clanBiblioteke) {
		this.biblioteka = biblioteka;
		this.clanBiblioteke = clanBiblioteke;
		if(clanBiblioteke == null) {
			setTitle("Dodavanje clana biblioteke");
		}else {
			setTitle("Izmena podataka - " + clanBiblioteke.getId());
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
		ArrayList<TipClanarine> tipoviClanarine = biblioteka.sviNeobrisaniClanarina();
		for (TipClanarine tipClanarine: tipoviClanarine) {
			cbTip.addItem(tipClanarine.getNaziv());
		}
	
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(clanBiblioteke != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		add(lblBrojClanskeKarte);
		add(txtBrojClanskeKarte);
		
		
		add(lblDatumPoslednjeUplate);
		add(txtDatumPoslednjeUplate );
		
		add(lblBrojMeseciClanarine);
		add(txtBrojMeseciClanarine);
	
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
		
		add(lblTipClanarine);
		add(cbTip);
		
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCanel);
	}
	

	
	
	private void initActions() {
		btnCanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanForma.this.dispose();
				ClanForma.this.setVisible(false);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int tipId = cbTip.getSelectedIndex();
					String brojClanskeKarte = txtBrojClanskeKarte.getText().trim();
					LocalDate datumPoslednjeUplate= LocalDate.parse(txtDatumPoslednjeUplate.getText().trim());
					Integer brojMeseciClanarine = Integer.parseInt(txtBrojMeseciClanarine.getText().trim());
					String id = txtId.getText().trim();
					String imeIPrezime = txtImeIPrezime.getText().trim();
					String JMBG = txtJMBG.getText().trim();
					String adresa = txtAdresa.getText().trim();
					EnumPol pol = (EnumPol)Pol.getSelectedItem();
					Boolean obrisan = txtObrisan.isSelected();
					TipClanarine tipClanarine = biblioteka.sviNeobrisaniClanarina().get(tipId);
					
					
					double cena = biblioteka.sviNeobrisaniClanarina().get(tipId).getCena();{
					
					if(Integer.parseInt(txtBrojMeseciClanarine.getText().trim())>=6 && Integer.parseInt(txtBrojMeseciClanarine.getText().trim())<12) {
						cena = (Integer.parseInt(txtBrojMeseciClanarine.getText().trim()) * cena) - (Integer.parseInt(txtBrojMeseciClanarine.getText().trim()) * cena * 0.1);
					}else if (Integer.parseInt(txtBrojMeseciClanarine.getText().trim())>=12) {	
						cena = (Integer.parseInt(txtBrojMeseciClanarine.getText().trim()) * cena) - (Integer.parseInt(txtBrojMeseciClanarine.getText().trim()) * cena * 0.2);
					}else {
						cena = Integer.parseInt(txtBrojMeseciClanarine.getText().trim()) * cena;
					}
					
					if(clanBiblioteke == null) { // DODAVANJE:
						ClanBiblioteke novi = new ClanBiblioteke(brojClanskeKarte, datumPoslednjeUplate, brojMeseciClanarine,true, id, imeIPrezime, JMBG, adresa, pol,false ,tipClanarine);
						biblioteka.dodajClana(novi);
					}else { // IZMENA:
						clanBiblioteke.setBrojClanskeKarte(brojClanskeKarte);
						clanBiblioteke.setDatumPoslednjeUplate(datumPoslednjeUplate);
						clanBiblioteke.setBrojMeseciClanarine(brojMeseciClanarine);
						clanBiblioteke.setId(id);
						clanBiblioteke.setImeIPrezime(imeIPrezime);
						clanBiblioteke.setJMBG(JMBG);
						clanBiblioteke.setAdresa(adresa);
						clanBiblioteke.setPol(pol);
						clanBiblioteke.setObrisan(obrisan);
						clanBiblioteke.setTipclanarine(tipClanarine);
						
						
					}
					
					JOptionPane.showMessageDialog(rootPane, "Cena sa popustom je: " + cena);}
					biblioteka.upisiClanBiblioteke("fajlovi/clanBiblioteke.txt");
					ClanForma.this.dispose();
					ClanForma.this.setVisible(false);
					
					
				}
			}
		});
	}
	
	private void popuniPolja() {
		
		txtBrojClanskeKarte.setText(clanBiblioteke.getBrojClanskeKarte());
		txtDatumPoslednjeUplate.setText(clanBiblioteke.getDatumPoslednjeUplate().toString());
		txtBrojMeseciClanarine.setText(String.valueOf(clanBiblioteke.getBrojMeseciClanarine()));
		txtId.setText(clanBiblioteke.getId());
		txtImeIPrezime.setText(clanBiblioteke.getImeIPrezime());
		txtJMBG.setText(clanBiblioteke.getJMBG());
		txtAdresa.setText(clanBiblioteke.getAdresa());
		Pol.setSelectedItem(clanBiblioteke.getPol());
		txtObrisan.setSelected(clanBiblioteke.isObrisan());
		cbTip.setSelectedItem(clanBiblioteke.getTipClanarine());
	}
	
	
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite Id\n";
			ok = false;
		}else if(clanBiblioteke == null){
			String Id = txtId.getText().trim();
			ClanBiblioteke pronadjeni = biblioteka.nadjiClanove(Id);
			if(pronadjeni != null) {
				poruka += "- Clanovi sa tim id-om vec postoji\n";
				ok = false;
			}
		}
		if(txtBrojClanskeKarte.getText().trim().equals("")) {
			poruka += "- Unesite broj clanske karte\n";
			ok = false;
		}
		if(txtDatumPoslednjeUplate.getText().trim().equals("")) {
			poruka += "- Unesite datum\n";
			ok = false;
		}
		
		try {
			Integer.parseInt(txtBrojMeseciClanarine.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Broj clanarine mora biti broj\n";
			ok = false;
		}
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite id\n";
			ok = false;
		}
			
		if(txtImeIPrezime.getText().trim().equals("")) {
			poruka += "- Unesite ime i prezime\n";
			ok = false;
		}
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Unesite adresu\n";
			ok = false;
			
		
		}
		if(txtJMBG.getText().trim().equals("")) {
			poruka += "- Unesite JMBG\n";
			ok = false;
		}else if(clanBiblioteke == null){
		String JMBG = txtJMBG.getText().trim();
		ClanBiblioteke pronadjeni = biblioteka.nadjiClanove(JMBG);
		if(pronadjeni != null) {
			poruka += "- JMBG mora biti jedinstven\n";
			ok = false;
		}
		}
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
			
		}
		
		return ok;
	}

	
	
}

