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
import biblioteka.ZanrKnjige;
import biblioteka.Biblioteka;
import biblioteka.ZanrKnjige;

public class ZanrForma extends JFrame{
	
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	
	private JLabel lblOznaka= new JLabel("Oznaka");
	private JTextField txtOznaka = new JTextField(20);
	
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	
	private JLabel lblObrisan = new JLabel("Obrisan");
	private JCheckBox txtObrisan = new JCheckBox("Obrisan");
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCanel = new JButton("Cancel");
	
	private Biblioteka biblioteka;
	private ZanrKnjige zanrKnjige;
	
	public ZanrForma(Biblioteka biblioteka, ZanrKnjige zanrKnjige) {
		this.biblioteka = biblioteka;
		this.zanrKnjige = zanrKnjige;
		if(zanrKnjige == null) {
			setTitle("Dodavanje zanra");
		}else {
			setTitle("Izmena podataka - " + zanrKnjige.getId());
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
		
		if(zanrKnjige != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		
		add(lblOznaka);
		add(txtOznaka);
		
		add(lblOpis);
		add(txtOpis);
		
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
					String oznaka = txtOznaka.getText().trim();
					String opis = txtOpis.getText().trim();
					Boolean obrisan = txtObrisan.isSelected();
					
					if(zanrKnjige == null) { // DODAVANJE:
						ZanrKnjige novi = new ZanrKnjige(id,oznaka, opis, false);
						biblioteka.dodajZanr(novi); 
					}else { // IZMENA:
						zanrKnjige.setId(id);
						zanrKnjige.setOznaka(oznaka);
						zanrKnjige.setOpis(opis);
						zanrKnjige.setObrisan(obrisan);
					}
					
					biblioteka.upisiZanrKnjige("fajlovi/zanr.txt");
					ZanrForma.this.dispose();
					ZanrForma.this.setVisible(false);
					
					
				}
			}
		});
	}
	
	private void popuniPolja() {
		txtId.setText(zanrKnjige.getId());
		txtOznaka.setText(zanrKnjige.getOznaka());
		txtOpis.setText(zanrKnjige.getOpis());
		txtObrisan.setSelected(zanrKnjige.isObrisan());
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite Id\n";
			ok = false;
		}else if(zanrKnjige == null){
			String Id = txtId.getText().trim();
			ZanrKnjige pronadjeni = biblioteka.nadjiZanr(Id);
			if(pronadjeni != null) {
				poruka += "- Zanr sa tim id-om vec postoji\n";
				ok = false;
			}
		}
			
		if(txtOznaka.getText().trim().equals("")) {
			poruka += "- Unesite oznaku\n";
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

