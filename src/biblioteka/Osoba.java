package biblioteka;

import enumeracije.EnumPol;

public abstract class Osoba {

	protected String id;
    protected String imeIPrezime;
    protected String JMBG;
    protected String adresa;
    protected EnumPol pol;
    protected boolean obrisan;
	
    public Osoba() {
    	this.id = "";
		this.imeIPrezime = "";
		JMBG = "";
		this.adresa = "";
		this.pol = EnumPol.MUSKI;
		this.obrisan = false;
    }

    
    
	public Osoba(String id, String imeIPrezime, String jMBG, String adresa, EnumPol pol, boolean obrisan) {
		super();
		this.id = id;
		this.imeIPrezime = imeIPrezime;
		JMBG = jMBG;
		this.adresa = adresa;
		this.pol = pol;
		this.obrisan = obrisan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}


	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public EnumPol getPol() {
		return pol;
	}

	public void setPol(EnumPol pol) {
		this.pol = pol;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Osoba   \nID= " + id +
						"\nImeIPrezime= " + imeIPrezime +
						"\nJMBG= " + JMBG +
						"\nAdresa= " + adresa +
						"\nPol= " + pol +
						"\nObrisan= " + obrisan;
	}
	
	
	

}
