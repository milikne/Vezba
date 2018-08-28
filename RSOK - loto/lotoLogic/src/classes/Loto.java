package classes;

import java.util.Random;

import enums.LotoEnum;
import interfaces.IOperation;

/**
 * Klasa Loto
 * @author Predrag Pecev
 * @version 0.0.0.1
 */

public class Loto implements IOperation {

	protected int _generisanaKombinacija[];
    protected int _korisnickaKombinacija[];
    protected int _pogodjenBrojBrojeva;
    protected LotoEnum _stanje;
    protected int _trenutniRezultat;
    protected int _brojParnihGen;
    protected int _brojNeparnihGen;
    protected int _brojParnihKor;
    protected int _brojNeparnihKor;
    
    
    public int[] get_generisanaKombinacija() {
		return _generisanaKombinacija;
	}
	public void set_generisanaKombinacija(int[] _generisanaKombinacija) {
		this._generisanaKombinacija = _generisanaKombinacija;
	}
	public int[] get_korisnickaKombinacija() {
		return _korisnickaKombinacija;
	}
	public void set_korisnickaKombinacija(int[] _korisnickaKombinacija) {
		this._korisnickaKombinacija = _korisnickaKombinacija;
	}
	public int get_pogodjenBrojBrojeva() {
		return _pogodjenBrojBrojeva;
	}
	public void set_pogodjenBrojBrojeva(int _pogodjenBrojBrojeva) {
		this._pogodjenBrojBrojeva = _pogodjenBrojBrojeva;
	}
	public LotoEnum get_stanje() {
		return _stanje;
	}
	public void set_stanje(LotoEnum _stanje) {
		this._stanje = _stanje;
	}
	
	/**
	 * Konstruktor klase LOTO, bezparametarski konstruktor
	 */
	
