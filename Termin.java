import java.io.Serializable;

public class Termin implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private int dan,mesec;
	private int prihod,odhod;
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Temin: %d.%d s prihodom ob %d in odhodom ob %d", dan,mesec,prihod,odhod);
	}
	
	public Termin(int dan, int mesec, int prihod, int odhod) {
		this.dan = dan;
		this.mesec = mesec;
		this.prihod = prihod;
		this.odhod = odhod;
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
	public int getPrihod() {
		return prihod;
	}
	public void setPrihod(int prihod) {
		this.prihod = prihod;
	}
	public int getOdhod() {
		return odhod;
	}
	public void setOdhod(int odhod) {
		this.odhod = odhod;
	}
	
	
	
	
}
