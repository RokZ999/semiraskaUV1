import java.io.Serializable;
import java.util.ArrayList;

public class Pocitnice implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dan,mesec,id,max_osebe;
	private String drzava;
	private double cena;
	private ArrayList<Termin> termini = new ArrayList<>();
	private ArrayList<Rezervacija> rezervacije = new ArrayList<>();
	
	
	
	//TODO: toString za navadnga in pol vrjeten admin je drgacen
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("id: %d%n",id)
			  +String.format("dan: %d%n",dan)
			  +String.format("mesec: %d%n",mesec)
			  +String.format("cena: %.2f€%n", cena)
			  +String.format("max_osebe: %d%n",max_osebe)
			  +String.format("drzava: %s%n", drzava)
			  ;
	}
	public String toString_navadn_smrtnik() {
		// TODO Auto-generated method stub
		return 
			  String.format("dan: %d%n",dan)
			  +String.format("mesec: %d%n",mesec)
			  +String.format("cena: %.2f€%n", cena)
			  +String.format("drzava: %s%n", drzava)
			  ;
	}
	
	
	
	public Pocitnice(int dan, int mesec, int id, int max_osebe, String drzava, double cena, ArrayList<Termin> termini,
			ArrayList<Rezervacija> rezervacije) {
		this.dan = dan;
		this.mesec = mesec;
		this.id = id;
		this.max_osebe = max_osebe;
		this.drzava = drzava;
		this.cena = cena;
		this.termini = termini;
		this.rezervacije = rezervacije;
	}


	public int getDan() {
		return dan;
	}


	public void setDan(int dan) {
		this.dan = dan;
	}


	public int getMesec() {
		return mesec;
	}


	public void setMesec(int mesec) {
		this.mesec = mesec;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMax_osebe() {
		return max_osebe;
	}


	public void setMax_osebe(int max_osebe) {
		this.max_osebe = max_osebe;
	}


	public String getDrzava() {
		return drzava;
	}


	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}


	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}


	public ArrayList<Termin> getTermini() {
		return termini;
	}


	public void setTermini(ArrayList<Termin> termini) {
		this.termini = termini;
	}


	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}


	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	
	
	
}
