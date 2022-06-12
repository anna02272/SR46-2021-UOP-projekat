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
import main.BibliotekaMain;
import biblioteka.Administrator;
import biblioteka.Biblioteka;
import enumeracije.EnumPol;
public class AdministratoriProzor extends JFrame{

	String putanjaAdd, putanjaDelete, putanjaRead, putanjaUpdate;
	ImageIcon slAdd, slDelete, slRead, slUpdate;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
//	private JButton btnRead = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable administratoriTabela;
	
	private Biblioteka biblioteka;
	
	public AdministratoriProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Administratori");
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
		
		String[] zaglavlja = new String[] {"Korisnicko Ime", "Korisnicka Lozinka", "Plata", "Id", "Ime i Prezime","JMBG", "Adresa", "Pol"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniAdministratori().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniAdministratori().size(); i++) {
			Administrator administrator = biblioteka.sviNeobrisaniAdministratori().get(i);
			sadrzaj[i][0] = administrator.getKorisnickoIme();
			sadrzaj[i][1] = administrator.getKorisnickaLozinka();
			sadrzaj[i][2] = administrator.getPlata();
			sadrzaj[i][3] = administrator.getId();
			sadrzaj[i][4] = administrator.getImeIPrezime();
			sadrzaj[i][5] = administrator.getJMBG();
			sadrzaj[i][6] = administrator.getAdresa();
			sadrzaj[i][7] = administrator.getPol();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		administratoriTabela = new JTable(tableModel);
		
		administratoriTabela.setRowSelectionAllowed(true);
		administratoriTabela.setColumnSelectionAllowed(false);
		administratoriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		administratoriTabela.setDefaultEditor(Object.class, null);
		administratoriTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(administratoriTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = administratoriTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 3).toString();
					Administrator administrator = biblioteka.nadjiAdministratora(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete administratora?", 
							id + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						administrator.setObrisan(true);
						tableModel.removeRow(red);
						
						
						biblioteka.upisiAdministratora("fajlovi/administratori.txt");
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratoriForma pf = new AdministratoriForma(biblioteka, null);
				pf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = administratoriTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 3).toString();
					Administrator administrator = biblioteka.nadjiAdministratora(id);
					if(administrator == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja administratora sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						AdministratoriForma pf = new AdministratoriForma(biblioteka, administrator);
						pf.setVisible(true);
					}
				}
			}
		});
	}
}

