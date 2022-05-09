package biblioteka;

import java.time.LocalDate;

import enumeracije.EnumJezik;

public class Knjiga {
	    private String id;
	    private String naslovKnjige;
	    private String originalniNaslovKnjige;
	    private String imePisca;
	    private String prezimePisca;
	    private LocalDate godinaObjavljivanja;
	    private String opis;
	    private EnumJezik jezik;
	    private boolean obrisan;
	    
	    
    public Knjiga() {
    	this.id = "";
		this.naslovKnjige = "";
		this.originalniNaslovKnjige = "";
		this.imePisca ="";
		this.prezimePisca = "";
		this.godinaObjavljivanja = null;
		this.opis = "";
		this.jezik = EnumJezik.ENGLESKI;;
		this.obrisan = false;
    }

   
    
    
	public Knjiga(String id, String naslovKnjige, String originalniNaslovKnjige, String imePisca, String prezimePisca,
			LocalDate godinaObjavljivanja, String opis, EnumJezik jezik, boolean obrisan) {
		super();
		this.id = id;
		this.naslovKnjige = naslovKnjige;
		this.originalniNaslovKnjige = originalniNaslovKnjige;
		this.imePisca = imePisca;
		this.prezimePisca = prezimePisca;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.opis = opis;
		this.jezik = jezik;
		this.obrisan = obrisan;
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
	public String getImePisca() {
		return imePisca;
	}
	public void setImePisca(String imePisca) {
		this.imePisca = imePisca;
	}
	public String getPrezimePisca() {
		return prezimePisca;
	}
	public void setPrezimePisca(String prezimePisca) {
		this.prezimePisca = prezimePisca;
	}
	public LocalDate getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}
	public void setGodinaObjavljivanja(LocalDate godinaObjavljivanja) {
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

}
