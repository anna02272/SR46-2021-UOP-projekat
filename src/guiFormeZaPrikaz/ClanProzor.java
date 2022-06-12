package guiFormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import main.BibliotekaMain;
import biblioteka.Biblioteka;
import biblioteka.ClanBiblioteke;
import enumeracije.EnumPol;
import guiFormeZaDodavanjeIIzmenu.ClanForma;
public class ClanProzor extends JFrame{

	String putanjaAdd, putanjaDelete, putanjaRead, putanjaUpdate;
	ImageIcon slAdd, slDelete, slRead, slUpdate;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
//	private JButton btnRead = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable clanTabela;
	
	private Biblioteka biblioteka;
	
	public ClanProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Clan Biblioteke");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		putanjaAdd = "slike/add.png";
		slAdd = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaAdd).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		btnAdd.setIcon(slAdd);
//		
//		putanjaRead = "slike/read.png";
//		slRead = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaRead).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
//		btnRead.setIcon(slRead);
//		
		putanjaUpdate = "slike/update.png";
		slUpdate = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaUpdate).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		btnEdit.setIcon(slUpdate);
		
		putanjaDelete = "slike/delete.png";
		slDelete = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaDelete).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		btnDelete.setIcon(slDelete);
		
		
		mainToolbar.add(btnAdd);
//		mainToolbar.add(btnRead);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"Broj Clanske Karte", "Datum Poslednje Uplate", "Broj Meseci Clanarine", "Id", "Ime i Prezime", "JMBG", "Adresa", "Pol" ,"Tip Clanarine"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniClanovi().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniClanovi().size(); i++) {
			ClanBiblioteke clanBiblioteke = biblioteka.sviNeobrisaniClanovi().get(i);
			sadrzaj[i][0] = clanBiblioteke.getBrojClanskeKarte();
			sadrzaj[i][1] = clanBiblioteke.getDatumPoslednjeUplate();
			sadrzaj[i][2] = clanBiblioteke.getBrojMeseciClanarine();
			sadrzaj[i][3] = clanBiblioteke.getId();
			sadrzaj[i][4] = clanBiblioteke.getImeIPrezime();
			sadrzaj[i][5] = clanBiblioteke.getJMBG();
			sadrzaj[i][6] = clanBiblioteke.getAdresa();
			sadrzaj[i][7] = clanBiblioteke.getPol();
			sadrzaj[i][8] = clanBiblioteke.getTipclanarine();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanTabela = new JTable(tableModel);
		
		clanTabela.setRowSelectionAllowed(true);
		clanTabela.setColumnSelectionAllowed(false);
		clanTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanTabela.setDefaultEditor(Object.class, null);
		clanTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(clanTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String Id = tableModel.getValueAt(red, 3).toString();
					ClanBiblioteke clanBiblioteke = biblioteka.nadjiClanove(Id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete clana?", 
							Id + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						clanBiblioteke.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.upisiClanBiblioteke("fajlovi/clanBiblioteke.txt");
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanForma pf = new ClanForma(biblioteka, null);
				pf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String Id = tableModel.getValueAt(red, 3).toString();
					ClanBiblioteke clanBiblioteke = biblioteka.nadjiClanove(Id);
					if(clanBiblioteke == null) {
					JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja clana sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
						ClanForma pf = new ClanForma(biblioteka, clanBiblioteke);
						pf.setVisible(true);
					}
				}
			}
		});
	}
}

