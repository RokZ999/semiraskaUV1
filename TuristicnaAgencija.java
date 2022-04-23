import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TuristicnaAgencija {
    static ArrayList<Pocitnice> pocitnice = new ArrayList<>();
	private static BufferedReader br = null;
	private static PrintWriter pr = null;
	public static Uporabnik usr = null;
	
	public static void nalozi() throws ClassNotFoundException, IOException {
		IOBranjeZapisObjektov_splosno.preberi_nalozi_Objekte(UporabniskiVmesnik.pot2, pocitnice);
	}
	public static void shrani() throws ClassNotFoundException, IOException {
		IOBranjeZapisObjektov_splosno.shrani_Objekte(UporabniskiVmesnik.pot2,pocitnice);
	}
	

	public static int prestejRezervacije(Pocitnice obj) {
		int vsota = 0 ;
		if(obj.getRezervacije() == null || obj.getRezervacije().isEmpty()) 
			obj.setRezervacije(new ArrayList<>());
		for(Rezervacija re: obj.getRezervacije()) {
			vsota += re.getSt_odrashlih() + re.getSt_otrok();
		}
		return vsota;
	}
	
	public static void poisci_pocitnico_casovni_okvir(boolean flag) throws IOException {
		int danP = 0,danK = 0, mesecP = 0,mesecK = 0;
		boolean aliObstajajoPocitnice = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vnesite dan prihoda termina (vnesite celo stevilo): ");
		danP = betterIntegerParser_helper(br.readLine());
		System.out.print("Vnesite dan odhoda termina (vnesite celo stevilo): ");
		danK = betterIntegerParser_helper(br.readLine());
		System.out.print("Vnesite mesec prihoda (vnesite celo stevilo): ");
		mesecP = betterIntegerParser_helper(br.readLine());
		System.out.print("Vnesite mesec odhoda (vnesite celo stevilo): ");
		mesecK = betterIntegerParser_helper(br.readLine());
		
		for(Pocitnice obj: pocitnice)
		{
			
			if(obj.getTermini().size() > 0 && obj.getDan() < danK && obj.getMesec() < mesecK && obj.getDan() > danP && obj.getDan() > mesecP) {
				aliObstajajoPocitnice = true;
				System.out.println( flag ? obj : obj.toString_navadn_smrtnik());
				System.out.println("Za te pocitnice so prosti naslednji termini: ");
				for(Termin ter: obj.getTermini()) {
					if(prestejRezervacije(obj) == obj.getMax_osebe())
						System.out.println(ter + "\nSTATUS POCITNICE: ZAGOTOVLJENO.");
					else if(prestejRezervacije(obj) < obj.getMax_osebe())
						System.out.println(ter +"\nSTATUS POCITNICE: SKORAJ ZAGOTOVLJENO.");
					else
						System.out.println(ter +"\nSTATUS POCITNICE: NI ZAGOTOVLJENO.");
				ustvari_rezervacijo(obj);
				}
			}
				
		}
		System.out.println(aliObstajajoPocitnice ? "" : "Pocitnice s podanimi parametri ni bilo mogoce najti.");
		
	}
	public static void poisci_pocitnico_drzava(boolean flag) throws IOException {
		String drzava = "";
		boolean aliObstajajoPocitnice = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vnesite ime drzave, v kateri iscite pocitnice: ");
		drzava = br.readLine();
		
		for(Pocitnice obj: pocitnice)
		{
			if(obj.getTermini().size() > 0 && obj.getDrzava().equals(drzava)) {
				aliObstajajoPocitnice = true;
				System.out.println( flag ? obj : obj.toString_navadn_smrtnik());
				System.out.println("Za te pocitnice so prosti naslednji termini: ");
				for(Termin ter: obj.getTermini())
					if(prestejRezervacije(obj) == obj.getMax_osebe())
						System.out.println(ter + "\nSTATUS POCITNICE: ZAGOTOVLJENO.");
					else if(prestejRezervacije(obj) < obj.getMax_osebe())
						System.out.println(ter +"\nSTATUS POCITNICE: SKORAJ ZAGOTOVLJENO.");
					else
						System.out.println(ter +"\nSTATUS POCITNICE: NI ZAGOTOVLJENO.");
				ustvari_rezervacijo(obj);
			}
				
		}
		System.out.println(aliObstajajoPocitnice ? "" : "Pocitnice s podanimi parametri ni bilo mogoce najti.");
	}
	public static void poisci_pocitnico_cenovni_okvir(boolean flag) throws IOException {
		int minCena = 0, maxCena = 0;
		boolean aliObstajajoPocitnice = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vnesite min ceno: ");
		minCena = betterIntegerParser_helper(br.readLine());
		System.out.print("Vnesite max ceno: ");
		maxCena = betterIntegerParser_helper(br.readLine());
		
		for(Pocitnice obj: pocitnice)
		{
			if(obj.getTermini().size() > 0 && obj.getCena() >= minCena && obj.getCena() <= maxCena) {
				aliObstajajoPocitnice = true;
				System.out.println( flag ? obj : obj.toString_navadn_smrtnik());
				System.out.println("Za te pocitnice so prosti naslednji termini: ");
				for(Termin ter: obj.getTermini()) {
					if(prestejRezervacije(obj) == obj.getMax_osebe())
						System.out.println(ter + "\nSTATUS POCITNICE: ZAGOTOVLJENO.");
					else if(prestejRezervacije(obj) < obj.getMax_osebe())
						System.out.println(ter +"\nSTATUS POCITNICE: SKORAJ ZAGOTOVLJENO.");
					else
						System.out.println(ter +"\nSTATUS POCITNICE: NI ZAGOTOVLJENO.");
				ustvari_rezervacijo(obj);
				}
			}
		}
		System.out.println(aliObstajajoPocitnice ? "" : "Pocitnice s podanimi parametri ni bilo mogoce najti.");
	}
	public static void poisci_pocitnico_tip_podrazredov(boolean flag) throws IOException {
		char ch = ' ';
		boolean aliObstajajoPocitnice = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Vnesite ");
		System.out.println("Vnesite tip pocitnice: ");
		System.out.println("Na voljo so naslednji tipi: ");
		System.out.println("a -> navadne/nekategozirane: ");
		System.out.println("b -> krizarjanje: ");
		System.out.println("c -> potovanje: ");
		System.out.println("d -> smucanje: ");
		System.out.println("e -> kampiranje: ");
		System.out.print("Vnos: ");
		ch = (char) br.read();
		
		switch (ch) {
		case 'a': {
			for(Pocitnice obj: pocitnice)
			{
				
				if(obj.getTermini().size() > 0 && obj instanceof Pocitnice)
				{
					aliObstajajoPocitnice = true;
					System.out.println( flag ? obj : obj.toString_navadn_smrtnik());
					System.out.println("Za te pocitnice so prosti naslednji termini: ");
					for(Termin ter: obj.getTermini()) {
						if(prestejRezervacije(obj) == obj.getMax_osebe())
							System.out.println(ter + "\nSTATUS POCITNICE: ZAGOTOVLJENO.");
						else if(prestejRezervacije(obj) < obj.getMax_osebe())
							System.out.println(ter +"\nSTATUS POCITNICE: SKORAJ ZAGOTOVLJENO.");
						else
							System.out.println(ter +"\nSTATUS POCITNICE: NI ZAGOTOVLJENO.");
						ustvari_rezervacijo(obj);
					}
				}
			}
			break;
		}
		case 'b': {
			for(int i=0;i<pocitnice.size();i++)
			{
				if(pocitnice.get(i).getTermini().size() > 0 && pocitnice.get(i) instanceof Pocitnice_krizarjanje)
				{
					aliObstajajoPocitnice = true;
					System.out.println( flag ? pocitnice.get(i) : pocitnice.get(i).toString_navadn_smrtnik());
					System.out.println("Za te pocitnice so prosti naslednji termini: ");
					for(Termin ter: pocitnice.get(i).getTermini()) {
						if(prestejRezervacije(pocitnice.get(i)) == pocitnice.get(i).getMax_osebe())
							System.out.println(ter + "\nSTATUS POCITNICE: ZAGOTOVLJENO.");
						else if(prestejRezervacije(pocitnice.get(i)) < pocitnice.get(i).getMax_osebe())
							System.out.println(ter +"\nSTATUS POCITNICE: SKORAJ ZAGOTOVLJENO.");
						else
							System.out.println(ter +"\nSTATUS POCITNICE: NI ZAGOTOVLJENO.");
					ustvari_rezervacijo(pocitnice.get(i));
					}
				}
			}
			break;
		}
		case 'c': {
			for(int i=0;i<pocitnice.size();i++)
			{
				if(pocitnice.get(i).getTermini().size() > 0 && pocitnice.get(i) instanceof Pocitnice_potovanje)
				{
					aliObstajajoPocitnice = true;
					System.out.println( flag ? pocitnice.get(i) : pocitnice.get(i).toString_navadn_smrtnik());
					System.out.println("Za te pocitnice so prosti naslednji termini: ");
					for(Termin ter: pocitnice.get(i).getTermini()) {
						if(prestejRezervacije(pocitnice.get(i)) == pocitnice.get(i).getMax_osebe())
							System.out.println(ter + "\nSTATUS POCITNICE: ZAGOTOVLJENO.");
						else if(prestejRezervacije(pocitnice.get(i)) < pocitnice.get(i).getMax_osebe())
							System.out.println(ter +"\nSTATUS POCITNICE: SKORAJ ZAGOTOVLJENO.");
						else
							System.out.println(ter +"\nSTATUS POCITNICE: NI ZAGOTOVLJENO.");
					ustvari_rezervacijo(pocitnice.get(i));
					}
				}
			}
			break;
		}
		case 'd': {
			for(int i=0;i<pocitnice.size();i++)
			{
				if(pocitnice.get(i).getTermini().size() > 0 && pocitnice.get(i) instanceof Pocitnice_smucanje)
				{
					aliObstajajoPocitnice = true;
					System.out.println( flag ? pocitnice.get(i) : pocitnice.get(i).toString_navadn_smrtnik());
					System.out.println("Za te pocitnice so prosti naslednji termini: ");
					for(Termin ter: pocitnice.get(i).getTermini()) {
						if(prestejRezervacije(pocitnice.get(i)) == pocitnice.get(i).getMax_osebe())
							System.out.println(ter + "\nSTATUS POCITNICE: ZAGOTOVLJENO.");
						else if(prestejRezervacije(pocitnice.get(i)) < pocitnice.get(i).getMax_osebe())
							System.out.println(ter +"\nSTATUS POCITNICE: SKORAJ ZAGOTOVLJENO.");
						else
							System.out.println(ter +"\nSTATUS POCITNICE: NI ZAGOTOVLJENO.");
						ustvari_rezervacijo(pocitnice.get(i));
						}
				}
			}
			break;
		}
		case 'e': {
			for(int i=0;i<pocitnice.size();i++)
			{
				if(pocitnice.get(i).getTermini().size() > 0 &&  pocitnice.get(i) instanceof Pocitnice_kampiranje)
				{
					aliObstajajoPocitnice = true;
					System.out.println( flag ? pocitnice.get(i) : pocitnice.get(i).toString_navadn_smrtnik());
					System.out.println("Za te pocitnice so prosti naslednji termini: ");
					for(Termin ter: pocitnice.get(i).getTermini()) {
						if(prestejRezervacije(pocitnice.get(i)) == pocitnice.get(i).getMax_osebe())
							System.out.println(ter + "\nSTATUS POCITNICE: ZAGOTOVLJENO.");
						else if(prestejRezervacije(pocitnice.get(i)) < pocitnice.get(i).getMax_osebe())
							System.out.println(ter +"\nSTATUS POCITNICE: SKORAJ ZAGOTOVLJENO.");
						else
							System.out.println(ter +"\nSTATUS POCITNICE: NI ZAGOTOVLJENO.");
					ustvari_rezervacijo(pocitnice.get(i));
				}
				}
			}
			break;
		}
		default:
			System.out.println("Vneseni znak ni bil najden.");
		}
	
		System.out.println(aliObstajajoPocitnice ? "" : "Pocitnice s podanimi parametri ni bilo mogoce najti.");
	}
	public static void ustvari_rezervacijo(Pocitnice obj) throws IOException {
		int st_odraslih = 0, st_otrok = 0;
		char ch = ' ';
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ali zelite rezervacijo? ");
		System.out.println("Vnesite y -> za ustvarjanje rezervacije.");
		System.out.println("Vseite x -> za konec poizvedbe.");
		System.out.print("Vnos: ");
		ch = (char)br.read();
		br.readLine();//WHITE SPACE
		
		if(ch == 'y') {
			System.out.print("Vnesite st. odraslih: ");
			st_odraslih = betterIntegerParser_helper(br.readLine());
			System.out.print("Vnesite st. otrok: ");
			st_otrok = betterIntegerParser_helper(br.readLine());
			
			if(st_odraslih + st_otrok < obj.getMax_osebe() - prestejRezervacije(obj)) {
			obj.getRezervacije().add(new Rezervacija(usr.getIme(),usr.getUporabnisko_ime(), st_odraslih, st_otrok));
			System.out.println("Rezervacija uspesno ustvarjena.");
			}else {
				System.out.println("Ni dovolj mest.");
			}
		}
	}
	public static void izpise_rezervacije() {
		boolean f = false;
		for(Pocitnice obj : pocitnice)
		   if(obj.getRezervacije() != null && !obj.getRezervacije().isEmpty())
			for(Rezervacija obj2 :obj.getRezervacije())
				if(obj2.getUporabnik().equals(usr.getUporabnisko_ime())) {
					System.out.println("Podatki v pocitnicah:  \n" + obj.toString_navadn_smrtnik() +"\nPodatki v terminih za dano pocitnico: \n" + obj2 );
					f = true;
				}
					else {
							System.out.println("Ni bilo najdenih rezervacij.");
		   }
		System.out.println(f ? "" : "Ni bilo najdenih rezervacij."); 
	}
	
	public static void poisci_pocitnico() throws IOException {
		int id = 0;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("Vnesite id pocitnice: ");
		id = betterIntegerParser_helper(br.readLine());
		
		for(Pocitnice poc:pocitnice)
			if(poc.getId() == id )
				{
				System.out.print(poc);
				return;
				}
		System.out.println("Pocitnice z ID: " + id + "ni bilo mogoce najti.");
	}
	public static void vnos_pocitnic() throws IOException {
		char ch = ' ';
		int id = 0,dan = 0, mesec = 0, max_st_oseb = 0;
		double cena = 0.0;
		String drzava = "";
		boolean value1=false,value2=false,f=true;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("Vnesite id pocitnice: ");
		id = betterIntegerParser_helper(br.readLine());
		System.out.printf("Vnesite dan: ");
		dan = betterIntegerParser_helper(br.readLine());
		System.out.printf("Vnesite mesec: ");
		mesec = betterIntegerParser_helper(br.readLine());
		System.out.printf("Vnesite najvecje stevilo oseb: ");
		max_st_oseb = betterIntegerParser_helper(br.readLine());
		System.out.printf("Vnesite ceno: ");
		cena = betterDoubleParser_helper(br.readLine());
		System.out.printf("Vnesite drzavo: ");
		drzava = br.readLine();
		while(f) {
			System.out.println("Vnesite tip pocitnice: ");
			System.out.println("Na voljo so naslednji tipi: ");
			System.out.println("a -> navadne/nekategozirane: ");
			System.out.println("b -> krizarjanje: ");
			System.out.println("c -> potovanje: ");
			System.out.println("d -> smucanje: ");
			System.out.println("e -> kampiranje: ");
			ch = (char) br.read();
			br.readLine();
			switch (ch) {
				case 'a':
					pocitnice.add(new Pocitnice(dan, mesec, id, max_st_oseb, drzava, cena, new ArrayList<Termin>(), new ArrayList<Rezervacija>()));
					System.out.printf("Pocitnice uspesno shranjene.%n");
					f = false;
					break;
				case 'b':
					System.out.printf("Doplacilo za kanu: ");
					value1 = betterBooleanParser_helper(br.readLine());
					System.out.printf("Doplacilo za powerbank: ");
					value2 = betterBooleanParser_helper(br.readLine());
					pocitnice.add(new Pocitnice_krizarjanje(dan, mesec, id, max_st_oseb, drzava, cena, new ArrayList<Termin>(), new ArrayList<Rezervacija>(),value1,value2));
					System.out.printf("Pocitnice uspesno shranjene.%n");
					f = false;
					break;
				case 'c':
					System.out.printf("Doplacilo za goPRO kamero: ");
					value1 = betterBooleanParser_helper(br.readLine());
					System.out.printf("Doplacilo za powerbank: ");
					value2 = betterBooleanParser_helper(br.readLine());
					pocitnice.add(new Pocitnice_potovanje(dan, mesec, id, max_st_oseb, drzava, cena, new ArrayList<Termin>(), new ArrayList<Rezervacija>(),value1,value2));
					System.out.printf("Pocitnice uspesno shranjene.%n");
					f = false;
					break;
				case 'd':
					System.out.printf("Doplacilo za Opremo: ");
					value1 = betterBooleanParser_helper(br.readLine());
					System.out.printf("Doplacilo za powerbank: ");
					value2 = betterBooleanParser_helper(br.readLine());
					pocitnice.add(new Pocitnice_smucanje(dan, mesec, id, max_st_oseb, drzava, cena, new ArrayList<Termin>(), new ArrayList<Rezervacija>(),value1,value2));
					System.out.printf("Pocitnice uspesno shranjene.%n");
					f = false;
					break;
				case 'e':
					System.out.printf("Doplacilo za sotor: ");
					value1 = betterBooleanParser_helper(br.readLine());
					System.out.printf("Doplacilo za powerbank: ");
					value2 = betterBooleanParser_helper(br.readLine());
					pocitnice.add(new Pocitnice_kampiranje(dan, mesec, id, max_st_oseb, drzava, cena, new ArrayList<Termin>(), new ArrayList<Rezervacija>(),value1,value2));
					System.out.printf("Pocitnice uspesno shranjene.%n");
					f = false;
					break;
			default:
				throw new IllegalArgumentException("Nepricekovana vrednost: " + ch);
			}
		}
		

		
	}
	public static void brisanje_pocitnic() throws IOException {
		int id = 0;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vnesite id pocitnice, katere zelite izbrisati: ");
		id = betterIntegerParser_helper(br.readLine());
		for(Pocitnice obj: pocitnice)
			if(obj.getId() == id)
				{
					pocitnice.remove(obj);
					System.out.println("Pocitnica uspesno izbrisana!");
					return;
				}
		System.out.println("Pocitnica z id:" + id +" ne obstaja.");
	}
	public static void dodaj_Termin() throws IOException {
		int id = 0,dan = 0, mesec = 0, prihod = 0, odhod = 0;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vnesite id pocitnice, katere zelite dodati termin: ");
		id = betterIntegerParser_helper(br.readLine());
		for(Pocitnice obj: pocitnice)
			if(obj.getId() == id)
				{
					
					System.out.print("Vnesite dan termina (vnesite celo stevilo): ");
					dan = betterIntegerParser_helper(br.readLine());
					System.out.print("Vnesite mesec termina (vnesite celo stevilo): ");
					mesec = betterIntegerParser_helper(br.readLine());
					System.out.print("Vnesite uro prihoda termina (vnesite celo stevilo): ");
					prihod = betterIntegerParser_helper(br.readLine());
					System.out.print("Vnesite uro odhoda termina (vnesite celo stevilo): ");
					odhod = betterIntegerParser_helper(br.readLine());
					obj.getTermini().add(new Termin(dan, mesec, prihod, odhod));
					System.out.println("Termin uspesno dodan.");
					return;
				}
		System.out.println("Pocitnica z id:" + id +" ne obstaja.");
	}
	
	public static void brisi_termin() throws IOException {
		int id = 0,dan = 0, mesec = 0, prihod = 0, odhod = 0;
		boolean aliTerminObstaja = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vnesite id pocitnice, katere zelite izbrisati termin: ");
		id = betterIntegerParser_helper(br.readLine());
		for(Pocitnice obj: pocitnice)
			if(obj.getId() == id)
				{
					
					System.out.println("Vnesite dan termina (vnesite celo stevilo): ");
					dan = betterIntegerParser_helper(br.readLine());
					System.out.println("Vnesite mesec termina (vnesite celo stevilo): ");
					mesec = betterIntegerParser_helper(br.readLine());
					System.out.println("Vnesite uro prihoda termina (vnesite celo stevilo): ");
					prihod = betterIntegerParser_helper(br.readLine());
					System.out.println("Vnesite uro odhoda termina (vnesite celo stevilo): ");
					odhod = betterIntegerParser_helper(br.readLine());
					aliTerminObstaja = pocitnice.get(id).getTermini().remove(new Termin(dan, mesec, prihod, odhod));
					if(aliTerminObstaja)
						System.out.println("Termin uspesno izbrisa.");
					else
						System.out.println("Termin neobstaja.");
					return;
				}
		System.out.println("Pocitnica z id:" + id +" ne obstaja.");
	}
	public static void sprememba_cene() throws IOException {
		int id = 0,cena = 0;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Vnesite id pocitnice, katere zelite spremeniti: ");
		id = betterIntegerParser_helper(br.readLine());
		for(Pocitnice obj: pocitnice)
			if(obj.getId() == id)
				{
					System.out.print("Vnesite novo ceno pocinice: ");
					cena = betterIntegerParser_helper(br.readLine());
					obj.setCena(cena);
					System.out.print("Nova cena nastavljena.\n");
					return;
				}
		System.out.println("Pocitnica z id:" + id +" ne obstaja.");
	}
	
	private static int betterIntegerParser_helper(String str) {
		try {
			return Integer.parseInt(str);
		}catch(Exception  e){
			System.out.println("Podatka:" + str + "ni blo mogoce pretvoriti. zato je dobil prevzeto vrednost 0.");
			return 0;
		}
	}
	private static double betterDoubleParser_helper(String str) {
		try {
			return Double.parseDouble(str);
		}catch(Exception e){
			System.out.println("Podatka:" + str + "ni blo mogoce pretvoriti. zato je dobil prevzeto vrednost 0.0.");
			return 0.0;
		}
	}
	private static boolean betterBooleanParser_helper(String str) {
		try {
			return Boolean.parseBoolean(str);
		}catch(Exception e){
			System.out.println("Podatka:" + str + "ni blo mogoce pretvoriti. zato je dobil prevzeto vrednost false");
			return false;
		}
	}
	
	
	
	public static void izpisVsehPocitnic() throws ClassNotFoundException, IOException {
		System.out.println(pocitnice);
		System.out.println("Vseh pocitnic je: " + pocitnice.size());
	}
	public static void odjavaZapriBralnike() throws IOException{
		System.out.println("Program je bil terminiran!");
		if(pr != null && br !=null) {
			pr.close();
			br.close();
		}
		
	}

}
