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
import biblioteka.Knjiga;
import biblioteka.ZanrKnjige;
import enumeracije.EnumJezik;
import enumeracije.EnumPol;
import guiFormeZaDodavanjeIIzmenu.KnjigaForma;
public class KnjigaProzor extends JFrame{

	String putanjaAdd, putanjaDelete, putanjaRead, putanjaUpdate;
	ImageIcon slAdd, slDelete, slRead, slUpdate;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
//	private JButton btnRead = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable knjigaTabela;
	
	private Biblioteka biblioteka;
	
	public KnjigaProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Knjiga");
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
		
		String[] zaglavlja = new String[] {"Id","Naslov Knjige", "Originalni Naslov Knjige", "Pisac","Godina Objavljivanja", "Opis", "Jezik", "Zanr"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniKnjiga().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniKnjiga().size(); i++) {
			Knjiga knjiga = biblioteka.sviNeobrisaniKnjiga().get(i);
			sadrzaj[i][0] = knjiga.getId();
			sadrzaj[i][1] = knjiga.getNaslovKnjige();
			sadrzaj[i][2] = knjiga.getOriginalniNaslovKnjige();
			sadrzaj[i][3] = knjiga.getPisac();
			sadrzaj[i][4] = knjiga.getGodinaObjavljivanja();
			sadrzaj[i][5] = knjiga.getOpis();
			sadrzaj[i][6] = knjiga.getJezik();
			sadrzaj[i][7] = knjiga.getZanr();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		knjigaTabela = new JTable(tableModel);
		
		knjigaTabela.setRowSelectionAllowed(true);
		knjigaTabela.setColumnSelectionAllowed(false);
		knjigaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		knjigaTabela.setDefaultEditor(Object.class, null);
		knjigaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(knjigaTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = knjigaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String Id = tableModel.getValueAt(red, 0).toString();
					Knjiga knjiga = biblioteka.nadjiKnjigu(Id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete knjigu?", 
							Id + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						knjiga.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.upisiKnjige("fajlovi/knjige.txt");
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigaForma pf = new KnjigaForma(biblioteka, null);
				pf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = knjigaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String Id = tableModel.getValueAt(red, 0).toString();
					Knjiga knjiga = biblioteka.nadjiKnjigu(Id);
//					
						KnjigaForma pf = new KnjigaForma(biblioteka, knjiga);
						pf.setVisible(true);
					}
				}
//			}
		});
	}
}

