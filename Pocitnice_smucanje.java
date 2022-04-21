
import java.util.ArrayList;

public class Pocitnice_smucanje extends Pocitnice {
	
	private static final long serialVersionUID = 1L;
	private boolean doplaciloOprema;
	private boolean doplaciloPowerbank;
	
	
	
	
	@Override
	public String toString() {
		
		return super.toString()+
				String.format("doplaciloOprema: %b%n", doplaciloOprema)
		      + String.format("doplaciloPowerbank: %b%n", doplaciloPowerbank);
			
	}
	
	
	
	public Pocitnice_smucanje(int dan, int mesec, int id, int max_osebe, String drzava, double cena,
			ArrayList<Termin> termini, ArrayList<Rezervacija> rezervacije) {
		super(dan, mesec, id, max_osebe, drzava, cena, termini, rezervacije);
		
	}

	public Pocitnice_smucanje(int dan, int mesec, int id, int max_osebe, String drzava, double cena,
			ArrayList<Termin> termini, ArrayList<Rezervacija> rezervacije, boolean doplaciloOprema,
			boolean doplaciloPowerbank) {
		super(dan, mesec, id, max_osebe, drzava, cena, termini, rezervacije);
		this.doplaciloOprema = doplaciloOprema;
		this.doplaciloPowerbank = doplaciloPowerbank;
	}

	public boolean isDoplaciloOprema() {
		return doplaciloOprema;
	}

	public void setDoplaciloOprema(boolean doplaciloOprema) {
		this.doplaciloOprema = doplaciloOprema;
	}

	public boolean isDoplaciloPowerbank() {
		return doplaciloPowerbank;
	}

	public void setDoplaciloPowerbank(boolean doplaciloPowerbank) {
		this.doplaciloPowerbank = doplaciloPowerbank;
	}
}
