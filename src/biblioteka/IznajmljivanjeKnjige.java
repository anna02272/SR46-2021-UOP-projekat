package biblioteka;

import java.time.LocalDate;

public class IznajmljivanjeKnjige {

    private LocalDate datumIznajmljivanja;
    private LocalDate  datumVracanja;
    private boolean obrisan;
    private PrimerakKnjige primerak;
    private ClanBiblioteke clan;
    private Administrator administrator;
    private Bibliotekar bibliotekar;
    

    public IznajmljivanjeKnjige() {
    	this.datumIznajmljivanja = null ;
		this.datumVracanja = null;
		this.obrisan = false;
		this.primerak = null;
		this.clan = null;
		this.administrator = null;
		this.bibliotekar = null;
    }
    
	public IznajmljivanjeKnjige(LocalDate  datumIznajmljivanja,LocalDate  datumVracanja, boolean obrisan, 
			PrimerakKnjige primerak, ClanBiblioteke clan, Administrator administrator, Bibliotekar bibliotekar) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.obrisan = obrisan;
		this.primerak = primerak;
		this.clan = clan;
		this.administrator = administrator;
		this.bibliotekar = bibliotekar;
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

	public void setPrimerak(PrimerakKnjige primerak) {
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
		return "Iznajmljivanje [datumIznajmljivanja=" + datumIznajmljivanja +
				"|datumVracanja=" + datumVracanja
				+ "|obrisan=" + obrisan +
				"|primerak=" + primerak +
				"|clan=" + clan
				+ "|administrator=" + administrator +
				"|bibliotekar=" + bibliotekar + "]" ;
	}
}
