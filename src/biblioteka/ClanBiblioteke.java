package biblioteka;

import java.time.LocalDate;

import enumeracije.EnumPol;

public class ClanBiblioteke extends Osoba {

    private String brojClanskeKarte;
    private LocalDate datumPoslednjeUplate;
    private int brojMeseciClanarine;
    private boolean aktivan;
    private TipClanarine tipClanarine;
    
    public ClanBiblioteke() {
    	super();
    	this.brojClanskeKarte = "";
		this.datumPoslednjeUplate = null;
		this.brojMeseciClanarine = -1;
		this.aktivan = true;
		this.tipClanarine = null;	
    }
    
	public ClanBiblioteke(String brojClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseciClanarine,
			boolean aktivan, String id, String imeIPrezime, String JMBG, String adresa, EnumPol pol, boolean obrisan, TipClanarine tipClanarine) {
		super(id, imeIPrezime, JMBG, adresa, pol, obrisan);
		this.brojClanskeKarte = brojClanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciClanarine = brojMeseciClanarine;
		this.aktivan = aktivan;
		this.tipClanarine = tipClanarine;
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
	public TipClanarine getTipClanarine() {
		return tipClanarine;
	}

	public void setTipclanarine(TipClanarine tipClanarine) {
		this.tipClanarine = tipClanarine;
	}
	
	@Override
	public String toString() {
		return "ClanBiblioteke [brojClanskeKarte=" + brojClanskeKarte + "|datumPoslednjeUplate=" + datumPoslednjeUplate
				+ "|brojMeseciClanarine=" + brojMeseciClanarine + "|aktivan=" + aktivan + 
				  "|id=" + id + "|imeIPrezime=" + imeIPrezime + "|JMBG=" + JMBG + "|adresa=" + adresa
				+ "|pol=" + pol + "|obrisan=" + obrisan +"|tipclanarine="+ tipClanarine + "]";
	}

	
	

}

	


