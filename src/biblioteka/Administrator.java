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
		return "Administrator [korisnickoIme=" + korisnickoIme +
				"|korisnickaLozinka=" + korisnickaLozinka +
				"|plata="
				+ plata + "|id=" + id + "|imeIPrezime=" + imeIPrezime +
				"|JMBG=" + JMBG + "|adresa=" + adresa
				+ "|pol=" + pol + "|obrisan=" + obrisan + "]";
	}

	public String getIdOsoba() {
		// TODO Auto-generated method stub
		return null;
	}

	



	
    

}
