package guiFormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import biblioteka.Bibliotekar;
import guiFormeZaDodavanjeIIzmenu.BibliotekariForma;
import biblioteka.Biblioteka;

	public class BibliotekariProzor extends JFrame{

		String putanjaAdd, putanjaDelete, putanjaRead, putanjaUpdate;
		ImageIcon slAdd, slDelete, slRead, slUpdate;
		
		private JToolBar mainToolbar = new JToolBar();
		private JButton btnAdd = new JButton();
		private JButton btnEdit = new JButton();
		private JButton btnDelete = new JButton();
//		private JButton btnRead = new JButton();
		
		private DefaultTableModel tableModel;
		private JTable bibliotekariTabela;
		
		private Biblioteka biblioteka;
		
		public BibliotekariProzor(Biblioteka biblioteka) {
			this.biblioteka = biblioteka;
			setTitle("Bibliotekari");
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
			
//			putanjaRead = "slike/read.png";
//			slRead = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaRead).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
//			btnRead.setIcon(slRead);
			
			putanjaUpdate = "slike/update.png";
			slUpdate = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaUpdate).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
			btnEdit.setIcon(slUpdate);
			
			putanjaDelete = "slike/delete.png";
			slDelete = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaDelete).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
			btnDelete.setIcon(slDelete);
			
			
			mainToolbar.add(btnAdd);
//			mainToolbar.add(btnRead);
			mainToolbar.add(btnEdit);
			mainToolbar.add(btnDelete);
			add(mainToolbar, BorderLayout.NORTH);
			
			String[] zaglavlja = new String[] {"Korisnicko Ime", "Korisnicka Lozinka", "Plata", "Id", "Ime i Prezime","JMBG", "Adresa", "Pol"};
			Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniBibliotekari().size()][zaglavlja.length];
			
			for(int i=0; i<biblioteka.sviNeobrisaniBibliotekari().size(); i++) {
				Bibliotekar bibliotekar = biblioteka.sviNeobrisaniBibliotekari().get(i);
				sadrzaj[i][0] = bibliotekar.getKorisnickoIme();
				sadrzaj[i][1] = bibliotekar.getKorisnickaLozinka();
				sadrzaj[i][2] = bibliotekar.getPlata();
				sadrzaj[i][3] = bibliotekar.getId();
				sadrzaj[i][4] = bibliotekar.getImeIPrezime();
				sadrzaj[i][5] = bibliotekar.getJMBG();
				sadrzaj[i][6] = bibliotekar.getAdresa();
				sadrzaj[i][7] = bibliotekar.getPol();
			}
			
			tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
			bibliotekariTabela = new JTable(tableModel);
			
			bibliotekariTabela.setRowSelectionAllowed(true);
			bibliotekariTabela.setColumnSelectionAllowed(false);
			bibliotekariTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			bibliotekariTabela.setDefaultEditor(Object.class, null);
			bibliotekariTabela.getTableHeader().setReorderingAllowed(false);
			
			JScrollPane scrollPane = new JScrollPane(bibliotekariTabela);
			add(scrollPane, BorderLayout.CENTER);
		}
		
		private void initActions() {
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = bibliotekariTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String id = tableModel.getValueAt(red, 3).toString();
						Bibliotekar bibliotekar = biblioteka.nadjiBibliotekara(id);
						
						int izbor = JOptionPane.showConfirmDialog(null, 
								"Da li ste sigurni da zelite da obrisete bibliotekara?", 
								id + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							bibliotekar.setObrisan(true);
							tableModel.removeRow(red);
							
							biblioteka.upisiBibliotekara("fajlovi/bibliotekari.txt");
						}
					}
				}
			});
			
			btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					BibliotekariForma pf = new BibliotekariForma(biblioteka, null);
					pf.setVisible(true);
				}
			});
			
			btnEdit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = bibliotekariTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String Id = tableModel.getValueAt(red, 3).toString();
						Bibliotekar bibliotekar = biblioteka.nadjiBibliotekara(Id);
						if(bibliotekar == null) {
							JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja bibliotekara sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
						}else {
							BibliotekariForma pf = new BibliotekariForma(biblioteka, bibliotekar);
							pf.setVisible(true);
						}
					}
			}
			});
		}
	}


