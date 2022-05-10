package biblioteka;

import java.time.LocalDate;

import enumeracije.EnumPol;

public class ClanBiblioteke extends Osoba {

    private String brojClanskeKarte;
    private LocalDate datumPoslednjeUplate;
    private int brojMeseciClanarine;
    private boolean aktivan;
    private TipClanarine tipclanarine;
    
    public ClanBiblioteke() {
    	super();
    	this.brojClanskeKarte = "";
		this.datumPoslednjeUplate = null;
		this.brojMeseciClanarine = 0;
		this.aktivan = false;
		this.tipclanarine = null;
    	
    }
    
	public ClanBiblioteke(String brojClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseciClanarine,
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

	@Override
	public String toString() {
		return "ClanBiblioteke " + super.toString() + 
				"\nbrojClanskeKarte=" + brojClanskeKarte +
				"\ndatumPoslednjeUplate=" + datumPoslednjeUplate + 
				"\nbrojMeseciClanarine=" + brojMeseciClanarine +
				"\naktivan=" + aktivan;
				
	}

	public TipClanarine getTipclanarine() {
		return tipclanarine;
	}

	public void setTipclanarine(TipClanarine tipclanarine) {
		this.tipclanarine = tipclanarine;
	}
	

}

	


