package biblioteka;

import java.time.LocalDate;

import enumeracije.EnumJezik;
import enumeracije.EnumTipPoveza;

public class PrimerakKnjige {
    
    private String id;
    private Knjiga knjiga;
    private int brojStrana;
    private EnumTipPoveza tipPoveza;
    private EnumJezik jezik;
    private int godinaStampanja;
    private boolean iznajmljena;
    private boolean obrisan;
    
    
    public PrimerakKnjige() {
    	this.id = "";
		this.knjiga = null;
		this.brojStrana = 0;
		this.tipPoveza = EnumTipPoveza.MEK ;
		this.jezik = EnumJezik.ENGLESKI;
		this.godinaStampanja = 0;
		this.iznajmljena = true;
		this.obrisan = false;
    }
    
    
	public PrimerakKnjige(String id, Knjiga knjiga, int brojStrana, EnumTipPoveza tipPoveza, EnumJezik jezik,
			int godinaStampanja, boolean iznajmljena, boolean obrisan) {
		super();
		this.id = id;
		this.knjiga = knjiga;
		this.brojStrana = brojStrana;
		this.tipPoveza = tipPoveza;
		this.jezik = jezik;
		this.godinaStampanja = godinaStampanja;
		this.iznajmljena = iznajmljena;
		this.obrisan = obrisan;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Knjiga getKnjiga() {
		return knjiga;
	}
	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}
	public int getBrojStrana() {
		return brojStrana;
	}
	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}
	public EnumTipPoveza getTipPoveza() {
		return tipPoveza;
	}
	public void setTipPoveza(EnumTipPoveza tipPoveza) {
		this.tipPoveza = tipPoveza;
	}
	public int getGodinaStampanja() {
		return godinaStampanja;
	}
	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}
	public boolean isIznajmljena() {
		return iznajmljena;
	}
	public void setIznajmljena(boolean iznajmljena) {
		this.iznajmljena = iznajmljena;
	}
	public EnumJezik getJezik() {
		return jezik;
	}
	public void setJezik(EnumJezik jezik) {
		this.jezik = jezik;
	}
	public boolean isObrisan() {
		return obrisan;
	}
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}


	@Override
	public String toString() {
		return "PrimerakKnjige [id=" + id +
				"|naslovKnjige=" + knjiga + 
				"|brojStrana=" + brojStrana
				+ "|tipPoveza=" + tipPoveza +
				"|jezik=" + jezik +
				"|godinaStampanja=" + godinaStampanja
				+ "|iznajmljena=" + iznajmljena +
				"|obrisan=" + obrisan +"]";
	}


	
	

}
