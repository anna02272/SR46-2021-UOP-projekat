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

import guiFormeZaDodavanjeIIzmenu.AdministratoriForma;
import guiFormeZaDodavanjeIIzmenu.BibliotekaForma;
import main.BibliotekaMain;
import biblioteka.Biblioteka;
import enumeracije.EnumPol;
public class BibliotekaProzor extends JFrame{

	String putanjaAdd, putanjaDelete, putanjaRead, putanjaUpdate;
	ImageIcon slAdd, slDelete, slRead, slUpdate;
	
	private JToolBar mainToolbar = new JToolBar();
//	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
//	private JButton btnDelete = new JButton();
//	private JButton btnRead = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable bibliotekaTabela;
	
	private Biblioteka biblioteka;
	
	public BibliotekaProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Biblioteka");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	private void initGUI() {
//		putanjaAdd = "slike/add.png";
//		slAdd = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaAdd).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
//		btnAdd.setIcon(slAdd);
		
//		putanjaRead = "slike/read.png";
//		slRead = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaRead).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
//		btnRead.setIcon(slRead);
		
		putanjaUpdate = "slike/update.png";
		slUpdate = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaUpdate).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		btnEdit.setIcon(slUpdate);
		
//		putanjaDelete = "slike/delete.png";
//		slDelete = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaDelete).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
//		btnDelete.setIcon(slDelete);
		
		
//		mainToolbar.add(btnAdd);
//		mainToolbar.add(btnRead);
		mainToolbar.add(btnEdit);
//		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"Id", "Naziv","Adresa", "Telefon", "Radno vreme"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniBiblioteka().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniBiblioteka().size(); i++) {
			Biblioteka bibliotekaa = biblioteka.sviNeobrisaniBiblioteka().get(i);
			sadrzaj[i][0] = bibliotekaa.getId();
			sadrzaj[i][1] = bibliotekaa.getNaziv();
			sadrzaj[i][2] = bibliotekaa.getAdresa();
			sadrzaj[i][3] = bibliotekaa.getTelefon();
			sadrzaj[i][4] = bibliotekaa.getRadnoVreme();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		bibliotekaTabela = new JTable(tableModel);
		
		bibliotekaTabela.setRowSelectionAllowed(true);
		bibliotekaTabela.setColumnSelectionAllowed(false);
		bibliotekaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bibliotekaTabela.setDefaultEditor(Object.class, null);
		bibliotekaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(bibliotekaTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
//		btnAdd.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				BibliotekaForma pf = new BibliotekaForma(biblioteka);
//				pf.setVisible(true);
//			}
//		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = bibliotekaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					Biblioteka bibliotekaa = biblioteka.nadjiBiblioteku(id);
					if(bibliotekaa == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja biblioteke sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						BibliotekaForma pf = new BibliotekaForma(biblioteka, bibliotekaa);
						pf.setVisible(true);
					}
				}
			}
		});
	}
}

