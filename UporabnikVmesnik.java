import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UporabnikVmesnik {
		
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final String pot = UporabniskiVmesnik.pot;
	
	public static void basic(ArrayList<Uporabnik> uporabniki) throws IOException, ClassNotFoundException {
		char opcija = ' ';
		while(true) 
		{
			System.out.printf("%s%n*%36s%13s%n%s%n",new String(new char[50]).replace("\0", "*"),"-->Iskanje pocitnic<--","*",new String(new char[50]).replace("\0", "*"));
			System.out.println("Opcije programa: ");
			System.out.println("a -> Isci pocitnice po casovnem okvirju.");
			System.out.println("b -> Isci pocitnice po drzavi.");
			System.out.println("c -> Isci po cenovnem okvirju.");
			System.out.println("d -> Isci po tipu pocitnic.");
			System.out.println("e -> Ustvari rezervacijo.");
			System.out.println("f -> Izpis rezervacij.");
			System.out.println("y -> Odjava.");
			System.out.print("Vnesite opcijo programa kot znak (npr. y): ");
			opcija = (char) br.read();
			switch (opcija)
			{
				case 'a': 
					TuristicnaAgencija.poisci_pocitnico_casovni_okvir(false);
					br.readLine();//BELI ZNAK
					break;
				case 'b':
					TuristicnaAgencija.poisci_pocitnico_drzava(false);
					br.readLine();//BELI ZNAK
					break;
				case 'c':
					TuristicnaAgencija.poisci_pocitnico_cenovni_okvir(false);
					br.readLine();//BELI ZNAK
					break;
				case 'd':
					TuristicnaAgencija.poisci_pocitnico_tip_podrazredov(false);
					br.readLine();//BELI ZNAK
					break;
				case 'f':
					TuristicnaAgencija.izpise_rezervacije();
					br.readLine();//BELI ZNAK
					break;
				case 'y':
					TuristicnaAgencija.shrani();
					IORazred_mainVmesnik.shrani(pot, uporabniki);
					UporabniskiVmesnik.main(new String[]{"true"});
					break;
				default:
					System.out.println("NAPACNA OPCIJA.");
			}
		}
	}
	public static void admin(ArrayList<Uporabnik> uporabniki) throws IOException, ClassNotFoundException {
		char opcija = ' ';
		while(true) 
		{
			System.out.printf("%s%n*%36s%13s%n%s%n",new String(new char[50]).replace("\0", "*"),"-->Iskanje pocitnic<--","*",new String(new char[50]).replace("\0", "*"));
			System.out.println("Opcije programa: ");
			System.out.println("a -> Isci pocitnice po casovnem okvirju.");
			System.out.println("b -> Isci pocitnice po drzavi.");
			System.out.println("c -> Isci po cenovnem okvirju.");
			System.out.println("d -> Isci po tipu pocitnic.");
			System.out.println("e -> Ustvari rezervacijo.");
			System.out.println("f -> Izpis rezervacij.");
			System.out.println("g -> najdi pocitnice po ID stevilki.");
			System.out.println("h -> ustvari pocitnice.");
			System.out.println("i -> brisi pocitnice.");
			System.out.println("j -> brisi termin.");
			System.out.println("k -> dodaj termin.");
			System.out.println("l -> sprememba cene pocitnice.");
			System.out.println("m -> shrani spremembe(v datoteko).");
			System.out.println("n -> ustvari admin racun.");
			System.out.println("o -> brisi racun uporabnika/admnistratorja.");
			System.out.println("x -> izpis vseh pocitnic.");
			System.out.println("y -> Odjava.");
			System.out.print("Vnesite opcijo programa kot znak (npr. y): ");
			opcija = (char) br.read();
			switch (opcija)
			{
				case 'a': 
					TuristicnaAgencija.poisci_pocitnico_casovni_okvir(true);
					br.readLine();//BELI ZNAK
					break;
				case 'b':
					TuristicnaAgencija.poisci_pocitnico_drzava(true);
					br.readLine();//BELI ZNAK
					break;
				case 'c':
					TuristicnaAgencija.poisci_pocitnico_cenovni_okvir(true);
					br.readLine();//BELI ZNAK
					break;
				case 'd':
					TuristicnaAgencija.poisci_pocitnico_tip_podrazredov(true);
					br.readLine();//BELI ZNAK
					break;
				case 'f':
					TuristicnaAgencija.izpise_rezervacije();
					br.readLine();//BELI ZNAK
					break;
				case 'g':
					TuristicnaAgencija.poisci_pocitnico();
					br.readLine();//BELI ZNAK
					break;
				case 'h':
					TuristicnaAgencija.vnos_pocitnic();
					br.readLine();//BELI ZNAK
					break;
				case 'i':
					TuristicnaAgencija.brisanje_pocitnic();
					br.readLine();//BELI ZNAK
					break;
				case 'j':
					TuristicnaAgencija.brisi_termin();
					br.readLine();//BELI ZNAK
					break;
				case 'k':
					TuristicnaAgencija.dodaj_Termin();
					br.readLine();//BELI ZNAK
					break;
			    case 'l':
			    	TuristicnaAgencija.sprememba_cene();
			    	br.readLine();//Beli znak
				case 'm':
					TuristicnaAgencija.shrani();
					br.readLine();//BELI ZNAK
					break;
				case 'n':
					IORazred_mainVmesnik.registriraj(uporabniki, true);
					br.readLine();
					break;
			    case 'o':
			    	IORazred_mainVmesnik.izbrisi_uporabnika(uporabniki);
			         br.readLine();//BELI ZNAK
					break;
			    case 'x':
			    	 TuristicnaAgencija.izpisVsehPocitnic();
			    	 br.readLine();//BELI ZNAK
			    	 break;
				case 'y':
					TuristicnaAgencija.shrani();
					IORazred_mainVmesnik.shrani(pot, uporabniki);
					UporabniskiVmesnik.main(new String[]{"true"});
					break;
				default:
					System.out.println("NAPACNA OPCIJA.");
			}
		}
	}
	
}
