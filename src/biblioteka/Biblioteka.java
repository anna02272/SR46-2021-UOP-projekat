package biblioteka;

import java.time.LocalTime;

public class Biblioteka {
	    protected String id;
	    protected String naziv;
	    protected String adresa;
	    protected String telefon;
	    protected LocalTime radnoVreme;
	    protected boolean obrisan;
		

	    
    public Biblioteka() {
    	this.id = "";
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = null ;
		this.obrisan = false;
    }
       
	public Biblioteka(String id, String naziv, String adresa, String telefon, LocalTime radnoVreme, boolean obrisan) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.obrisan = obrisan;
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
	public LocalTime getRadnoVreme() {
		return radnoVreme;
	}
	public void setRadnoVreme(LocalTime radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

}
