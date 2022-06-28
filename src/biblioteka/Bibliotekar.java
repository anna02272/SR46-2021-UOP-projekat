package biblioteka;

import enumeracije.EnumPol;

public class Bibliotekar extends Zaposleni {

    public Bibliotekar() {
    	super();
    }
    
	public Bibliotekar(String korisnickoIme, String korisnickaLozinka, double plata, String id, String imeIPrezime,
			String JMBG, String adresa, EnumPol pol, boolean obrisan) {
		super(korisnickoIme, korisnickaLozinka, plata, id, imeIPrezime, JMBG, adresa, pol, obrisan);
	}

	@Override
	public String toString() {
		return "Bibliotekar [korisnickoIme=" + korisnickoIme +
				"|korisnickaLozinka=" + korisnickaLozinka +
				"|plata="
				+ plata + "|id=" + id + "|imeIPrezime=" + imeIPrezime +
				"|JMBG=" + JMBG + "|adresa=" + adresa
				+ "|pol=" + pol + "|obrisan=" + obrisan + "]";
	}







}
