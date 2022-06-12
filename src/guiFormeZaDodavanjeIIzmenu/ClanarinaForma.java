package guiFormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import biblioteka.Biblioteka;
import biblioteka.TipClanarine;

public class ClanarinaForma extends JFrame{
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	
	private JLabel lblNaziv = new JLabel("Naziv");
	private JTextField txtNaziv = new JTextField(20);
	
	private JLabel lblCena = new JLabel("Cena");
	private JTextField txtCena = new JTextField(20);
	
	private JLabel lblObrisan = new JLabel("Obrisan");
	private JCheckBox txtObrisan = new JCheckBox("Obrisan");
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private TipClanarine tipClanarine;
	
	public ClanarinaForma(Biblioteka biblioteka, TipClanarine tipClanarine) {
		this.biblioteka = biblioteka;
		this.tipClanarine = tipClanarine;
		if(tipClanarine == null) {
			setTitle("Dodavanje tipa clanarine");
		}else {
			setTitle("Izmena podataka - " + tipClanarine.getId());
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
		
		if(tipClanarine != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		
		add(lblNaziv);
		add(txtNaziv);
		
		add(lblCena);
		add(txtCena);
		
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
					String id = txtId.getText().trim();
					String naziv = txtNaziv.getText().trim();
					Double cena = Double.parseDouble(txtCena.getText().trim());
					Boolean obrisan = txtObrisan.isSelected();
					
					if(tipClanarine == null) { // DODAVANJE:
						TipClanarine novi = new TipClanarine(id, naziv, cena,  false);
						biblioteka.dodajClanarinu(novi); 
					}else { // IZMENA:
						tipClanarine.setId(id);
						tipClanarine.setNaziv(naziv);
						tipClanarine.setCena(cena);
						tipClanarine.setObrisan(obrisan);
					}
					
					biblioteka.upisiTipClanarine("fajlovi/tipClanarine.txt");
					ClanarinaForma.this.dispose();
					ClanarinaForma.this.setVisible(false);
					
					
				}
			}
		});
	}
	
	private void popuniPolja() {
		txtId.setText(tipClanarine.getId());
		txtNaziv.setText(tipClanarine.getNaziv());
		txtCena.setText(String.valueOf(tipClanarine.getCena()));
		txtObrisan.setSelected(tipClanarine.isObrisan());
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
			
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite Id\n";
			ok = false;
		}else if(tipClanarine == null){
			String Id = txtId.getText().trim();
			TipClanarine pronadjeni = biblioteka.nadjiClanarinu(Id);
			if(pronadjeni != null) {
				poruka += "- Clanarina sa tim id vec postoji\n";
				ok = false;
			}
		}
			
		try {
			Double.parseDouble(txtCena.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Cena mora biti broj\n";
			ok = false;
		}
		
		if(txtNaziv.getText().trim().equals("")) {
			poruka += "- Unesite naziv\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
}

