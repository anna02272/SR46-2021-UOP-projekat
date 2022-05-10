package biblioteka;

import java.util.ArrayList;


public class Biblioteka {
	    private String id;
	    private String naziv;
	    private String adresa;
	    private String telefon;
	    private String radnoVreme;
	    private boolean obrisan;
	    
	    private ArrayList<Biblioteka> biblioteke;
		private ArrayList<Knjiga> knjige;
		private ArrayList<PrimerakKnjige> primerakKnjiga;
		private ArrayList<TipClanarine> tipoviClanarine;
		private ArrayList<ZanrKnjige> zanroviKnjiga;
		private ArrayList<Administrator> administratori;
		private ArrayList<Bibliotekar> bibliotekar;
		private ArrayList<ClanBiblioteke> clanoviBiblioteke;
	    
    public Biblioteka() {
    	this.id = "";
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = "" ;
		this.obrisan = false;
		
		this.biblioteke = new ArrayList<Biblioteka>();
		this.knjige = new ArrayList<Knjiga>();
		this.primerakKnjiga = new ArrayList<PrimerakKnjige>();
		this.tipoviClanarine = new ArrayList<TipClanarine>();
		this.zanroviKnjiga = new ArrayList<ZanrKnjige>();
		this.administratori = new ArrayList<Administrator>();
		this.bibliotekar = new ArrayList<Bibliotekar>();
		this.clanoviBiblioteke = new ArrayList<ClanBiblioteke>();
    }
       
	
	public Biblioteka(String id, String naziv, String adresa, String telefon, String radnoVreme, boolean obrisan,
			ArrayList<Biblioteka> biblioteke, ArrayList<Knjiga> knjige, ArrayList<PrimerakKnjige> primerakKnjiga,
			ArrayList<TipClanarine> tipoviClanarine, ArrayList<ZanrKnjige> zanroviKnjiga,
			ArrayList<Administrator> administratori, ArrayList<Bibliotekar> bibliotekar,
			ArrayList<ClanBiblioteke> clanoviBiblioteke) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.obrisan = obrisan;
		this.biblioteke = biblioteke;
		this.knjige = knjige;
		this.primerakKnjiga = primerakKnjiga;
		this.tipoviClanarine = tipoviClanarine;
		this.zanroviKnjiga = zanroviKnjiga;
		this.administratori = administratori;
		this.bibliotekar = bibliotekar;
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

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
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


	public ArrayList<Bibliotekar> getBibliotekar() {
		return bibliotekar;
	}


	public void setBibliotekar(ArrayList<Bibliotekar> bibliotekar) {
		this.bibliotekar = bibliotekar;
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


	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}


	@Override
	public String toString() {
		return "Biblioteka \nid=" + id + "\nnaziv=" + naziv + "\nadresa=" + adresa + "\ntelefon=" + telefon
				+ "\nradnoVreme=" + radnoVreme + "\nobrisan=" + obrisan + "\nbiblioteke=" + biblioteke + "\nknjige="
				+ knjige + "\nprimerakKnjiga=" + primerakKnjiga + "\ntipoviClanarine=" + tipoviClanarine
				+ "\nzanroviKnjiga=" + zanroviKnjiga + "\nadministratori=" + administratori + "\nbibliotekar="
				+ bibliotekar + "\nclanoviBiblioteke=" + clanoviBiblioteke;
	}


	
}
