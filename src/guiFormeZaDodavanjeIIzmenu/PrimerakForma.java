package guiFormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
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
import biblioteka.Knjiga;
import biblioteka.PrimerakKnjige;
import enumeracije.EnumTipPoveza;
import enumeracije.EnumJezik;

public class PrimerakForma extends JFrame{
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	
	private JLabel lblKnjiga = new JLabel("Knjiga");
	private JComboBox cbKnjiga = new JComboBox();
	
	private JLabel lblBrojStrana = new JLabel("Broj strana");
	private JTextField txtBrojStrana= new JTextField(20);
	
	private JLabel lblEnumTipPoveza = new JLabel("Tip poveza");
	private JComboBox<EnumTipPoveza> Tip = new JComboBox<EnumTipPoveza>(EnumTipPoveza.values());
	
	private JLabel lblEnumJezik = new JLabel("Jezik");
	private JComboBox<EnumJezik> Jezik = new JComboBox<EnumJezik>(EnumJezik.values());
	
	private JLabel lblGodinaStampanja= new JLabel("Godina Stampanja");
	private JTextField txtGodinaStampanja = new JTextField(20);
	
	private JLabel lblIznajmljena = new JLabel("Iznajmljena");
	private JCheckBox txtIznajmljena = new JCheckBox("Iznajmljena");
	
	private JLabel lblObrisan = new JLabel("Obrisan");
	private JCheckBox txtObrisan = new JCheckBox("Obrisan");
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private PrimerakKnjige primerakKnjige;
	
	public PrimerakForma(Biblioteka biblioteka, PrimerakKnjige primerakKnjige) {
		this.biblioteka = biblioteka;
		this.primerakKnjige = primerakKnjige;
		if(primerakKnjige == null) {
			setTitle("Dodavanje primerka knjige");
		}else {
			setTitle("Izmena podataka - " + primerakKnjige.getId());
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
		ArrayList<Knjiga> knjige = biblioteka.sviNeobrisaniKnjiga();
		for (Knjiga knjiga: knjige) {
			cbKnjiga.addItem(knjiga.getNaslovKnjige());
		}

		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(primerakKnjige != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		
		add(lblKnjiga);
		add(cbKnjiga);
		
		add(lblBrojStrana);
		add(txtBrojStrana);
		
		add(lblEnumTipPoveza);
		add(Tip);
		
		add(lblEnumJezik);
		add(Jezik);
		
		add(lblGodinaStampanja);
		add(txtGodinaStampanja);
		
		add(lblIznajmljena);
		add(txtIznajmljena);
		
		add(lblObrisan);
		add(txtObrisan);
		
		
		
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCanel);
	}
	
	private void initActions() {
		btnCanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerakForma.this.dispose();
				PrimerakForma.this.setVisible(false);
			}
		});
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int knjigaId = cbKnjiga.getSelectedIndex();
					String id = txtId.getText().trim();
					Knjiga knjiga = biblioteka.sviNeobrisaniKnjiga().get(knjigaId);
					int brojStrana = Integer.parseInt(txtBrojStrana.getText().trim());
					EnumTipPoveza tipPoveza = (EnumTipPoveza)Tip.getSelectedItem();
					EnumJezik jezik = (EnumJezik)Jezik.getSelectedItem();
					Integer godinaStampanja= Integer.parseInt(txtGodinaStampanja.getText().trim());
					Boolean iznajmljena = txtIznajmljena.isSelected();
					Boolean obrisan = txtObrisan.isSelected();
					
					if(primerakKnjige == null) { // DODAVANJE:
//						String id1 = Integer.toString(biblioteka.getPrimerakKnjiga().size());
						PrimerakKnjige novi = new PrimerakKnjige(id, knjiga, brojStrana, tipPoveza, jezik, godinaStampanja, true  , false);
						biblioteka.dodajPrimerak(novi);
					}else { // IZMENA:
						primerakKnjige.setId(id);
						primerakKnjige.setKnjiga(knjiga);
						primerakKnjige.setBrojStrana(brojStrana);
						primerakKnjige.setTipPoveza(tipPoveza);
						primerakKnjige.setJezik(jezik);
						primerakKnjige.setGodinaStampanja(godinaStampanja);
						primerakKnjige.setIznajmljena(iznajmljena);
						primerakKnjige.setObrisan(obrisan);
					}
					
					biblioteka.upisiPrimerakKnjige("fajlovi/primerakKnjige.txt");
					PrimerakForma.this.dispose();
					PrimerakForma.this.setVisible(false);
					
					
				}
			}
		});
	}
	
	private void popuniPolja() {
		txtId.setText(primerakKnjige.getId());
		cbKnjiga.setSelectedItem(primerakKnjige.getKnjiga());
		txtBrojStrana.setText(String.valueOf(primerakKnjige.getBrojStrana()));
		Tip.setSelectedItem(primerakKnjige.getTipPoveza());
		Jezik.setSelectedItem(primerakKnjige.getJezik());
		txtGodinaStampanja.setText(String.valueOf(primerakKnjige.getGodinaStampanja()));
		txtIznajmljena.setSelected(primerakKnjige.isIznajmljena());
		txtObrisan.setSelected(primerakKnjige.isObrisan());
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
				
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite ID\n";
			ok = false;
		}else if(primerakKnjige == null){
			String Id = txtId.getText().trim();
			PrimerakKnjige pronadjeni = biblioteka.nadjiPrimerak(Id);
			if(pronadjeni != null) {
				poruka += "- Primerak knjiige sa tim id-om\n";
				ok = false;
			}
		}
			
		try {
			Integer.parseInt(txtBrojStrana.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Broj strana mora biti broj\n";
			ok = false;
		}
		if(txtGodinaStampanja.getText().trim().equals("")) {
			poruka += "- Unesite datum\n";
			ok = false;		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
		
	   }

