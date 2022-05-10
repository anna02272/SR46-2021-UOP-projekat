package biblioteka;

import enumeracije.EnumPol;

public abstract class Zaposleni extends Osoba {

    protected String korisnickoIme;
    protected String korisnickaLozinka;
    protected double plata;
    protected String id;
    
    public Zaposleni() {
    	super();
    	this.korisnickoIme = "";
		this.korisnickaLozinka = "";
		this.plata = -1;
		this.id = "";
    }


    public void DodavanjeNovihClanova() {
   
    }

	public Zaposleni(String korisnickoIme, String korisnickaLozinka,double plata, String id, String imeIPrezime, String JMBG, String adresa, EnumPol pol, boolean obrisan ) {
		super(id, imeIPrezime, JMBG, adresa, pol, obrisan);
		this.korisnickoIme = korisnickoIme;
		this.korisnickaLozinka = korisnickaLozinka;
		this.plata = plata;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getKorisnickaLozinka() {
		return korisnickaLozinka;
	}

	public void setKorisnickaLozinka(String korisnickaLozinka) {
		this.korisnickaLozinka = korisnickaLozinka;
		
	}


	public double getPlata() {
		return plata;
	}


	public void setPlata(double plata) {
		this.plata = plata;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Zaposleni " + super.toString() +
				"\nkorisnickoIme=" + korisnickoIme +
				"\nkorisnickaLozinka=" + korisnickaLozinka +
				"\nplata=" + plata + "\nid"+id ;
	}

}
