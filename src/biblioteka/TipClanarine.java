package biblioteka;

public class TipClanarine {
   
    private String id;
    private String naziv;
    private double cena;
    private boolean obrisan;
    
    public TipClanarine() {
    	this.id = "";
		this.naziv = "";
		this.cena = 0;
		this.obrisan = false;
    }
    
    
	public TipClanarine(String id, String naziv, double cena, boolean obrisan) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
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
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}


	public boolean isObrisan() {
		return obrisan;
	}


	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	

}
