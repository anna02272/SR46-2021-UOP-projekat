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

import biblioteka.Biblioteka;
import biblioteka.TipClanarine;
import guiFormeZaDodavanjeIIzmenu.ClanarinaForma;

public class ClanarinaProzor extends JFrame{

	String putanjaAdd, putanjaDelete, putanjaRead, putanjaUpdate;
	ImageIcon slAdd, slDelete, slRead, slUpdate;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
//	private JButton btnRead = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable clanarinaTabela;
	
	private Biblioteka biblioteka;
	
	public ClanarinaProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Clanarina");
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
		
		String[] zaglavlja = new String[] {"Id", "Naziv", "Cena"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniClanarina().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniClanarina().size(); i++) {
			TipClanarine tipClanarine = biblioteka.sviNeobrisaniClanarina().get(i);
			sadrzaj[i][0] = tipClanarine.getId();
			sadrzaj[i][1] = tipClanarine.getNaziv();
			sadrzaj[i][2] = tipClanarine.getCena();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanarinaTabela = new JTable(tableModel);
		
		clanarinaTabela.setRowSelectionAllowed(true);
		clanarinaTabela.setColumnSelectionAllowed(false);
		clanarinaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanarinaTabela.setDefaultEditor(Object.class, null);
		clanarinaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(clanarinaTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanarinaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					TipClanarine tipClanarine = biblioteka.nadjiClanarinu(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete clanarinu?", 
							id + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						tipClanarine.setObrisan(true);
						tableModel.removeRow(red);
						
						biblioteka.upisiTipClanarine("fajlovi/tipClanarine.txt");
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanarinaForma pf = new ClanarinaForma(biblioteka, null);
				pf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanarinaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String Id = tableModel.getValueAt(red, 0).toString();
					TipClanarine tipClanarine = biblioteka.nadjiClanarinu(Id);
					if(tipClanarine == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja clanarine sa tim id", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						ClanarinaForma pf = new ClanarinaForma(biblioteka, tipClanarine);
						pf.setVisible(true);
					}
				}
			}
		});
	}
}

