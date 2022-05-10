package biblioteka;

import enumeracije.EnumPol;

public class Administrator extends Zaposleni {
	Administrator() {
		super();
    }

    public Administrator(String korisnickoIme, String korisnickaLozinka, double plata, String id, String imeIPrezime,
			String JMBG, String adresa, EnumPol pol, boolean obrisan) {
		super(korisnickoIme, korisnickaLozinka, plata, id, imeIPrezime, JMBG, adresa, pol, obrisan);
	}


	public void RegistrovanjeNovihZaposlenih() {
       
    }

	@Override
	public String toString() {
		return "Administrator \nkorisnickoIme=" + korisnickoIme +
				"\nkorisnickaLozinka=" + korisnickaLozinka +
				"\nplata="
				+ plata + "\nid=" + id + "\nimeIPrezime=" + imeIPrezime +
				"\nJMBG=" + JMBG + "\nadresa=" + adresa
				+ "\npol=" + pol + "\nobrisan=" + obrisan ;
	}

	
    

}