	public Loto()
	{
	
		// instanciranje niza od 7 elemenata za generisanu kombinaciju loto brojeva
		this._generisanaKombinacija = new int[7];
		// instanciranje niza od 7 elemenata za korisnicku kombinaciju loto brojeva
		this._korisnickaKombinacija = new int[7];

		// resetovanje / inicijalizacija brojaca
		
		this._pogodjenBrojBrojeva = 0;
		this._trenutniRezultat = 0;
		this._brojNeparnihGen = 0;
		this._brojParnihGen = 0;
		this._brojNeparnihKor = 0;
		this._brojParnihKor = 0;
		
  	    // pripremiti generator nasumicnih brojeva
	  	Random rand=new Random();
	  	// trenutni broj generisanih nasumicnih brojeva - ide od 0 do 6, posto se gledaju indeksi
	  	int brojGenerisanihBrojeva=0;
	  	// dok se ne izgenerise 7 jedinstvenih nasumicnih brojeva ostaje se u petlji
	  	// krece se od 0 i ide se do 6, ukljucujuci i 6, dakle to je ukupno 7 brojeva
	  	while(brojGenerisanihBrojeva<=6)
	  	{
	  		 // generisanje nasumicnog broja iz intervala od 1 do 39
	  		 int broj=rand.nextInt(39)+1;
	  		 // proveriti da li je generisani broj vec u nizu brojeva
	  		 // prvo se proglasi da naveeni broj nije pronadjen u nizu generisanih brojeva
			 boolean brojPronadjen = false;
			 // for petljom se prolazi kroz generisani niz brojeva i koristi se brojGenerisanihBrojeva u formi granice dokle se niz generisanih brojeva proverava
			 // npr. nema smisla ici do kraja niza ako imamo samo 4 generisana broja tj. vrednost promenljive brojGenerisanihBrojeva je 3
	  		 for(int i=0;i<=brojGenerisanihBrojeva;i++)
	  		 {
	  			 // ukoliko je generisan broj pronadjen unutar generisane loto kombinacije signaliziraj da je broj pronadjen (brojPronadjen = true) i izadji iz for petlje (break;)
	             if (broj==this._generisanaKombinacija[i])
	             {
	            	 brojPronadjen = true;
                  	 break;
	             }

	  		 }
	  		 // dalje unutar while petlje, ukoliko broj nije pronadjen (!brojPronadjen) isti treba dodati u niz generisanihBrojeva, i povecati broj generisanih brojeva
	         if (!brojPronadjen) 
	         {
	       	 	this._generisanaKombinacija[brojGenerisanihBrojeva] = broj;
	       	 	brojGenerisanihBrojeva++; 
	       	 }
	  		// u while petlji se dakle ostaje sve dok se ne generisu 7 jedinstvenih brojeva iz opsega od 1 do 39
	        // i nakon izlaska iz petlje se smatra da je nasumicna loto kombinacija generisana
	  	 }
    }
	@Override
	public int Validacija(int[] array) {
		// TODO Auto-generated method stub
		
		// prenos vrednosti unetog niza
		this._korisnickaKombinacija = array;
		
		// resetovanje / inicijalizacija brojaca
		
		this._brojNeparnihGen = 0;
		this._brojNeparnihKor = 0;
		this._brojParnihGen = 0;
		this._brojParnihKor = 0;
		
		this._pogodjenBrojBrojeva = 0;

		// za svaki broj iz unete (korisnicke) kombinacije proveri da li se nalazi u generisanoj loto kombinaciji
		// index i je indeks elementa iz korisnicke loto kombinacije
		// index j je indeks elementa iz generisane loto kombinacije
		// ukoliko se broj iz korisnicke loto kombinacije nadje u generisanoj loto kombinaciji povecaj broj pogodjenih brojeva, i odmah preddji na proveru sledeceg elementa iz korisnicke loto kombinacije
		for (int i = 0; i<=this._korisnickaKombinacija.length-1; i++)
			for( int j = 0; j<=_generisanaKombinacija.length-1;j++)
			{
				if (this._korisnickaKombinacija[i]==this._generisanaKombinacija[j]) { this._pogodjenBrojBrojeva++; break; }
			}
		
		// ako je broj pogodjenih brojeva 7 stanje loto kombinacije (rezultat validacije) je sPogodjen
		if (this._pogodjenBrojBrojeva==7) this._stanje = LotoEnum.sPogodjen;
		// ako je broj pogodjenih izmedju 5 ili 6 stanje loto kombinacije (rezultat validacije) je sZamena
		if (this._pogodjenBrojBrojeva>4 && this._pogodjenBrojBrojeva<7) this._stanje = LotoEnum.sZamena;
		// ako je broj pogodjenih brojeva jednak 4 i manje stanje loto kombinacije (rezultat validacije) je sPromasen
		if (this._pogodjenBrojBrojeva<=4) this._stanje = LotoEnum.sPromasen;
		
		// racunanje trenutnog rezultata. Za svaki pogodjeni broj dodeljuje se po 100 bodova
		this._trenutniRezultat = this._pogodjenBrojBrojeva * 100;
		
		// provera koliko parnih i neparnih brojeva ima u unetoj korisnickoj kombinaciji 
		// prolazi se kroz celu korisnicku kombinaciju i proverava se da li je ostatak pri deljenju sa brojem 2 jednak nuli
		// ukoliko je navedeni ostatak jednak nuli, brojac parnih brojeva korisnicke kombinacije se povecava, u suprotnom brojac neparnih brojeva korisnicke kombinacije se povecava
		for (int i = 0; i<=this._korisnickaKombinacija.length-1; i++)
			if (this._korisnickaKombinacija[i]%2==0) this._brojParnihKor++; else this._brojNeparnihKor++;
		// provera koliko parnih i neparnih brojeva ima u generisanoj kombinaciji 
		// prolazi se kroz celu generisanu kombinaciju i proverava se da li je ostatak pri deljenju sa brojem 2 jednak nuli
		// ukoliko je navedeni ostatak jednak nuli, brojac parnih brojeva generisane kombinacije se povecava, u suprotnom brojac neparnih brojeva generisane kombinacije se povecava
		for( int j = 0; j<=this._generisanaKombinacija.length-1;j++)
			if (this._generisanaKombinacija[j]%2==0) this._brojParnihGen++; else this._brojNeparnihGen++;
		
		return this._pogodjenBrojBrojeva;
	}
	/**
	 * @return the _trenutniRezultat
	 */
	public int get_trenutniRezultat() {
		return _trenutniRezultat;
	}
	/**
	 * @param _trenutniRezultat the _trenutniRezultat to set
	 */
	public void set_trenutniRezultat(int _trenutniRezultat) {
		this._trenutniRezultat = _trenutniRezultat;
	}
	/**
	 * @return the _brojParnihGen
	 */
	public int get_brojParnihGen() {
		return _brojParnihGen;
	}
	/**
	 * @param _brojParnihGen the _brojParnihGen to set
	 */
	public void set_brojParnihGen(int _brojParnihGen) {
		this._brojParnihGen = _brojParnihGen;
	}
	/**
	 * @return the _brojNeparnihGen
	 */
	public int get_brojNeparnihGen() {
		return _brojNeparnihGen;
	}
	/**
	 * @param _brojNeparnihGen the _brojNeparnihGen to set
	 */
	public void set_brojNeparnihGen(int _brojNeparnihGen) {
		this._brojNeparnihGen = _brojNeparnihGen;
	}
	/**
	 * @return the _brojParnihKor
	 */
	public int get_brojParnihKor() {
		return _brojParnihKor;
	}
	/**
	 * @param _brojParnihKor the _brojParnihKor to set
	 */
	public void set_brojParnihKor(int _brojParnihKor) {
		this._brojParnihKor = _brojParnihKor;
	}
	/**
	 * @return the _brojNeparnihKor
	 */
	public int get_brojNeparnihKor() {
		return _brojNeparnihKor;
	}
	/**
	 * @param _brojNeparnihKor the _brojNeparnihKor to set
	 */
	public void set_brojNeparnihKor(int _brojNeparnihKor) {
		this._brojNeparnihKor = _brojNeparnihKor;
	}
}
