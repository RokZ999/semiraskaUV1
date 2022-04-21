import java.io.Serializable;

public class Rezervacija implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String ime,uporabnik;
	private int st_odrashlih=0,st_otrok=0;

	
	@Override
	public String toString() {

		return String.format("Rezervacija za uporbnika %s rezervira mesta za st_odraslih: %d mest in st_otrok: %d mest.",uporabnik,st_odrashlih,st_otrok);
	}
	
	
	public Rezervacija(String ime, String uporabnik, int st_odrashlih, int st_otrok) {
		this.ime = ime;
		this.uporabnik = uporabnik;
		this.st_odrashlih = st_odrashlih;
		this.st_otrok = st_otrok;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(String uporabnik) {
		this.uporabnik = uporabnik;
	}

	public int getSt_odrashlih() {
		return st_odrashlih;
	}

	public void setSt_odrashlih(int st_odrashlih) {
		this.st_odrashlih = st_odrashlih;
	}

	public int getSt_otrok() {
		return st_otrok;
	}

	public void setSt_otrok(int st_otrok) {
		this.st_otrok = st_otrok;
	}
	
	
	
	
}
