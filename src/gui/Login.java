package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;


public class Login extends JFrame {

	private JLabel lblGreeting = new JLabel("Dobrodosli. Molimo da se prijavite.");
	private JLabel lblUsername = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblPassword = new JLabel("Lozinka");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("PRIJAVA");
	
	private Biblioteka biblioteka;
	
	public Login(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(250,200);
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblGreeting, "span 2");
		add(lblUsername);
		add(txtKorisnickoIme);
		add(lblPassword);
		add(pfPassword);
		add(new JLabel());
		add(btnOk);
		
		getRootPane().setDefaultButton(btnOk);
	}
	
	public void initActions() {
		
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnikoIme = txtKorisnickoIme.getText().trim();
				String korisnickaLozinka = new String(pfPassword.getPassword()).trim();
				
				if(korisnikoIme.equals("") || korisnickaLozinka.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					Zaposleni prijavljeni = biblioteka.login(korisnikoIme, korisnickaLozinka);
					
					if(prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						System.out.println(prijavljeni instanceof Administrator);
						System.out.println(prijavljeni instanceof Bibliotekar);
						Login.this.dispose();
						Login.this.setVisible(false);
						boolean isAdministrator = prijavljeni instanceof Administrator;
						BibliotekaGUI gp = new BibliotekaGUI(biblioteka, prijavljeni,isAdministrator);
						gp.setVisible(true);
					}
				}
			}
		});
		
	}
}


