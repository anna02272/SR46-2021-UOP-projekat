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
import biblioteka.ZanrKnjige;
import guiFormeZaDodavanjeIIzmenu.ZanrForma;

public class ZanrProzor extends JFrame{

	String putanjaAdd, putanjaDelete, putanjaRead, putanjaUpdate;
	ImageIcon slAdd, slDelete, slRead, slUpdate;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private JButton btnRead = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable zanrTabela;
	
	private Biblioteka biblioteka;
	
	public ZanrProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Zanr");
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
		
		putanjaRead = "slike/read.png";
		slRead = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaRead).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		btnRead.setIcon(slRead);
		
		putanjaUpdate = "slike/update.png";
		slUpdate = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaUpdate).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		btnEdit.setIcon(slUpdate);
		
		putanjaDelete = "slike/delete.png";
		slDelete = new ImageIcon(Toolkit.getDefaultToolkit().getImage(putanjaDelete).getScaledInstance(28, 28,Image.SCALE_DEFAULT));
		btnDelete.setIcon(slDelete);
		
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnRead);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"Id", "Oznaka", "Opis"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniZanr().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniZanr().size(); i++) {
			ZanrKnjige zanrKnjige = biblioteka.sviNeobrisaniZanr().get(i);
			sadrzaj[i][0] = zanrKnjige.getId();
			sadrzaj[i][1] = zanrKnjige.getOznaka();
			sadrzaj[i][2] = zanrKnjige.getOpis();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		zanrTabela = new JTable(tableModel);
		
		zanrTabela.setRowSelectionAllowed(true);
		zanrTabela.setColumnSelectionAllowed(false);
		zanrTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		zanrTabela.setDefaultEditor(Object.class, null);
		zanrTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(zanrTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanrTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String id = tableModel.getValueAt(red, 0).toString();
					ZanrKnjige zanrKnjige = biblioteka.nadjiZanr(id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete zanr?", 
							id + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						zanrKnjige.setObrisan(true);
						tableModel.removeRow(red);
						
						biblioteka.upisiZanrKnjige("fajlovi/zanr.txt");
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanrForma pf = new ZanrForma(biblioteka, null);
				pf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanrTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String Id = tableModel.getValueAt(red, 0).toString();
					ZanrKnjige zanrKnjige = biblioteka.nadjiZanr(Id);
					if(zanrKnjige == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja zanra sa tim id", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						ZanrForma pf = new ZanrForma(biblioteka, zanrKnjige);
						pf.setVisible(true);
					}
				}
			}
		});
	}
}

