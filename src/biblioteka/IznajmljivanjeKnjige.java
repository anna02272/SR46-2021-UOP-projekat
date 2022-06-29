package biblioteka;

import java.time.LocalDate;
import java.util.ArrayList;

public class IznajmljivanjeKnjige {

	private String id;
    private LocalDate datumIznajmljivanja;
    private LocalDate  datumVracanja;
    private boolean obrisan;
    private PrimerakKnjige primerak;
    private ClanBiblioteke clan;
    private Administrator administrator;
    private Bibliotekar bibliotekar;
    

    public IznajmljivanjeKnjige() {
    	this.id = "";
    	this.datumIznajmljivanja = null ;
		this.datumVracanja = null;
		this.obrisan = false;
		this.primerak = null;
		this.clan = null;
		this.administrator = null;
		this.bibliotekar = null;
    }
    
	public IznajmljivanjeKnjige(String id, LocalDate  datumIznajmljivanja,LocalDate  datumVracanja, boolean obrisan, 
			PrimerakKnjige primerak, ClanBiblioteke clan, Administrator administrator, Bibliotekar bibliotekar) {
		super();
		this.id = id;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.obrisan = obrisan;
		this.primerak = primerak;
		this.clan = clan;
		this.administrator = administrator;
		this.bibliotekar = bibliotekar;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate  getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(LocalDate  datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public LocalDate  getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(LocalDate  datumVracanja) {
		this.datumVracanja = datumVracanja;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	
	public PrimerakKnjige getPrimerak() {
		return primerak;
	}

	public void setPrimerak( PrimerakKnjige primerak) {
		this.primerak = primerak;
	}

	public ClanBiblioteke getClan() {
		return clan;
	}

	public void setClan(ClanBiblioteke clan) {
		this.clan = clan;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Bibliotekar getBibliotekar() {
		return bibliotekar;
	}

	public void setBibliotekar(Bibliotekar bibliotekar) {
		this.bibliotekar = bibliotekar;
	}
	
	@Override
	public String toString() {
		return "Iznajmljivanje [id=" + id + "|datumIznajmljivanja=" + datumIznajmljivanja +
				"|datumVracanja=" + datumVracanja
				+ "|obrisan=" + obrisan +
				"|primerak=" + primerak +
				"|clan=" + clan
				+ "|administrator=" + administrator +
				"|bibliotekar=" + bibliotekar + "]" ;
	}
}
