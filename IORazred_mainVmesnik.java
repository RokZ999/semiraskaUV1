import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class IORazred_mainVmesnik {
	private static String input1 = null,input2 = null,input3 = null,input4 = null;
	private static BufferedReader br = null;
	private static PrintWriter pr = null;
	
	public static void preberi(String pot,ArrayList<Uporabnik> uporabniki) throws IOException, ClassNotFoundException {
		IOBranjeZapisObjektov_splosno.preberi_nalozi_Objekte(pot, uporabniki);
	}
	public static void shrani(String pot,ArrayList<Uporabnik> uporabniki) throws IOException{
		IOBranjeZapisObjektov_splosno.shrani_Objekte(pot, uporabniki);
	}
	public static void registriraj(ArrayList<Uporabnik> uporabniki,boolean f) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vnesite ime: ");
		input1 = br.readLine();
		System.out.print("Vnesite priimek: ");
		input2 = br.readLine();
		System.out.print("Vnesite uporabnisko_ime: ");
		input3 = br.readLine();
		System.out.print("Vnesite geslo: ");
		input4 = br.readLine();
		
		if(aliObstaja(uporabniki, input3))
			System.out.println("Uporabnisko ime je ze zasedeno.");
		else {
			uporabniki.add(f ? new Uporabnik(input1,input2,input3,input4,true) :   new Uporabnik(input1,input2,input3,input4,false));
			System.out.println("Uporabnik shranjen.");
		}
	}
	public static void prijava(ArrayList<Uporabnik> uporabniki) throws IOException, ClassNotFoundException  {
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vnesite uporabnisko ime: ");
		input1 = br.readLine();
		if(!aliObstaja(uporabniki, input1))
		{
			System.out.printf("NAPAKA! Uporabnik: %s  ne obstaja! Preverite za male velike crke.%n", input1);
			return;
		}
		System.out.print("Vnesite geslo: ");
		input2 = br.readLine();
		for(Uporabnik obj: uporabniki)
			if(obj.getUporabnisko_ime().equals(input1) && obj.getGeslo().equals(input2))
				if(obj.isAli_je_administrator()) {
					TuristicnaAgencija.usr = obj;
					UporabnikVmesnik.admin(uporabniki);
					
				}
				else {
					TuristicnaAgencija.usr = obj;
					UporabnikVmesnik.basic(uporabniki);
					
				}
	}
	public static void izbrisi_uporabnika(ArrayList<Uporabnik> uporabniki) throws IOException{
		int admin_counter = prestej_Admine(uporabniki);
		System.out.println(admin_counter);
		System.out.print("Vnesite uporabnisko ime: ");
		input1 = br.readLine();
		
		if(!aliObstaja(uporabniki, input1))
		{
			System.out.printf("NAPAKA! Uporabnik: %s  ne obstaja! Preverite za male velike crke.", input1);
			return;
		}else {
				for(Uporabnik obj: uporabniki) {
					if(obj.getUporabnisko_ime().equals(input1)) 
					{
						if(obj.isAli_je_administrator() && admin_counter > 1) 
						{
							admin_counter--;
							uporabniki.remove(obj);
						}
						else
							System.out.println("V sistemu more biti vsaj 1 admin.");
					}
					if(!obj.isAli_je_administrator())
							uporabniki.remove(obj);
				}
		}
	}

	public static int prestej_Admine(ArrayList<Uporabnik> uporabniki) {
		int admin_stevec = 0;
		for(Uporabnik obj: uporabniki)
			admin_stevec = obj.isAli_je_administrator() ? ++admin_stevec : admin_stevec;
		
		return admin_stevec;
	}
	
	
	public static boolean aliObstaja(ArrayList<Uporabnik> uporabniki,String input) {
		for(Uporabnik obj: uporabniki)
			if(obj.getUporabnisko_ime().equals(input))
				return true;
		return false;
	};
	public static void izpisUporabnikov(ArrayList<Uporabnik> uporabniki) {
		System.out.print(Arrays.toString(uporabniki.toArray()).replace("[", "").replace("]", ""));
	}
	
	public static void terminirajProgram() throws IOException{

		System.out.println("Program je bil terminiran!");
		if(pr == null || br ==null)
			System.exit(0);
		else {
			pr.close();
			br.close();
			System.exit(0);
		}
	}
}
