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
	//ZAPOSLENI
	public void upisiZaposleni(ArrayList<Zaposleni> sviZaposleni) {
		try {
			File file = new File("fajlovi/zaposleni.txt");
			String content = "";
			for (Zaposleni zaposleni : sviZaposleni) {
				
				content += zaposleni.getKorisnickoIme() + "|" + zaposleni.getKorisnickaLozinka() + "|"
						+ zaposleni.getPlata() + "|" + zaposleni.getId() +
						"|" + zaposleni.getImeIPrezime() + "|" +
						zaposleni.getJMBG() + "|" + zaposleni.getAdresa() + "|"
								+ zaposleni.getPol() + "|"
						+ zaposleni.isObrisan() + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja zaposlenih.");
		}
	}
	
//		public ArrayList<Zaposleni> ucitajZaposleni(String zaposleniFajl) {
//			ArrayList<Zaposleni> sviZaposleni = new ArrayList<Zaposleni>();
//			try {
//				
//				File file = new File(zaposleniFajl);
//				BufferedReader reader = new BufferedReader(new FileReader(file));
//				String line;
//				while ((line = reader.readLine()) != null) {
//					String[] split = line.split("\\|");
//					String korisnickoIme= split[0];
//					String korisnickaLozinka= split[1];
//					double plata = Double.parseDouble(split[2]);
//					String id = split[3];
//					String imePrezime = split[4];
//					String JMBG = split[5];
//					String adresa = split[6];
//					String pol = split[7];
//					EnumPol pol1 = EnumPol.ZENSKI;
//					for (EnumPol j: EnumPol.values()) {
//						if(j.name().equalsIgnoreCase(pol)){
//							pol1 = j;
//						}
//					}
//					Boolean obrisan = Boolean.parseBoolean(split[8]);
//					Zaposleni zaposl = new Zaposleni(korisnickoIme,korisnickaLozinka,plata,id,imePrezime,JMBG,adresa,pol1,obrisan);
//					sviZaposleni.add(zaposl);
//					
//				}
//				reader.close();
//			} catch (IOException e) {
//				System.out.println("Greska prilikom snimanja podataka o administratoru");
//				e.printStackTrace();
//			}
//			return sviZaposleni;
//		}
	
	//ADMINISTRATOR

	public void upisiAdministratora(ArrayList<Administrator> sviAdmini) {
		try {
			File file = new File("fajlovi/administratori.txt");
			String content = "";
			for (Administrator administrator : sviAdmini) {
				
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
					System.out.println(administratori);
					administratori.add(admin);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o administratoru");
				e.printStackTrace();
			}
		}

//		public void dodajAdministratora(String korisnickoIme, String korisnickaLozinka, double plata, String id, String imeIPrezime,
//			String JMBG, String adresa, EnumPol pol, boolean obrisan) {
//			ArrayList<Administrator> sviAdministratori = new ArrayList<Administrator>();
//			
//			Administrator administrator = new Administrator();
//			administrator.setKorisnickoIme(korisnickoIme);
//			administrator.setKorisnickaLozinka(korisnickaLozinka);
//			
//			sviAdministratori.add(administrator);
//			Biblioteka.upisiAdministratora(sviAdministratori,"fajlovi/administratori.txt");
//				
//		}
		

//BIBLIOTEKAR


	public void upisiBibliotekara(ArrayList<Bibliotekar> sviBibliotekari) {
		try {
			File file = new File("fajlovi/bibliotekar.txt");
			String content = "";
			for (Bibliotekar bibliotekar : sviBibliotekari) {
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

	public void upisiZanrKnjige(ArrayList<ZanrKnjige> sviZanrovi) {
		try {
			File file = new File("fajlovi/zanr.txt");
			String content = "";
			for (ZanrKnjige zanrKnjige : sviZanrovi) {	
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
	
		public ArrayList<ZanrKnjige> ucitajZanrKnjige(String zanrKnjigeFajl) {
			ArrayList<ZanrKnjige> zanrKnjige = new ArrayList<ZanrKnjige>();
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
					zanrKnjige.add(zanr);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o zanru");
				e.printStackTrace();
			}
			return zanrKnjige;
		}

		


//PRIMERAK KNJIGE
	public void upisiPrimerakKnjige(ArrayList<PrimerakKnjige> sviPrimerci) {
		try {
			File file = new File("fajlovi/primerakKnjige.txt");
			String content = "";
			for (PrimerakKnjige primerakKnjige : sviPrimerci) {	
				content += primerakKnjige.getId() + "|" + primerakKnjige.getNazivKnjige().getId() + "|"
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
	
		public ArrayList<PrimerakKnjige> ucitajPrimerakKnjige(String primerakKnjigeFajl) {
			ArrayList<PrimerakKnjige> primerakKnjige = new ArrayList<PrimerakKnjige>();
			try {
				File file = new File(primerakKnjigeFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					String id= split[0];
					ArrayList<Knjiga> knjige1 = ucitajKnjige("fajlovi/knjige.txt");
					Knjiga knjigeE = null;
					for (Knjiga j : knjige1) {
						if(j.getId().equals(split[1])) {
							knjigeE = j;
						}}
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
					LocalDate godinaStampanja= LocalDate.parse(split[5]);
					Boolean iznajmljena = Boolean.parseBoolean(split[6]);
					Boolean obrisan = Boolean.parseBoolean(split[7]);
					
					PrimerakKnjige primerak = new PrimerakKnjige(id,knjigeE,brojStrana,povezz,jezikk,godinaStampanja, iznajmljena, obrisan);
					primerakKnjige.add(primerak);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o primerku knjige");
				e.printStackTrace();
			}
			return primerakKnjige;
		}
	
	
//KNJIGA
		public void upisiKnjige(ArrayList<Knjiga> sveKnjige) {
			try {
				File file = new File("fajlovi/knjige.txt");
				String content = "";
				for (Knjiga knjiga : sveKnjige) {
					content += knjiga.getId() + "|" + knjiga.getNaslovKnjige() + "|"
							+ knjiga.getOriginalniNaslovKnjige() + "|" + knjiga.getPisac() +
							"|" + knjiga.getGodinaObjavljivanja() + "|" +
							knjiga.getOpis() + "|" + knjiga.getJezik() + "|"
							+ knjiga.isObrisan() + "|"+ knjiga.getZanr().getId() ;
				}
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja knjiga.");
			}
		}

		public ArrayList<Knjiga> ucitajKnjige(String knjigeFajl) {
			ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
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
					ArrayList<ZanrKnjige> zanrovi = ucitajZanrKnjige("fajlovi/zanr.txt");
					ZanrKnjige zanrE = null;
					for (ZanrKnjige j : zanrovi) {
						if(j.getId().equals(split[8])) {
							zanrE = j;
						}}
					Knjiga knjiga = new Knjiga(id, naslovKnjige, originalniNaslovKnjige, pisac, godinaObjavljivanja, opis, jezikk, obrisan, zanrE);
					knjige.add(knjiga);
				}
				reader.close();
				
				}catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o knjigama");
				e.printStackTrace();
			}
			return knjige;
		}
    
		

	// TIP CLANARINE 
		public void upisiTipClanarine(ArrayList<TipClanarine> sviTipovi) {
			try {
				File file = new File("fajlovi/tipClanarine.txt");
				String content = "";
				for (TipClanarine tipClanarine : sviTipovi) {	
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
		
			public ArrayList<TipClanarine> ucitajTipClanarine(String tipClanarineFajl) {
				ArrayList<TipClanarine> tipClanarine = new ArrayList<TipClanarine>();
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
						tipClanarine.add(tip);
						
					}
					reader.close();
				} catch (IOException e) {
					System.out.println("Greska prilikom snimanja podataka o zanru");
					e.printStackTrace();
				}
				return tipClanarine;
			}
			
				
	//CLAN BIBLIOTEKE 
	public void upisiClanBiblioteke(ArrayList<ClanBiblioteke> sviClanovi) {
		try {
			File file = new File("fajlovi/clanBiblioteke.txt");
			String content = "";
			for (ClanBiblioteke clanBiblioteke :sviClanovi) {	
				content += clanBiblioteke.getBrojClanskeKarte() + "|" + clanBiblioteke.getDatumPoslednjeUplate() + "|"
						+ clanBiblioteke.getBrojMeseciClanarine() + "|"+ clanBiblioteke.isAktivan() + "|" 
						+ clanBiblioteke.getId() + "|" + clanBiblioteke.getImeIPrezime() + "|" + 
						 clanBiblioteke.getJMBG() + "|" +  clanBiblioteke.getAdresa() + "|" +
						 clanBiblioteke.getPol() + "|"  + clanBiblioteke.isObrisan() + "|" + clanBiblioteke.getTipclanarine().getId()  + "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja clanova.");
		}
	}
		public ArrayList<ClanBiblioteke> ucitajClanBiblioteke(String clanBibliotekeFajl) {
			ArrayList<ClanBiblioteke> clanBiblioteke = new ArrayList<ClanBiblioteke>();
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
					ArrayList<TipClanarine> tip = ucitajTipClanarine("fajlovi/tipClanarine.txt");
					TipClanarine tip1 = null;
					for (TipClanarine t : tip) {
						if(t.getId().equals(split[10])) {
							tip1 = t;
						}
					}
					ClanBiblioteke clan = new ClanBiblioteke(brojClanskeKarte,datumPoslednjeUplate, brojMeseciClanarine,aktivan,id,imeIPrezime, JMBG,adresa, pol1, obrisan,tip1);
					clanBiblioteke.add(clan);
				}
				reader.close();
				} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o clanu");
				e.printStackTrace();
			}
			return clanBiblioteke;
		}
	
	//IZNAJMLJIVANJE KNJIGE
	public void upisiIznajmljivanjeKnjige(ArrayList<IznajmljivanjeKnjige> sveIznajmljivanje) {
		try {
			File file = new File("fajlovi/iznajmljivanjeknjige.txt");
			String content = "";
			for (IznajmljivanjeKnjige iznajmljivanjeKnjige : sveIznajmljivanje) {	
				content += iznajmljivanjeKnjige.getDatumIznajmljivanja() + "|" + iznajmljivanjeKnjige.getDatumVracanja() + "|"
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
	
		public ArrayList<IznajmljivanjeKnjige> ucitajIznajmljivanjeKnjige(String iznajmljivanjeKnjigeFajl) {
			ArrayList<IznajmljivanjeKnjige> iznajmljivanjeKnjige = new ArrayList<IznajmljivanjeKnjige>();
			try {
				File file = new File(iznajmljivanjeKnjigeFajl);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					String[] split = line.split("\\|");
					LocalDate datumIznajmljivanja = LocalDate.parse(split[0]);
					LocalDate datumVracanja = LocalDate.parse(split[1]);
					Boolean obrisan = Boolean.parseBoolean(split[2]);
					
					ArrayList<PrimerakKnjige> primerci = ucitajPrimerakKnjige("fajlovi/primerakKnjige.txt");
					PrimerakKnjige primerak1 = null;
					for (PrimerakKnjige t : primerci) {
						if(t.getId().equals(split[3])) {
							primerak1 = t;
						}
					}
					
					ClanBiblioteke clan1 = null;
					for (ClanBiblioteke t : clanoviBiblioteke) {
						if(t.getId().equals(split[4])) {
							clan1 = t;
						}
					}
				
					Administrator admin = null;
					for (Administrator a : administratori) {
						if(a.getId().equals(split[5])) {
							admin = a;
						}
					}
					
					Bibliotekar bibl = null;
					for (Bibliotekar a : bibliotekari) {
						if(a.getId().equals(split[6])) {
							bibl = a;
						}
					}
					IznajmljivanjeKnjige iznaj = new IznajmljivanjeKnjige(datumIznajmljivanja,datumVracanja, obrisan, primerak1, clan1,  admin, bibl);
					iznajmljivanjeKnjige.add(iznaj);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o iznajmljivanju");
				e.printStackTrace();
			}
			return iznajmljivanjeKnjige;
		}
	
	//BIBLIOTEKA 
	public void upisiBiblioteka(ArrayList<Biblioteka> sveBiblioteke) {
		try {
			File file = new File("fajlovi/biblioteka.txt");
			String content = "";
			for (Biblioteka biblioteka : sveBiblioteke) {	
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
	
		public ArrayList<Biblioteka> ucitajBiblioteka(String bibliotekaFajl) {
			ArrayList<Biblioteka> biblioteka = new ArrayList<Biblioteka>();
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
					biblioteka.add(bibliotek);
					
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o biblioteci");
				e.printStackTrace();
			}
			return biblioteka;
		}

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
			
		
		
}





