package biblioteka;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import enumeracije.EnumJezik;
import enumeracije.EnumPol;


public class Biblioteka {
	    private String id;
	    private String naziv;
	    private String adresa;
	    private String telefon;
	    private String radnoVreme;
	    
	    private ArrayList<Biblioteka> biblioteke;
		private ArrayList<Knjiga> knjige;
		private ArrayList<PrimerakKnjige> primerakKnjiga;
		private ArrayList<TipClanarine> tipoviClanarine;
		private ArrayList<ZanrKnjige> zanroviKnjiga;
		protected ArrayList<Administrator> administratori;
		private ArrayList<Bibliotekar> bibliotekari;
		private ArrayList<ClanBiblioteke> clanoviBiblioteke;
	    
    public Biblioteka() {
    	this.id = "";
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = "" ;
		
		this.biblioteke = new ArrayList<Biblioteka>();
		this.knjige = new ArrayList<Knjiga>();
		this.primerakKnjiga = new ArrayList<PrimerakKnjige>();
		this.tipoviClanarine = new ArrayList<TipClanarine>();
		this.zanroviKnjiga = new ArrayList<ZanrKnjige>();
		this.administratori = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanoviBiblioteke = new ArrayList<ClanBiblioteke>();
    }
       
	
	public Biblioteka(String id, String naziv, String adresa, String telefon, String radnoVreme,
			ArrayList<Biblioteka> biblioteke, ArrayList<Knjiga> knjige, ArrayList<PrimerakKnjige> primerakKnjiga,
			ArrayList<TipClanarine> tipoviClanarine, ArrayList<ZanrKnjige> zanroviKnjiga,
			ArrayList<Administrator> administratori, ArrayList<Bibliotekar> bibliotekari,
			ArrayList<ClanBiblioteke> clanoviBiblioteke) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.biblioteke = biblioteke;
		this.knjige = knjige;
		this.primerakKnjiga = primerakKnjiga;
		this.tipoviClanarine = tipoviClanarine;
		this.zanroviKnjiga = zanroviKnjiga;
		this.administratori = administratori;
		this.bibliotekari = bibliotekari;
		this.clanoviBiblioteke = clanoviBiblioteke;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getRadnoVreme() {
		return radnoVreme;
	}
	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	public ArrayList<Biblioteka> getBiblioteke() {
		return biblioteke;
	}


	public void setBiblioteke(ArrayList<Biblioteka> biblioteke) {
		this.biblioteke = biblioteke;
	}


	public ArrayList<PrimerakKnjige> getPrimerakKnjiga() {
		return primerakKnjiga;
	}


	public void setPrimerakKnjiga(ArrayList<PrimerakKnjige> primerakKnjiga) {
		this.primerakKnjiga = primerakKnjiga;
	}


	public ArrayList<TipClanarine> getTipoviClanarine() {
		return tipoviClanarine;
	}


	public void setTipoviClanarine(ArrayList<TipClanarine> tipoviClanarine) {
		this.tipoviClanarine = tipoviClanarine;
	}


	public ArrayList<ZanrKnjige> getZanroviKnjiga() {
		return zanroviKnjiga;
	}


	public void setZanroviKnjiga(ArrayList<ZanrKnjige> zanroviKnjiga) {
		this.zanroviKnjiga = zanroviKnjiga;
	}


	public ArrayList<Administrator> getAdministratori() {
		return administratori;
	}


