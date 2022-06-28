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
import biblioteka.PrimerakKnjige;
import guiFormeZaDodavanjeIIzmenu.PrimerakForma;
public class PrimerakProzor extends JFrame{

	String putanjaAdd, putanjaDelete, putanjaRead, putanjaUpdate;
	ImageIcon slAdd, slDelete, slRead, slUpdate;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
//	private JButton btnRead = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable primerakTabela;
	
	private Biblioteka biblioteka;
	
	public PrimerakProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Primerak knjige");
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
		
//		putanjaRead = "slike/read.png";
//		slRead = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaRead).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
//		btnRead.setIcon(slRead);
		
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
		
		String[] zaglavlja = new String[] {"Id", "Naziv knjige", "Broj strana", "Tip poveza", "Jezik","Godina stampanja"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniPrimerak().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniPrimerak().size(); i++) {
			PrimerakKnjige primerakKnjige = biblioteka.sviNeobrisaniPrimerak().get(i);
			sadrzaj[i][0] = primerakKnjige.getId();
			sadrzaj[i][1] = primerakKnjige.getKnjiga().getNaslovKnjige();
			sadrzaj[i][2] = primerakKnjige.getBrojStrana();
			sadrzaj[i][3] = primerakKnjige.getTipPoveza();
			sadrzaj[i][4] = primerakKnjige.getJezik();
			sadrzaj[i][5] = primerakKnjige.getGodinaStampanja();
		
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		primerakTabela = new JTable(tableModel);
		
		primerakTabela.setRowSelectionAllowed(true);
		primerakTabela.setColumnSelectionAllowed(false);
		primerakTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerakTabela.setDefaultEditor(Object.class, null);
		primerakTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerakTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primerakTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String Id = tableModel.getValueAt(red, 0).toString();
					PrimerakKnjige primerakKnjige = biblioteka.nadjiPrimerak(Id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete primerak?", 
							Id + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						primerakKnjige.setObrisan(true);
						tableModel.removeRow(red);
						
						biblioteka.upisiPrimerakKnjige("fajlovi/primerakKnjige.txt");
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerakForma pf = new PrimerakForma(biblioteka, null);
				pf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primerakTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String Id = tableModel.getValueAt(red, 0).toString();
					PrimerakKnjige primerakKnjige = biblioteka.nadjiPrimerak(Id);
//					
						PrimerakForma pf = new PrimerakForma(biblioteka, primerakKnjige);
						pf.setVisible(true);
					}
				}
//			}
		});
	}
}

