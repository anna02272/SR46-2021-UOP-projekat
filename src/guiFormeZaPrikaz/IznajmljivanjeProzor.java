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

import biblioteka.Biblioteka;
import biblioteka.IznajmljivanjeKnjige;
import guiFormeZaDodavanjeIIzmenu.IznajmljivanjeForma;
public class IznajmljivanjeProzor extends JFrame{

	String putanjaAdd, putanjaDelete, putanjaRead, putanjaUpdate;
	ImageIcon slAdd, slDelete, slRead, slUpdate;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private JButton btnRead = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable iznajmljivanjeTabela;
	
	private Biblioteka biblioteka;
	
	public IznajmljivanjeProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Iznajmljivanje");
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
		
		String[] zaglavlja = new String[] {"Datum iznajmljivanja", "Datum vracanja", "Primerak knjige", "Clan biblioteke", "Administrator","Bibliotekar"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniIznajmljivanje().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniIznajmljivanje().size(); i++) {
			IznajmljivanjeKnjige iznajmljivanjeKnjige = biblioteka.sviNeobrisaniIznajmljivanje().get(i);
			sadrzaj[i][0] = iznajmljivanjeKnjige.getDatumIznajmljivanja();
			sadrzaj[i][1] = iznajmljivanjeKnjige.getDatumVracanja();
			sadrzaj[i][2] = iznajmljivanjeKnjige.getPrimerak();
			sadrzaj[i][3] = iznajmljivanjeKnjige.getClan();
			sadrzaj[i][4] = iznajmljivanjeKnjige.getAdministrator();
			sadrzaj[i][5] = iznajmljivanjeKnjige.getBibliotekar();
		
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		iznajmljivanjeTabela = new JTable(tableModel);
		
		iznajmljivanjeTabela.setRowSelectionAllowed(true);
		iznajmljivanjeTabela.setColumnSelectionAllowed(false);
		iznajmljivanjeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iznajmljivanjeTabela.setDefaultEditor(Object.class, null);
		iznajmljivanjeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(iznajmljivanjeTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String datumIznajmljivanja = tableModel.getValueAt(red, 0).toString();
					IznajmljivanjeKnjige iznajmljivanjeKnjige = biblioteka.nadjiIznajmljivanje(datumIznajmljivanja);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete iznajmljenu knjigu?", 
							datumIznajmljivanja + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						iznajmljivanjeKnjige.setObrisan(true);
						tableModel.removeRow(red);
						
						biblioteka.upisiIznajmljivanjeKnjige("fajlovi/iznajmljivanjeknjige.txt");
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjeForma pf = new IznajmljivanjeForma(biblioteka, null);
				pf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String datumIznajmljivanja = tableModel.getValueAt(red, 0).toString();
					IznajmljivanjeKnjige iznajmljivanjeKnjige = biblioteka.nadjiIznajmljivanje(datumIznajmljivanja);

					IznajmljivanjeForma pf = new IznajmljivanjeForma(biblioteka, iznajmljivanjeKnjige);
						pf.setVisible(true);
					}
				}
		});
	}
}

