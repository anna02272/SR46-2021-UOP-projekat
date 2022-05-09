package osobe;

public abstract class Zaposleni extends Osoba {

    protected String korisnickoIme;
    protected String korisnickaLozinka;
    
    public Zaposleni() {
    	this.korisnickoIme = "";
		this.korisnickaLozinka = "";
    }


    public void DodavanjeNovihClanova() {
   
    }

	public Zaposleni(String korisnickoIme, String korisnickaLozinka) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.korisnickaLozinka = korisnickaLozinka;
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

}
