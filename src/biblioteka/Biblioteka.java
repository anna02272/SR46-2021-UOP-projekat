package biblioteka;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import enumeracije.EnumJezik;
import enumeracije.EnumPol;
import enumeracije.EnumTipPoveza;


public class Biblioteka {
	    private String id;
	    private String naziv;
	    private String adresa;
	    private String telefon;
	    private String radnoVreme;
	    
	    private ArrayList<Biblioteka> biblioteke;
		private ArrayList<Knjiga> knjige;
		private ArrayList<PrimerakKnjige> primerakKnjiga;
		private ArrayList<TipClanarine> tipoviClanarine;
		private ArrayList<ZanrKnjige> zanroviKnjiga;
		private ArrayList<Zaposleni> sviZaposleni;
		private ArrayList<Administrator> administratori;
		private ArrayList<Bibliotekar> bibliotekari;
		private ArrayList<ClanBiblioteke> clanoviBiblioteke;
		private ArrayList<IznajmljivanjeKnjige> iznajmljivanjeKnjige;
	    
    public Biblioteka(String id2, String naziv2, String adresa2, String telefon2, String radnoVreme2) {
    	this.id = id2;
		this.naziv = naziv2;
		this.adresa = adresa2;
		this.telefon = telefon2;
		this.radnoVreme = radnoVreme2;
		
		this.biblioteke = new ArrayList<Biblioteka>();
		this.knjige = new ArrayList<Knjiga>();
		this.primerakKnjiga = new ArrayList<PrimerakKnjige>();
		this.tipoviClanarine = new ArrayList<TipClanarine>();
		this.zanroviKnjiga = new ArrayList<ZanrKnjige>();
		this.administratori = new ArrayList<Administrator>();
		this.sviZaposleni = new ArrayList<Zaposleni>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanoviBiblioteke = new ArrayList<ClanBiblioteke>();
		this.iznajmljivanjeKnjige = new ArrayList<IznajmljivanjeKnjige>();
    }
       
	
	public Biblioteka(String id, String naziv, String adresa, String telefon, String radnoVreme,
		 ArrayList<Knjiga> knjige, ArrayList<PrimerakKnjige> primerakKnjiga,
			ArrayList<TipClanarine> tipoviClanarine, ArrayList<ZanrKnjige> zanroviKnjiga,
			ArrayList<Zaposleni> sviZaposleni, ArrayList <Administrator> administratori,  ArrayList<Bibliotekar> bibliotekari,
			ArrayList<ClanBiblioteke> clanoviBiblioteke, ArrayList<IznajmljivanjeKnjige> iznajmljivanjeKnjiges, ArrayList<Biblioteka> biblioteke) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.biblioteke = biblioteke;
		this.knjige = knjige;
		this.primerakKnjiga = primerakKnjiga;
		this.tipoviClanarine = tipoviClanarine;
		this.zanroviKnjiga = zanroviKnjiga;
		this.administratori = administratori;
		this.bibliotekari = bibliotekari;
		this.sviZaposleni = sviZaposleni;
		this.clanoviBiblioteke = clanoviBiblioteke;
		this.iznajmljivanjeKnjige = iznajmljivanjeKnjiges;
	}


	public Biblioteka() {
		// TODO Auto-generated constructor stub
		this.biblioteke = new ArrayList<Biblioteka>();
		this.knjige = new ArrayList<Knjiga>();
		this.primerakKnjiga = new ArrayList<PrimerakKnjige>();
		this.tipoviClanarine = new ArrayList<TipClanarine>();
		this.zanroviKnjiga = new ArrayList<ZanrKnjige>();
		this.administratori = new ArrayList<Administrator>();
		this.sviZaposleni = new ArrayList<Zaposleni>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanoviBiblioteke = new ArrayList<ClanBiblioteke>();
		this.iznajmljivanjeKnjige = new ArrayList<IznajmljivanjeKnjige>();
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getRadnoVreme() {
		return radnoVreme;
	}
	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	////////////////////////////////////////////////////////////////
	public ArrayList<Biblioteka> getBiblioteke() {
		return biblioteke;
	}


	public void setBiblioteke(ArrayList<Biblioteka> biblioteke) {
		this.biblioteke = biblioteke;
	}


	public ArrayList<PrimerakKnjige> getPrimerakKnjiga() {
		return primerakKnjiga;
	}


	public void setPrimerakKnjiga(ArrayList<PrimerakKnjige> primerakKnjiga) {
		this.primerakKnjiga = primerakKnjiga;
	}


	public ArrayList<TipClanarine> getTipoviClanarine() {
		return tipoviClanarine;
	}


	public void setTipoviClanarine(ArrayList<TipClanarine> tipoviClanarine) {
		this.tipoviClanarine = tipoviClanarine;
	}


	public ArrayList<ZanrKnjige> getZanroviKnjiga() {
		return zanroviKnjiga;
	}


	public void setZanroviKnjiga(ArrayList<ZanrKnjige> zanroviKnjiga) {
		this.zanroviKnjiga = zanroviKnjiga;
	}

	public ArrayList<Administrator> getAdministratori() {
		return administratori;
	}


	public void setAdministratori(ArrayList<Administrator> administratori) {
		this.administratori = administratori;
	}
	
	
	
	public ArrayList<Zaposleni> getZaposleni() {
		return sviZaposleni;
	}


	public void setZaposleni(ArrayList<Zaposleni> zaposleni) {
		this.sviZaposleni = zaposleni;
	}

	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}


	public void setBibliotekari(ArrayList<Bibliotekar> bibliotekari) {
		this.bibliotekari = bibliotekari;
	}


	public ArrayList<ClanBiblioteke> getClanoviBiblioteke() {
		return clanoviBiblioteke;
	}


	public void setClanoviBiblioteke(ArrayList<ClanBiblioteke> clanoviBiblioteke) {
		this.clanoviBiblioteke = clanoviBiblioteke;
	}


	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}


	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}


	public ArrayList<IznajmljivanjeKnjige> getIznajmljivanjeKnjige() {
		return iznajmljivanjeKnjige;
	}


	public void setIznajmljivanjeKnjige(ArrayList<IznajmljivanjeKnjige> iznajmljivanjeKnjige) {
		this.iznajmljivanjeKnjige = iznajmljivanjeKnjige;
	}


	@Override
	public String toString() {
		return "Biblioteka \nid=" + id + "\nnaziv=" + naziv + "\nadresa=" + adresa + "\ntelefon=" + telefon
				+ "\nradnoVreme=" + radnoVreme  +  "\nknjige="
				+ knjige + "\nprimerakKnjiga=" + primerakKnjiga + "\ntipoviClanarine=" + tipoviClanarine
				+ "\nzanroviKnjiga=" + zanroviKnjiga + "\nadministratori=" + administratori + "\nbibliotekari="
				+ bibliotekari +  "\nzaposleni=" + sviZaposleni + "\nclanoviBiblioteke=" + clanoviBiblioteke+ "\niznajmljivanje=" + iznajmljivanjeKnjige;
	}
	
	
	
	//ADMINISTRATOR

	public void upisiAdministratora(String administratorFajl) {
		try {
			File file = new File(administratorFajl);
			String content = "";
			for (Administrator administrator : administratori) {
				
				content += administrator.getKorisnickoIme() + "|" + administrator.getKorisnickaLozinka() + "|"
						+ administrator.getPlata() + "|" + administrator.getId() +
						"|" + administrator.getImeIPrezime() + "|" +
						administrator.getJMBG() + "|" + administrator.getAdresa() + "|"
								+ administrator.getPol() + "|"
						+ administrator.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja administratora.");
		}
	}
	
		public void ucitajAdministratora(String administratorFajl) {
			try {
				
				File file = new File(administratorFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					String korisnickoIme= split[0];
					String korisnickaLozinka= split[1];
					double plata = Double.parseDouble(split[2]);
					String id = split[3];
					String imePrezime = split[4];
					String JMBG = split[5];
					String adresa = split[6];
					String pol = split[7];
					EnumPol pol1 = EnumPol.ZENSKI;
					for (EnumPol j: EnumPol.values()) {
						if(j.name().equalsIgnoreCase(pol)){
							pol1 = j;
						}
					}
					Boolean obrisan = Boolean.parseBoolean(split[8]);
					Administrator admin = new Administrator(korisnickoIme,korisnickaLozinka,plata,id,imePrezime,JMBG,adresa,pol1,obrisan);
					administratori.add(admin);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o administratoru");
				e.printStackTrace();
			}
		}


		

//BIBLIOTEKAR


	public void upisiBibliotekara(String bibliotekarFajl) {
		try {
			File file = new File(bibliotekarFajl);
			String content = "";
			for (Bibliotekar bibliotekar : bibliotekari) {
				content += bibliotekar.getKorisnickoIme() + "|" + bibliotekar.getKorisnickaLozinka() + "|"
						+ bibliotekar.getPlata() + "|" + bibliotekar.getId() +
						"|" + bibliotekar.getImeIPrezime() + "|" +
						bibliotekar.getJMBG() + "|" + bibliotekar.getAdresa() + "|"
								+ bibliotekar.getPol() + "|"
						+ bibliotekar.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja bibliotekara.");
		}
	}

	public void ucitajBibliotekara(String bibliotekarFajl) {
		try {
			
			File file = new File(bibliotekarFajl);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String korisnickoIme= split[0];
				String korisnickaLozinka= split[1];
				double plata = Double.parseDouble(split[2]);
				String id = split[3];
				String imePrezime = split[4];
				String JMBG = split[5];
				String adresa = split[6];
				String pol = split[7];
				EnumPol pol1 = EnumPol.ZENSKI;
				for (EnumPol j: EnumPol.values()) {
					if(j.name().equalsIgnoreCase(pol)){
						pol1 = j;
					}
				}
				Boolean obrisan = Boolean.parseBoolean(split[8]);
				Bibliotekar bibl = new Bibliotekar(korisnickoIme,korisnickaLozinka,plata,id,imePrezime,JMBG,adresa,pol1,obrisan);
				bibliotekari.add(bibl);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja podataka o bibliotekaru");
			e.printStackTrace();
		}
	}



//ZANR 

	public void upisiZanrKnjige(String zanrKnjigeFajl) {
		try {
			File file = new File(zanrKnjigeFajl);
			String content = "";
			for (ZanrKnjige zanrKnjige : zanroviKnjiga) {	
				content += zanrKnjige.getId() + "|" + zanrKnjige.getOznaka() + "|"
						+ zanrKnjige.getOpis() + "|" + zanrKnjige.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja zanrova.");
		}
	}
	
		public void ucitajZanrKnjige(String zanrKnjigeFajl) {
			try {
				File file = new File(zanrKnjigeFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					String id= split[0];
					String oznaka= split[1];
					String opis = split[2];
					Boolean obrisan = Boolean.parseBoolean(split[3]);
					
					ZanrKnjige zanr = new ZanrKnjige(id,oznaka,opis,obrisan);
					zanroviKnjiga.add(zanr);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o zanru");
				e.printStackTrace();
			}
		}

		


//PRIMERAK KNJIGE
	public void upisiPrimerakKnjige(String primerakKnjigeFajl) {
		try {
			File file = new File(primerakKnjigeFajl);
			String content = "";
			for (PrimerakKnjige primerakKnjige : primerakKnjiga) {	
				content += primerakKnjige.getId() + "|" + primerakKnjige.getKnjiga().getId() + "|"
						+ primerakKnjige.getBrojStrana() + "|" + primerakKnjige.getTipPoveza() 
						 + "|" + primerakKnjige.getJezik()  + "|" + primerakKnjige.getGodinaStampanja() 
						 + "|" + primerakKnjige.isIznajmljena() + "|" + primerakKnjige.isObrisan() +"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja primerka knjige.");
		}
	}
	
		public void ucitajPrimerakKnjige(String primerakKnjigeFajl) {
			try {
				File file = new File(primerakKnjigeFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					String id= split[0];
					
					Knjiga knjig = null;
					for (Knjiga t : knjige) {
						if(t.getId().equals(split[1])) {
							knjig = t;
						}
					}
					
					int brojStrana = Integer.parseInt(split[2]);
					String povez = split[3];
					EnumTipPoveza povezz = EnumTipPoveza.MEK;
					for (EnumTipPoveza j: EnumTipPoveza.values()) {
						if(j.name().equalsIgnoreCase(povez)){
							povezz = j;
						}
					}
					String jezik = split[4];
					EnumJezik jezikk = EnumJezik.ENGLESKI;
					for (EnumJezik j: EnumJezik.values()) {
						if(j.name().equalsIgnoreCase(jezik)){
							jezikk = j;
						}
					}
					int godinaStampanja= Integer.parseInt(split[5]);
					Boolean iznajmljena = Boolean.parseBoolean(split[6]);
					Boolean obrisan = Boolean.parseBoolean(split[7]);
					
					PrimerakKnjige primerak = new PrimerakKnjige(id,knjig,brojStrana,povezz,jezikk,godinaStampanja, iznajmljena, obrisan);
					primerakKnjiga.add(primerak);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o primerku knjige");
				e.printStackTrace();
			}
		}
	
	
//KNJIGA
		public void upisiKnjige(String knjigeFajl) {
			try {
				File file = new File(knjigeFajl);
				String content = "";
				for (Knjiga knjiga : knjige) {
					content += knjiga.getId() + "|" + knjiga.getNaslovKnjige() + "|"
							+ knjiga.getOriginalniNaslovKnjige() + "|" + knjiga.getPisac() +
							"|" + knjiga.getGodinaObjavljivanja() + "|" +
							knjiga.getOpis() + "|" + knjiga.getJezik() + "|"
							+ knjiga.isObrisan() + "|"+ knjiga.getZanr().getId()+ "\n" ;
				}
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja knjiga.");
			}
		}

		public void ucitajKnjige(String knjigeFajl) {
			try {
				File file = new File(knjigeFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					
					String id = split[0];
					String naslovKnjige = split[1];
					String originalniNaslovKnjige = split[2];
					String pisac = split[3];
					int godinaObjavljivanja = Integer.parseInt(split[4]);
					String opis = split[5];
					String jezik = split[6];
					EnumJezik jezikk = EnumJezik.ENGLESKI;
					for (EnumJezik j: EnumJezik.values()) {
						if(j.name().equalsIgnoreCase(jezik)){
							jezikk = j;
						}
					}
					boolean obrisan = Boolean.parseBoolean(split[7]);
					ZanrKnjige zanr = null;
					for(ZanrKnjige z : zanroviKnjiga){
						if(z.getId().equals(split[8])){
							zanr = z;
						}
				}
					Knjiga knjiga = new Knjiga(id, naslovKnjige, originalniNaslovKnjige, pisac, godinaObjavljivanja, opis, jezikk, obrisan, zanr);
					knjige.add(knjiga);
				}
				reader.close();
				
				}catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o knjigama");
				e.printStackTrace();
			}
		}
    
		

	// TIP CLANARINE 
		public void upisiTipClanarine(String tipClanarineFajl) {
			try {
				File file = new File(tipClanarineFajl);
				String content = "";
				for (TipClanarine tipClanarine : tipoviClanarine) {	
					content += tipClanarine.getId() + "|" + tipClanarine.getNaziv() + "|"
							+ tipClanarine.getCena() + "|" + tipClanarine.isObrisan() + "\n";
				}
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja clanarine.");
			}
		}
		
			public void ucitajTipClanarine(String tipClanarineFajl) {
				try {
					File file = new File(tipClanarineFajl);
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;
					while ((line = reader.readLine()) != null) {
						String[] split = line.split("\\|");
						String id= split[0];
						String naziv= split[1];
						double cena = Double.parseDouble(split[2]);
						Boolean obrisan = Boolean.parseBoolean(split[3]);
						
						TipClanarine tip = new TipClanarine(id,naziv, cena, obrisan);
						tipoviClanarine.add(tip);
						
					}
					reader.close();
				} catch (IOException e) {
					System.out.println("Greska prilikom snimanja podataka o clanarini");
					e.printStackTrace();
				}
			}
			
				
	//CLAN BIBLIOTEKE 
	public void proveriAktivnost(ClanBiblioteke clanBiblioteke) {
		LocalDate datumPoslednjeUplate = clanBiblioteke.getDatumPoslednjeUplate();
		int brojMeseciClanarine =  clanBiblioteke.getBrojMeseciClanarine();
		LocalDate provera = datumPoslednjeUplate.plusMonths(brojMeseciClanarine);
		clanBiblioteke.setAktivan(provera.isAfter(LocalDate.now()));
	}
	
	
	public void upisiClanBiblioteke(String clanBibliotekeFajl) {
		try {
			File file = new File(clanBibliotekeFajl);
			String content = "";
			for (ClanBiblioteke clanBiblioteke :clanoviBiblioteke) {	
				content += clanBiblioteke.getBrojClanskeKarte() + "|" + clanBiblioteke.getDatumPoslednjeUplate() + "|"
						+ clanBiblioteke.getBrojMeseciClanarine() + "|"+ clanBiblioteke.isAktivan() + "|" 
						+ clanBiblioteke.getId() + "|" + clanBiblioteke.getImeIPrezime() + "|" + 
						 clanBiblioteke.getJMBG() + "|" +  clanBiblioteke.getAdresa() + "|" +
						 clanBiblioteke.getPol() + "|"  + clanBiblioteke.isObrisan() + "|" + clanBiblioteke.getTipClanarine().getId() + "\n";
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja clanova.");
		}
	}
		public void ucitajClanBiblioteke(String clanBibliotekeFajl) {
			try {
				File file = new File(clanBibliotekeFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					String brojClanskeKarte= split[0];
					LocalDate datumPoslednjeUplate= LocalDate.parse(split[1]);
					int brojMeseciClanarine = Integer.parseInt(split[2]);
					Boolean aktivan = Boolean.parseBoolean(split[3]);
					String id = split[4];
					String imeIPrezime = split[5];
					String JMBG = split[6];
					String adresa = split[7];
					String pol = split[8];
					EnumPol pol1 = EnumPol.ZENSKI;
					for (EnumPol j: EnumPol.values()) {
						if(j.name().equalsIgnoreCase(pol)){
							pol1 = j;
						}
					}
					Boolean obrisan = Boolean.parseBoolean(split[9]);
					
					TipClanarine tip = null;
					for (TipClanarine t : tipoviClanarine) {
						if(t.getId().equals(split[10])) {
							tip = t;
						}
					}
					
					ClanBiblioteke clan = new ClanBiblioteke(brojClanskeKarte,datumPoslednjeUplate, brojMeseciClanarine,aktivan,id,imeIPrezime, JMBG,adresa, pol1, obrisan,tip);
					this.proveriAktivnost(clan);
					clanoviBiblioteke.add(clan);
				}
				reader.close();
				} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o clanu");
				e.printStackTrace();
			}
		}
	
	//IZNAJMLJIVANJE KNJIGE
	public void upisiIznajmljivanjeKnjige(String iznajmljivanjeKnjigeFajl) {
		try {
			File file = new File(iznajmljivanjeKnjigeFajl);
			String content = "";
			for (IznajmljivanjeKnjige iznajmljivanjeKnjige : iznajmljivanjeKnjige) {	
				content += iznajmljivanjeKnjige.getId() + "|" + iznajmljivanjeKnjige.getDatumIznajmljivanja() + "|" + iznajmljivanjeKnjige.getDatumVracanja() + "|"
				+ iznajmljivanjeKnjige.isObrisan() + "|" + iznajmljivanjeKnjige.getPrimerak().getId() +
						 "|" + iznajmljivanjeKnjige.getClan().getId() + "|" + iznajmljivanjeKnjige.getAdministrator().getId() + "|" 
						+ iznajmljivanjeKnjige.getBibliotekar().getId() +"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja iznajmljivanja.");
		}
	}
	
		public void ucitajIznajmljivanjeKnjige(String iznajmljivanjeKnjigeFajl) {
			try {
				File file = new File(iznajmljivanjeKnjigeFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					String id = split[0];
					LocalDate  datumIznajmljivanja = LocalDate.parse( split[1]);
					LocalDate  datumVracanja = LocalDate.parse( split[2]);
					Boolean obrisan = Boolean.parseBoolean(split[3]);
					
					PrimerakKnjige primerak1 = null;
					for (PrimerakKnjige p : primerakKnjiga) {
						if(p.getId().equals(split[4])) {
							primerak1 = p;
						}
					}
					
					ClanBiblioteke clan1 = null;
					for (ClanBiblioteke t : clanoviBiblioteke) {
						if(t.getId().equals(split[5])) {
							clan1 = t;
						}
					}
				
					Administrator admin = null;
					for (Administrator a : administratori) {
						if(a.getId().equals(split[6])) {
							admin = a;
						}
					}
					
					Bibliotekar bibl = null;
					for (Bibliotekar a : bibliotekari) {
						if(a.getId().equals(split[7])) {
							bibl = a;
						}
					}
					IznajmljivanjeKnjige iznaj = new IznajmljivanjeKnjige(id,datumIznajmljivanja,datumVracanja, obrisan, primerak1, clan1,  admin, bibl);
					iznajmljivanjeKnjige.add(iznaj);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o iznajmljivanju");
				e.printStackTrace();
			}
		}
	
	//BIBLIOTEKA 
	public void upisiBiblioteka(String bibliotekaFajl) {
		try {
			File file = new File(bibliotekaFajl);
			String content = "";
			for (Biblioteka biblioteka : biblioteke) {	
				content += biblioteka.getId() + "|"+ biblioteka.getNaziv()+ "|" + biblioteka.getAdresa()+ "|"
			+ biblioteka.getTelefon()+ "|"+biblioteka.getRadnoVreme()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja biblioteke.");
		}
	}
	
		public void ucitajBiblioteka(String bibliotekaFajl) {
			try {
				File file = new File(bibliotekaFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					String id= split[0];
					String naziv= split[1];
					String adresa = split[2];
					String telefon = split[3];
					String radnoVreme = split[4];
					
					Biblioteka bibliotek = new Biblioteka(id,naziv, adresa, telefon, radnoVreme);
					biblioteke.add(bibliotek);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o biblioteci");
				e.printStackTrace();
			}
		}
//LOGIN
		public Zaposleni login(String korisnickoIme, String korisnickaLozinka) {
			for (Administrator administrator : administratori) {
				if(administrator.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
						administrator.getKorisnickaLozinka().equals(korisnickaLozinka) && !administrator.isObrisan()) {
					return administrator;
				}
			
			}
			for (Bibliotekar bibliotekar : bibliotekari) {
				if(bibliotekar.getKorisnickoIme().equalsIgnoreCase(korisnickoIme)&& bibliotekar.getKorisnickaLozinka().equals(korisnickaLozinka) && 
						!bibliotekar.isObrisan()) {
					return bibliotekar;
				}
			}
			return null;
		}
// CRUD ..........................................................................	

		
		public void dodajAdministratora(Administrator administrator) {
			this.administratori.add(administrator);
		}
		public void dodajBibliotekara(Bibliotekar bibliotekar) {
			this.bibliotekari.add(bibliotekar);
		}
		public void dodajBiblioteku(Biblioteka biblioteka) {
			this.biblioteke.add(biblioteka);
		}
		public void dodajClana(ClanBiblioteke clanBiblioteke) {
			this.clanoviBiblioteke.add(clanBiblioteke);
		}
		public void dodajIznajmljivanje(IznajmljivanjeKnjige iznajmljivanjeKnjige) {
			this.iznajmljivanjeKnjige.add(iznajmljivanjeKnjige);
		}
		public void dodajKnjigu(Knjiga knjiga) {
			this.knjige.add(knjiga);
		}
		public void dodajPrimerak(PrimerakKnjige primerakKnjige) {
			this.primerakKnjiga.add(primerakKnjige);
		}
		public void dodajClanarinu(TipClanarine tipClanarine) {
			this.tipoviClanarine.add(tipClanarine);
		}
		public void dodajZanr(ZanrKnjige zanrKnjige) {
			this.zanroviKnjiga.add(zanrKnjige);
		}

		public void obrisiAdministratora(Administrator administrator) {
			this.administratori.remove(administrator); 
			
		}
		public void obrisiBibliotekara(Bibliotekar bibliotekar) {
			this.bibliotekari.remove(bibliotekar); 
			
		}
		public void obrisiBiblioteku(Biblioteka biblioteka) {
			this.biblioteke.remove(biblioteka); 
			
		}
		public void obrisiClana(ClanBiblioteke clanBiblioteke) {
			this.clanoviBiblioteke.remove(clanBiblioteke); 
			
		}
		public void obrisiIznajmljivanje(IznajmljivanjeKnjige iznajmljivanjeKnjige) {
			this.iznajmljivanjeKnjige.remove(iznajmljivanjeKnjige); 
			
		}
		public void obrisiKnjigu(Knjiga knjiga) {
			this.knjige.remove(knjiga); 
			
		}
		public void obrisiPrimerak(PrimerakKnjige primerakKnjige) {
			this.primerakKnjiga.remove(primerakKnjige); 
			
		}
		public void obrisiClanarinu(TipClanarine tipClanarine) {
			this.tipoviClanarine.remove(tipClanarine); 
			
		}
		public void obrisiZanr(ZanrKnjige zanrKnjige) {
			this.zanroviKnjiga.remove(zanrKnjige); 
			
		}
		public ArrayList<Administrator> sviNeobrisaniAdministratori() {
			ArrayList<Administrator> neobrisani = new ArrayList<Administrator>();
			for (Administrator administrator : administratori) {
				if(!administrator.isObrisan()) {
					neobrisani.add(administrator);
				}
			}
			return neobrisani;
		}
		public ArrayList<Bibliotekar> sviNeobrisaniBibliotekari() {
			ArrayList<Bibliotekar> neobrisani = new ArrayList<Bibliotekar>();
			for (Bibliotekar bibliotekar : bibliotekari) {
				if(!bibliotekar.isObrisan()) {
					neobrisani.add(bibliotekar);
				}
			}
			return neobrisani;
		}
		public ArrayList<ZanrKnjige> sviNeobrisaniZanr() {
			ArrayList<ZanrKnjige> neobrisani = new ArrayList<ZanrKnjige>();
			for (ZanrKnjige zanrKnjige : zanroviKnjiga) {
				if(!zanrKnjige.isObrisan()) {
					neobrisani.add(zanrKnjige);
				}
			}
			return neobrisani;
		}
		public ArrayList<Biblioteka> sviNeobrisaniBiblioteka() {
			ArrayList<Biblioteka> neobrisani = new ArrayList<Biblioteka>();
			for (Biblioteka biblioteka : biblioteke) {
					neobrisani.add(biblioteka);
				}
			return neobrisani;
		}
		
		public ArrayList<TipClanarine> sviNeobrisaniClanarina() {
			ArrayList<TipClanarine> neobrisani = new ArrayList<TipClanarine>();
			for (TipClanarine tipClanarine : tipoviClanarine) {
				if(!tipClanarine.isObrisan()) {
					neobrisani.add(tipClanarine);
				}
			}
			return neobrisani;
		}
		public ArrayList<ClanBiblioteke> sviNeobrisaniClanovi() {
			ArrayList<ClanBiblioteke> neobrisani = new ArrayList<ClanBiblioteke>();
			for (ClanBiblioteke clanBiblioteke : clanoviBiblioteke) {
				if(!clanBiblioteke.isObrisan()) {
					neobrisani.add(clanBiblioteke);
				}
			}
			return neobrisani;
		}

		public ArrayList<Knjiga> sviNeobrisaniKnjiga() {
			ArrayList<Knjiga> neobrisani = new ArrayList<Knjiga>();
			for (Knjiga knjiga : knjige) {
				if(!knjiga.isObrisan()) {
					neobrisani.add(knjiga);
				}
			}
			return neobrisani;
		}
		public ArrayList<PrimerakKnjige> sviNeobrisaniPrimerak() {
			ArrayList<PrimerakKnjige> neobrisani = new ArrayList<PrimerakKnjige>();
			for (PrimerakKnjige primerakKnjige : primerakKnjiga) {
				if(!primerakKnjige.isObrisan()) {
					neobrisani.add(primerakKnjige);
				}
			}
			return neobrisani;
		}
	
		public ArrayList<IznajmljivanjeKnjige> sviNeobrisaniIznajmljivanje() {
			ArrayList<IznajmljivanjeKnjige> neobrisani = new ArrayList<IznajmljivanjeKnjige>();
		for (IznajmljivanjeKnjige iznajmljivanjeKnjige : iznajmljivanjeKnjige) {
			if(!iznajmljivanjeKnjige.isObrisan()) {
				neobrisani.add(iznajmljivanjeKnjige);
			}
		}
		return neobrisani;
	} 
	
		
		public Administrator nadjiAdministratora(String id) {
			for (Administrator administrator : administratori) {
				if (administrator.getId().equals(id)) {
					return administrator;
				}
			}
			return null;
		}
		public Bibliotekar nadjiBibliotekara(String id) {
			for (Bibliotekar bibliotekar : bibliotekari) {
				if (bibliotekar.getId().equals(id)) {
					return bibliotekar;
				}
			}
			return null;
		}
		public Biblioteka nadjiBiblioteku(String Id) {
			for (Biblioteka biblioteka : biblioteke) {
				if (biblioteka.getId().equals(Id)) {
					return biblioteka;
				}
			}
			return null;
		}
		public ClanBiblioteke nadjiClanove(String Id) {
			for (ClanBiblioteke clanBiblioteke : clanoviBiblioteke) {
				if (clanBiblioteke.getId().equals(Id)) {
					return clanBiblioteke;
				}
			}
			return null;
		}
		public IznajmljivanjeKnjige nadjiIznajmljivanje(String Id) {
			for (IznajmljivanjeKnjige iznajmljivanjeKnjige : iznajmljivanjeKnjige) {
				if (iznajmljivanjeKnjige.getId().equals(Id)) {
					return iznajmljivanjeKnjige;
				}
			}
			return null;
		}
		public Knjiga nadjiKnjigu(String Id) {
			for (Knjiga knjiga : knjige) {
				if (knjiga.getId().equals(Id)) {
					return knjiga;
				}
			}
			return null;
		}
		public PrimerakKnjige nadjiPrimerak(String Id) {
			for (PrimerakKnjige primerakKnjige : primerakKnjiga) {
				if (primerakKnjige.getId().equals(Id)) {
					return primerakKnjige;
				}
			}
			return null;
		}
		public TipClanarine nadjiClanarinu(String Id) {
			for (TipClanarine tipClanarine : tipoviClanarine) {
				if (tipClanarine.getId().equals(Id)) {
					return tipClanarine;
				}
			}
			return null;
		}
		public ZanrKnjige nadjiZanr(String Id) {
			for (ZanrKnjige zanrKnjige : zanroviKnjiga) {
				if (zanrKnjige.getId().equals(Id)) {
					return zanrKnjige;
				}
			}
			return null;
		}
		
}





