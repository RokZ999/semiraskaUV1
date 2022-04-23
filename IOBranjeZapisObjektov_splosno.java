
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;



public class IOBranjeZapisObjektov_splosno implements Serializable{
	/**
	 * serialVersionUID
	 * 
	 * serialization = pretvorba objektov v tok podatkov (byte stream), katerega lahko preberemo na kateremkoli JVM s pomocjo "deserialization"
	 * deserialization -> pretvorba tok podatkov v objekt.
	 * 
	 * Je stevilka, ki omogoca da se objekti pri "serialization" in 
	 * "deserialization":
	 * - pravilno shranijo/preberejo, ker ta stevilka se zapise z objektom v datoteko.txt, 
	 * 	 ker pa imamo razlicne jvm, kateri po defaultu generirajo serialVersionUID in razlicen jvm drugae generira "serialVersionUID"
	 * - Uporabno je tudi pri tem ko spremenimo objekt (npr. mu dodamo novo lastnost) in mu tudi dodelimo nov serialVersionUID in
	 *   s tem postokom prepricimo, da bi se stari verzije objektov nalozile.
	 * 
	 * Vec na: 
	 * 
	 * tl;dr  To more bit drgac ne dela. ;)
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static FileOutputStream fo;
	private static ObjectOutputStream oo;
	private static FileInputStream fi;
	private static ObjectInputStream oi;
	
	
	/** Metoda za deserialization 
	 *  prebere objekte iz datoteke in jih priridi seznamu katerega koli tipa.
	 */
	public static void shrani_Objekte(String pot,ArrayList<?> anyArrayList) throws IOException {
		fo = new FileOutputStream(new File(pot)); 
		oo = new ObjectOutputStream(fo);
		oo.writeObject(anyArrayList);
		fo.close();
		oo.close();
	}
	
	/** Metoda za serialization 
	 *  shrani iz seznama objekte anyArrayList v zeljeno datoteko
	 */
	@SuppressWarnings("unchecked")
	public static <T>  void  preberi_nalozi_Objekte(String pot,ArrayList<T> anyArrayList)  throws IOException, ClassNotFoundException  {
		File fileChecker = new File(pot);
		
		if(fileChecker.isFile() && fileChecker.length() == 0) {
			anyArrayList.clear();
		}
		else {
		fi = new FileInputStream( fileChecker);
		oi = new ObjectInputStream(fi);
	
		anyArrayList.addAll( (Collection<? extends T>) oi.readObject());
	    	fi.close();
		oi.close();
		}

	}

	
}
