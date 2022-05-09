package osobe;

import java.time.LocalDate;

public class ClanBiblioteke extends Osoba {

    private String brojClanskeKarte;
    private LocalDate datumPoslednjeUplate;
    private int brojMeseciClanarine;
    private boolean aktivan;
    
    
    public ClanBiblioteke() {
    	this.brojClanskeKarte = "";
		this.datumPoslednjeUplate = null;
		this.brojMeseciClanarine = 0;
		this.aktivan = false;
    	
    }
    
	public ClanBiblioteke(String brojClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseciClanarine,
			boolean aktivan) {
		super();
		this.brojClanskeKarte = brojClanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciClanarine = brojMeseciClanarine;
		this.aktivan = aktivan;
		
	}
	
		public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}
		
	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}
	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}
	public int getBrojMeseciClanarine() {
		return brojMeseciClanarine;
	}
	public void setBrojMeseciClanarine(int brojMeseciClanarine) {
		this.brojMeseciClanarine = brojMeseciClanarine;
	}
	public boolean isAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	

}

	