	public void setAdministratori(ArrayList<Administrator> administratori) {
		this.administratori = administratori;
	}


	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}


	public void setBibliotekari(ArrayList<Bibliotekar> bibliotekari) {
		this.bibliotekari = bibliotekari;
	}


	public ArrayList<ClanBiblioteke> getClanoviBiblioteke() {
		return clanoviBiblioteke;
	}


	public void setClanoviBiblioteke(ArrayList<ClanBiblioteke> clanoviBiblioteke) {
		this.clanoviBiblioteke = clanoviBiblioteke;
	}


	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}


	@Override
	public String toString() {
		return "Biblioteka \nid=" + id + "\nnaziv=" + naziv + "\nadresa=" + adresa + "\ntelefon=" + telefon
				+ "\nradnoVreme=" + radnoVreme  + "\nbiblioteke=" + biblioteke + "\nknjige="
				+ knjige + "\nprimerakKnjiga=" + primerakKnjiga + "\ntipoviClanarine=" + tipoviClanarine
				+ "\nzanroviKnjiga=" + zanroviKnjiga + "\nadministratori=" + administratori + "\nbibliotekari="
				+ bibliotekari + "\nclanoviBiblioteke=" + clanoviBiblioteke;
	}
	
	
	//ADMINISTRATOR

	public void upisiAdministratora(Administrator testAdministrator) {
		try {
			File file = new File("fajlovi/administratori.txt");
			String content = "";
			for (Administrator administrator : administratori) {
				
				content += administrator.getKorisnickoIme() + "|" + administrator.getKorisnickaLozinka() + "|"
						+ administrator.getPlata() + "|" + administrator.getId() +
						"|" + administrator.getImeIPrezime() + "|" +
						administrator.getJMBG() + "|" + administrator.getAdresa() + "|"
								+ administrator.getPol() + "|"
						+ administrator.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja administratora.");
		}
	}
	
		public ArrayList<Administrator> ucitajAdministratora(String administratorFajl) {
			ArrayList<Administrator> administatori = new ArrayList<Administrator>();
			try {
				
				File file = new File(administratorFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					String korisnickoIme= split[0];
					String korisnickaLozinka= split[1];
					double plata = Double.parseDouble(split[2]);
					String id = split[3];
					String imePrezime = split[4];
					String JMBG = split[5];
					String adresa = split[6];
					String pol = split[7];
					EnumPol pol1 = EnumPol.ZENSKI;
					for (EnumPol j: EnumPol.values()) {
						if(j.name().equalsIgnoreCase(pol)){
							pol1 = j;
						}
					}
					Boolean obrisan = Boolean.parseBoolean(split[8]);
					Administrator admin = new Administrator(korisnickoIme,korisnickaLozinka,plata,id,imePrezime,JMBG,adresa,pol1,obrisan);
					administatori.add(admin);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o administratoru");
				e.printStackTrace();
			}
			return administatori;
		}


//BIBLIOTEKAR


	public void upisiBibliotekara(Bibliotekar testBibliotekar) {
		try {
			File file = new File("fajlovi/bibliotekari.txt");
			String content = "";
			for (Bibliotekar bibliotekar : bibliotekari) {
				
				content += bibliotekar.getKorisnickoIme() + "|" + bibliotekar.getKorisnickaLozinka() + "|"
						+ bibliotekar.getPlata() + "|" + bibliotekar.getId() +
						"|" + bibliotekar.getImeIPrezime() + "|" +
						bibliotekar.getJMBG() + "|" + bibliotekar.getAdresa() + "|"
								+ bibliotekar.getPol() + "|"
						+ bibliotekar.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja bibliotekara.");
		}
	}

	public ArrayList<Bibliotekar> ucitajBibliotekara(String bibliotekarFajl) {
		ArrayList<Bibliotekar> bibliotekari = new ArrayList<Bibliotekar>();
		try {
			
			File file = new File(bibliotekarFajl);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String korisnickoIme= split[0];
				String korisnickaLozinka= split[1];
				double plata = Double.parseDouble(split[2]);
				String id = split[3];
				String imePrezime = split[4];
				String JMBG = split[5];
				String adresa = split[6];
				String pol = split[7];
				EnumPol pol1 = EnumPol.ZENSKI;
				for (EnumPol j: EnumPol.values()) {
					if(j.name().equalsIgnoreCase(pol)){
						pol1 = j;
					}
				}
				Boolean obrisan = Boolean.parseBoolean(split[8]);
				Bibliotekar bibl = new Bibliotekar(korisnickoIme,korisnickaLozinka,plata,id,imePrezime,JMBG,adresa,pol1,obrisan);
				bibliotekari.add(bibl);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o bibliotekaru");
			e.printStackTrace();
		}
		return bibliotekari;
	}
}
	






