import java.util.ArrayList;

public class Pocitnice_potovanje  extends Pocitnice{
	
    private static final long serialVersionUID = 1L;
	private boolean doplaciloKamera_goPRO; 
	private boolean doplaciloPowerbank;

	
	@Override
	public String toString() {
		
		return super.toString()+
				String.format("doplaciloGoPro: %b%n", doplaciloKamera_goPRO)
		      + String.format("doplaciloPowerbank: %b%n", doplaciloPowerbank);
			
	}
	
	
	public Pocitnice_potovanje(int dan, int mesec, int id, int max_osebe, String drzava, double cena,
			ArrayList<Termin> termini, ArrayList<Rezervacija> rezervacije) {
		super(dan, mesec, id, max_osebe, drzava, cena, termini, rezervacije);
		
	}
	public Pocitnice_potovanje(int dan, int mesec, int id, int max_osebe, String drzava, double cena,
			ArrayList<Termin> termini, ArrayList<Rezervacija> rezervacije, boolean doplaciloKamera_goPRO,
			boolean doplaciloPowerbank) {
		super(dan, mesec, id, max_osebe, drzava, cena, termini, rezervacije);
		this.doplaciloKamera_goPRO = doplaciloKamera_goPRO;
		this.doplaciloPowerbank = doplaciloPowerbank;
	}

	public boolean isDoplaciloKamera_goPRO() {
		return doplaciloKamera_goPRO;
	}

	public void setDoplaciloKamera_goPRO(boolean doplaciloKamera_goPRO) {
		this.doplaciloKamera_goPRO = doplaciloKamera_goPRO;
	}

	public boolean isDoplaciloPowerbank() {
		return doplaciloPowerbank;
	}

	public void setDoplaciloPowerbank(boolean doplaciloPowerbank) {
		this.doplaciloPowerbank = doplaciloPowerbank;
	}
	
		
	
}
