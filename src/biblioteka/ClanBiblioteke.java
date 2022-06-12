package biblioteka;

import java.time.LocalDate;

import enumeracije.EnumPol;

public class ClanBiblioteke extends Osoba {

    private String brojClanskeKarte;
    private String datumPoslednjeUplate;
    private int brojMeseciClanarine;
    private boolean aktivan;
    private TipClanarine tipclanarine;
    
    public ClanBiblioteke() {
    	super();
    	this.brojClanskeKarte = "";
		this.datumPoslednjeUplate = null;
		this.brojMeseciClanarine = -1;
		this.aktivan = true;
		this.tipclanarine = null;	
    }
    
	public ClanBiblioteke(String brojClanskeKarte, String datumPoslednjeUplate, int brojMeseciClanarine,
			boolean aktivan, String id, String imeIPrezime, String JMBG, String adresa, EnumPol pol, boolean obrisan, TipClanarine tipclanarine) {
		super(id, imeIPrezime, JMBG, adresa, pol, obrisan);
		this.brojClanskeKarte = brojClanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciClanarine = brojMeseciClanarine;
		this.aktivan = aktivan;
		this.tipclanarine = tipclanarine;
	}
	
		public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}
		
	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	public String getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}
	public void setDatumPoslednjeUplate(String datumPoslednjeUplate) {
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

	
	@Override
	public String toString() {
		return "ClanBiblioteke brojClanskeKarte=" + brojClanskeKarte + ", datumPoslednjeUplate=" + datumPoslednjeUplate
				+ ", brojMeseciClanarine=" + brojMeseciClanarine + ", aktivan=" + aktivan + ", tipclanarine="
				+ tipclanarine + ", id=" + id + ", imeIPrezime=" + imeIPrezime + ", JMBG=" + JMBG + ", adresa=" + adresa
				+ ", pol=" + pol + ", obrisan=" + obrisan ;
	}

	public TipClanarine getTipclanarine() {
		return tipclanarine;
	}

	public void setTipclanarine(TipClanarine tipclanarine) {
		this.tipclanarine = tipclanarine;
	}
	

}

	


