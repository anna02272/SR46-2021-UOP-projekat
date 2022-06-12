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
import biblioteka.ZanrKnjige;
import biblioteka.Biblioteka;
import biblioteka.Knjiga;
import biblioteka.ZanrKnjige;
import enumeracije.EnumJezik;

public class KnjigaForma extends JFrame{
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	
	private JLabel lblNaslov = new JLabel("Naslov knjige");
	private JTextField txtNaslov = new JTextField(20);
	
	private JLabel lblOriginalniNaslov = new JLabel("Originalni naslov knjige");
	private JTextField txtOriginalniNaslov = new JTextField(20);
	
	private JLabel lblPisac = new JLabel("Pisac");
	private JTextField txtPisac= new JTextField(20);
	
	private JLabel lblGodinaObj = new JLabel("Godina objavljivanja");
	private JTextField txtGodinaObj = new JTextField(20);
	
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	
	private JLabel lblEnumJezik = new JLabel("Jezik");
	private JComboBox<EnumJezik> Jezik = new JComboBox<EnumJezik>(EnumJezik.values());
	
	private JLabel lblZanr = new JLabel("Zanr");
	private JComboBox cbZanr = new JComboBox();
	
	private JLabel lblObrisan = new JLabel("Obrisan");
	private JCheckBox txtObrisan = new JCheckBox("Obrisan");
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private Knjiga knjiga;
	
	public KnjigaForma(Biblioteka biblioteka, Knjiga knjiga) {
		this.biblioteka = biblioteka;
		this.knjiga = knjiga;
		if(knjiga == null) {
			setTitle("Dodavanje knjige");
		}else {
			setTitle("Izmena podataka - " + knjiga.getId());
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
		ArrayList<ZanrKnjige> zanrovi = biblioteka.sviNeobrisaniZanr();
		for (ZanrKnjige zanrKnjige: zanrovi) {
			cbZanr.addItem(zanrKnjige.getId());
		}
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(knjiga != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		add(lblId);
		add(txtId);
		
		add(lblNaslov);
		add(txtNaslov);
		
		add(lblOriginalniNaslov);
		add(txtOriginalniNaslov);
		
		add(lblPisac);
		add(txtPisac);
		
		add(lblGodinaObj);
		add(txtGodinaObj);
		
		add(lblOpis);
		add(txtOpis);
		
		add(lblEnumJezik);
		add(Jezik);
		
		add(lblZanr);
		add(cbZanr);
		
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
					int zanrId = cbZanr.getSelectedIndex();
					String id = txtId.getText().trim();
					String naslovKnjige = txtNaslov.getText().trim();
					String originalniNaslovKnjige = txtOriginalniNaslov.getText().trim();
					String pisac = txtPisac.getText().trim();
					Integer godinaObjavljivanja = Integer.parseInt(txtGodinaObj.getText().trim());
					String opis = txtOpis.getText().trim();
					EnumJezik jezik = (EnumJezik)Jezik.getSelectedItem();
					Boolean obrisan = txtObrisan.isSelected();
					ZanrKnjige zanrKnjige  = biblioteka.sviNeobrisaniZanr().get(zanrId);					
					
					if(knjiga == null) { // DODAVANJE:
						//String id= Integer.toString(biblioteka.getKnjige().size());	
						Knjiga novi = new Knjiga(id, naslovKnjige, originalniNaslovKnjige, pisac,godinaObjavljivanja, opis, jezik, false, zanrKnjige);
						biblioteka.dodajKnjigu(novi); 
					}else { // IZMENA:
						knjiga.setId(id);
						knjiga.setNaslovKnjige(naslovKnjige);
						knjiga.setOriginalniNaslovKnjige(originalniNaslovKnjige);
						knjiga.setPisac(pisac);
						knjiga.setGodinaObjavljivanja(godinaObjavljivanja);
						knjiga.setOpis(opis);
						knjiga.setJezik(jezik);
						knjiga.setObrisan(obrisan);
						knjiga.setZanr(zanrKnjige);
					}
					biblioteka.upisiKnjige("fajlovi/knjige.txt");
					KnjigaForma.this.dispose();
					KnjigaForma.this.setVisible(false);
					
					
				}
			}
		});
	}
	
	private void popuniPolja() {
		txtId.setText(knjiga.getId());
		txtNaslov.setText(knjiga.getNaslovKnjige());
		txtOriginalniNaslov.setText(knjiga.getOriginalniNaslovKnjige());
		txtPisac.setText(knjiga.getPisac());
		txtGodinaObj.setText(String.valueOf(knjiga.getGodinaObjavljivanja()));
		txtOpis.setText(knjiga.getOpis());
		Jezik.setSelectedItem(knjiga.getJezik());
		txtObrisan.setSelected(knjiga.isObrisan());
		cbZanr.setSelectedItem(knjiga.getZanr().getId());	
	}
	
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite id\n";
			ok = false;
		}else if(knjiga == null){
			String Id = txtId.getText().trim();
			Knjiga pronadjeni = biblioteka.nadjiKnjigu(Id);
			if(pronadjeni != null) {
				poruka += "- Knjiga sa tim id-om vec postoji\n";
				ok = false;
			}
		}
			
		try {
			Integer.parseInt(txtGodinaObj.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Godina objavljivanja mora biti broj\n";
			ok = false;
		}
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite id\n";
			ok = false;
		}
			
		if(txtNaslov.getText().trim().equals("")) {
			poruka += "- Unesite naslov\n";
			ok = false;
		}
		if(txtOriginalniNaslov.getText().trim().equals("")) {
			poruka += "- Unesite originalni naslov\n";
			ok = false;
		} 
		if(txtPisac.getText().trim().equals("")) {
			poruka += "- Unesite pisca\n";
			ok = false;
		}
		if(txtOpis.getText().trim().equals("")) {
			poruka += "- Unesite opis\n";
			ok = false;
		
		}
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
	
		
	
		return ok;
	}
}

