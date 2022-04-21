import java.io.Serializable;

public class Uporabnik implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ime,priimek,uporabnisko_ime,geslo;
	private boolean ali_je_administrator;
	
	@Override
	public String toString() {
		
		return String.format("ime: %s%npriimek: %s%nuporabnisko_ime: %s%ngeslo: %s%nali_je_administrator: %b%n", ime,priimek,uporabnisko_ime,geslo,ali_je_administrator);
	}
	/** allArgs Constructor, noArgs Constructor, setters, getters */
	public Uporabnik() {};
	public Uporabnik(String ime, String priimek, String uporabnisko_ime,String geslo ,boolean ali_je_administrator) {
		this.ime = ime;
		this.priimek = priimek;
		this.uporabnisko_ime = uporabnisko_ime;
		this.geslo = geslo;
		this.ali_je_administrator = ali_je_administrator;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPriimek() {
		return priimek;
	}
	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}
	public String getUporabnisko_ime() {
		return uporabnisko_ime;
	}
	public void setUporabnisko_ime(String uporabnisko_ime) {
		this.uporabnisko_ime = uporabnisko_ime;
	}
	public boolean isAli_je_administrator() {
		return ali_je_administrator;
	}
	public void setAli_je_administrator(boolean ali_je_administrator) {
		this.ali_je_administrator = ali_je_administrator;
	}
	public String getGeslo() {
		return geslo;
	}
	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}
	
}
