package biblioteka;

import java.time.LocalDate;

public class IznajmljivanjeKnjige {

    private LocalDate datumIznajmljivanja;
    private LocalDate datumVracanja;
    private boolean obrisan;
    

    public IznajmljivanjeKnjige() {
    	this.datumIznajmljivanja = null ;
		this.datumVracanja = null;
		this.obrisan = false;
    }
    
	public IznajmljivanjeKnjige(LocalDate datumIznajmljivanja, LocalDate datumVracanja, boolean obrisan) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.obrisan = obrisan;
	}
	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	

}
