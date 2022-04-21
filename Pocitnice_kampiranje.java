import java.util.ArrayList;

public class Pocitnice_kampiranje extends Pocitnice{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean doplaciloSotor;
	private boolean doplaciloPowerbank;
	
	
	@Override
	public String toString() {
		
		return super.toString()+
				String.format("doplaciloSotor: %b%n", doplaciloSotor)
		      + String.format("doplaciloPowerbank: %b%n", doplaciloPowerbank);
			
	}
	
	public Pocitnice_kampiranje(int dan, int mesec, int id, int max_osebe, String drzava, double cena,
			ArrayList<Termin> termini, ArrayList<Rezervacija> rezervacije) {
		super(dan, mesec, id, max_osebe, drzava, cena, termini, rezervacije);
	}
	public Pocitnice_kampiranje(int dan, int mesec, int id, int max_osebe, String drzava, double cena,
			ArrayList<Termin> termini, ArrayList<Rezervacija> rezervacije, boolean doplaciloSotor, boolean doplaciloPowerbank) {
		super(dan, mesec, id, max_osebe, drzava, cena, termini, rezervacije);
		this.doplaciloSotor = doplaciloSotor;
		this.doplaciloPowerbank = doplaciloPowerbank;
	}
	
	
	public boolean isDoplaciloSotor() {
		return doplaciloSotor;
	}

	public void setDoplaciloSotor(boolean doplaciloSotor) {
		this.doplaciloSotor = doplaciloSotor;
	}

	public boolean isDoplaciloPowerbank() {
		return doplaciloPowerbank;
	}
	public void setDoplaciloPowerbank(boolean doplaciloPowerbank) {
		this.doplaciloPowerbank = doplaciloPowerbank;
	}

}
