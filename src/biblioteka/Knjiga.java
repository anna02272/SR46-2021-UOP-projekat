package biblioteka;

import java.time.LocalDate;

import enumeracije.EnumJezik;

public class Knjiga {
	    private String id;
	    private String naslovKnjige;
	    private String originalniNaslovKnjige;
	    private String pisac;
	    private int godinaObjavljivanja;
	    private String opis;
	    private EnumJezik jezik;
	    private boolean obrisan;
	    private ZanrKnjige zanr;
	    
    public Knjiga() {
    	this.id = "";
		this.naslovKnjige = "";
		this.originalniNaslovKnjige = "";
		this.pisac ="";
		this.godinaObjavljivanja = -1;
		this.opis = "";
		this.jezik = EnumJezik.ENGLESKI;;
		this.obrisan = false;
		this.zanr = null;
    }
	public Knjiga(String id, String naslovKnjige, String originalniNaslovKnjige, String pisac,
			int godinaObjavljivanja, String opis, EnumJezik jezik, boolean obrisan, ZanrKnjige zanr) {
		super();
		this.id = id;
		this.naslovKnjige = naslovKnjige;
		this.originalniNaslovKnjige = originalniNaslovKnjige;
		this.pisac = pisac;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.opis = opis;
		this.jezik = jezik;
		this.obrisan = obrisan;
		this.zanr = zanr;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNaslovKnjige() {
		return naslovKnjige;
	}
	public void setNaslovKnjige(String naslovKnjige) {
		this.naslovKnjige = naslovKnjige;
	}
	public String getOriginalniNaslovKnjige() {
		return originalniNaslovKnjige;
	}
	public void setOriginalniNaslovKnjige(String originalniNaslovKnjige) {
		this.originalniNaslovKnjige = originalniNaslovKnjige;
	}
	public String getPisac() {
		return pisac;
	}
	public void setPisac(String pisac) {
		this.pisac = pisac;
	}
	
	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}
	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
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
	public ZanrKnjige getZanr() {
		return zanr;
	}

	public void setZanr(ZanrKnjige zanr) {
		this.zanr = zanr;
	}
	




	@Override
	public String toString() {
		return "Knjiga \nid=" + id +
				"\nnaslovKnjige=" + naslovKnjige +
				"\noriginalniNaslovKnjige="
				+ originalniNaslovKnjige +
				"\npisac=" + pisac
				+ "\ngodinaObjavljivanja=" + godinaObjavljivanja +
				"\nopis=" + opis +
				"\njezik=" + jezik +
				"\nobrisan=" + obrisan + "\nzanr="+ zanr;
	}
}





