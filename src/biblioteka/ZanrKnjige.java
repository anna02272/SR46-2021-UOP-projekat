package biblioteka;

public class ZanrKnjige {

    private String oznaka;
    private String opis;
    private boolean obrisan;
    private String id;

    public ZanrKnjige() {
    	this.oznaka = "";
		this.opis = "";
		this.obrisan = false;
		this.id = "";
    }
    
    
	public ZanrKnjige(String oznaka, String opis, boolean obrisan, String id) {
		super();
		this.oznaka = oznaka;
		this.opis = opis;
		this.obrisan = obrisan;
		this.id = id;
	}
	
	
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}


	public boolean isObrisan() {
		return obrisan;
	}


	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "ZanrKnjige \noznaka=" + oznaka +
				"\nopis=" + opis +
				"\nobrisan=" + obrisan;
	}
	
	
}