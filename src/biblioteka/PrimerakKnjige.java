package biblioteka;

import java.time.LocalDate;

import enumeracije.EnumJezik;
import enumeracije.EnumTipPoveza;

public class PrimerakKnjige {
    
    private String id;
    private Knjiga nazivKnjige;
    private int brojStrana;
    private EnumTipPoveza tipPoveza;
    private EnumJezik jezik;
    private LocalDate godinaStampanja;
    private boolean iznajmljena;
    private boolean obrisan;
    
    
    public PrimerakKnjige() {
    	this.id = "";
		this.nazivKnjige = null;
		this.brojStrana = 0;
		this.tipPoveza = EnumTipPoveza.MEK ;
		this.jezik = EnumJezik.ENGLESKI;
		this.godinaStampanja = null;
		this.iznajmljena = true;
		this.obrisan = false;
    }
    
    
	public PrimerakKnjige(String id, Knjiga nazivKnjige, int brojStrana, EnumTipPoveza tipPoveza, EnumJezik jezik,
			LocalDate godinaStampanja, boolean iznajmljena, boolean obrisan) {
		super();
		this.id = id;
		this.nazivKnjige = nazivKnjige;
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
	public Knjiga getNazivKnjige() {
		return nazivKnjige;
	}
	public void setNazivKnjige(Knjiga nazivKnjige) {
		this.nazivKnjige = nazivKnjige;
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
	public LocalDate getGodinaStampanja() {
		return godinaStampanja;
	}
	public void setGodinaStampanja(LocalDate godinaStampanja) {
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
		return "PrimerakKnjige \nid=" + id +
				"nazivKnjige=" + nazivKnjige + 
				"\nbrojStrana=" + brojStrana
				+ "\ntipPoveza=" + tipPoveza +
				"\njezik=" + jezik +
				"\ngodinaStampanja=" + godinaStampanja
				+ "\niznajmljena=" + iznajmljena +
				"\nobrisan=" + obrisan;
	}


	
	

}
