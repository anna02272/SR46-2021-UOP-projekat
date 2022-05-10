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
		return "Bibliotekar \nkorisnickoIme=" + korisnickoIme + "\nkorisnickaLozinka=" + korisnickaLozinka +
				"\nplata="
				+ plata + "\nid=" + id + "\nimeIPrezime=" + imeIPrezime + "\nJMBG=" + JMBG + "\nadresa=" + adresa
				+ "\npol=" + pol + "\nobrisan=" + obrisan ;
	}




}
