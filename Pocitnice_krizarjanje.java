import java.util.ArrayList;

public class Pocitnice_krizarjanje extends Pocitnice {

	private static final long serialVersionUID = 1L;
	private boolean doplaciloKanu; 
	private boolean doplaciloPowerbank;
	
	
	@Override
	public String toString() {
		
		return super.toString()+
				String.format("doplaciloKanu: %b%n", doplaciloKanu)
		      + String.format("doplaciloPowerbank: %b%n", doplaciloPowerbank);
			
	}
	
	public Pocitnice_krizarjanje(int dan, int mesec, int id, int max_osebe, String drzava, double cena,
			ArrayList<Termin> termini, ArrayList<Rezervacija> rezervacije) {
		super(dan, mesec, id, max_osebe, drzava, cena, termini, rezervacije);
	
	}
	
	
	public Pocitnice_krizarjanje(int dan, int mesec, int id, int max_osebe, String drzava, double cena,
			ArrayList<Termin> termini, ArrayList<Rezervacija> rezervacije, boolean doplaciloKanu,
			boolean doplaciloPowerbank) {
		super(dan, mesec, id, max_osebe, drzava, cena, termini, rezervacije);
		this.doplaciloKanu = doplaciloKanu;
		this.doplaciloPowerbank = doplaciloPowerbank;
	}


	public boolean isDoplaciloKanu() {
		return doplaciloKanu;
	}

	public void setDoplaciloKanu(boolean doplaciloKanu) {
		this.doplaciloKanu = doplaciloKanu;
	}

	public boolean isDoplaciloPowerbank() {
		return doplaciloPowerbank;
	}

	public void setDoplaciloPowerbank(boolean doplaciloPowerbank) {
		this.doplaciloPowerbank = doplaciloPowerbank;
	}
}
