package classes;

import java.util.ArrayList;
import java.util.Random;

import enumerations.StanjePogadjanja;
import interfaces.IOperations;

public class PogodiRec implements IOperations {

	protected int _brojSlova;
	protected int _brojDozvoljenihGreski;
	protected int _brojTrenutnihGreski;
	
	protected String _trazenaRec;
	protected String _unetaRec;
	
	protected ArrayList<String> _sveReci;
	protected StanjePogadjanja _stanjePogadjanja;
	
	protected boolean _terminirajProgram;
	protected int _trenutniBrojBodova;
	
	
	
	
	/**
	 * Konstruktor klase PogodiRec
	 */
	
	public PogodiRec()
	{
		// recinik
		this._sveReci = new ArrayList<String>();
		this._sveReci.add("Autobus");
		this._sveReci.add("Voda");
		this._sveReci.add("Stefan");
		this._sveReci.add("Zorica");
		
		// biranje indeksa nasumicne reci
		Random rnd = new Random();
		int indeksReci = rnd.nextInt(this._sveReci.size());
		// izbor nasumicne reci
		this._trazenaRec = this._sveReci.get(indeksReci);
		// broj slova nasumicne reci
		this._brojSlova = this._trazenaRec.length();
		// broj dozvozvoljenih greski
		this._brojDozvoljenihGreski = this._brojSlova + 5;
		
		this._unetaRec = "";
		this._brojTrenutnihGreski = 0;
		this._stanjePogadjanja = StanjePogadjanja.sNijePogodjena;
		
		// terminiraj program
		this._terminirajProgram = false;
		// trenutni broj bodova
		this._trenutniBrojBodova = this._brojDozvoljenihGreski * 100;
			
	}

	/**
	 * @return the _brojSlova
	 */
	public int get_brojSlova() {
		return _brojSlova;
	}


	/**
	 * @param _brojSlova the _brojSlova to set
	 */
	public void set_brojSlova(int _brojSlova) {
		this._brojSlova = _brojSlova;
	}


	/**
	 * @return the _brojDozvoljenihGreski
	 */
	public int get_brojDozvoljenihGreski() {
		return _brojDozvoljenihGreski;
	}


	/**
	 * @param _brojDozvoljenihGreski the _brojDozvoljenihGreski to set
	 */
	public void set_brojDozvoljenihGreski(int _brojDozvoljenihGreski) {
		this._brojDozvoljenihGreski = _brojDozvoljenihGreski;
	}


	/**
	 * @return the _brojTrenutnihGreski
	 */
	public int get_brojTrenutnihGreski() {
		return _brojTrenutnihGreski;
	}


	/**
	 * @param _brojTrenutnihGreski the _brojTrenutnihGreski to set
	 */
	public void set_brojTrenutnihGreski(int _brojTrenutnihGreski) {
		this._brojTrenutnihGreski = _brojTrenutnihGreski;
	}


	/**
	 * @return the _trazenaRec
	 */
	public String get_trazenaRec() {
		return _trazenaRec;
	}


	/**
	 * @param _trazenaRec the _trazenaRec to set
	 */
	public void set_trazenaRec(String _trazenaRec) {
		this._trazenaRec = _trazenaRec;
	}


	/**
	 * @return the _unetaRec
	 */
	public String get_unetaRec() {
		return _unetaRec;
	}


	/**
	 * @param _unetaRec the _unetaRec to set
	 */
	public void set_unetaRec(String _unetaRec) {
		this._unetaRec = _unetaRec;
	}


	/**
	 * @return the _sveReci
	 */
	public ArrayList<String> get_sveReci() {
		return _sveReci;
	}


	/**
	 * @param _sveReci the _sveReci to set
	 */
	public void set_sveReci(ArrayList<String> _sveReci) {
		this._sveReci = _sveReci;
	}


	/**
	 * @return the _stanjePogadjanja
	 */
	public StanjePogadjanja get_stanjePogadjanja() {
		return _stanjePogadjanja;
	}


	/**
	 * @param _stanjePogadjanja the _stanjePogadjanja to set
	 */
	public void set_stanjePogadjanja(StanjePogadjanja _stanjePogadjanja) {
		this._stanjePogadjanja = _stanjePogadjanja;
	}

	@Override
	public StanjePogadjanja Validacija(String unetaRec) {
		// TODO Auto-generated method stub
		
		this._unetaRec = unetaRec;
		boolean pogodjenaRec = false;
		
		// prebaci sva slova u mala, ukloni razmake pre i posle reci
		if (this._trazenaRec.toLowerCase().trim().equals(this._unetaRec.toLowerCase().trim()))
		{ 
			this._stanjePogadjanja = StanjePogadjanja.sPogodjena;
			pogodjenaRec = true;
			if (this._brojTrenutnihGreski<=5) this._trenutniBrojBodova+=500;
		}
		else 
		{ 
			this._stanjePogadjanja = StanjePogadjanja.sNijePogodjena; 
			this._brojTrenutnihGreski++;
			this._trenutniBrojBodova-=100;
		}
		
		if (!pogodjenaRec)
		{
			if (this._trazenaRec.toLowerCase().trim().contains(this._unetaRec.toLowerCase().trim())) 
				this._stanjePogadjanja = StanjePogadjanja.sPodrec;
		}
		
		if (this._brojTrenutnihGreski>=this._brojDozvoljenihGreski) this._terminirajProgram = true;
		
		
		
		return this._stanjePogadjanja;
	}

	/**
	 * @return the _terminirajProgram
	 */
	public boolean is_terminirajProgram() {
		return _terminirajProgram;
	}

	/**
	 * @param _terminirajProgram the _terminirajProgram to set
	 */
	public void set_terminirajProgram(boolean _terminirajProgram) {
		this._terminirajProgram = _terminirajProgram;
	}

	/**
	 * @return the _trenutniBrojBodova
	 */
	public int get_trenutniBrojBodova() {
		return _trenutniBrojBodova;
	}

	/**
	 * @param _trenutniBrojBodova the _trenutniBrojBodova to set
	 */
	public void set_trenutniBrojBodova(int _trenutniBrojBodova) {
		this._trenutniBrojBodova = _trenutniBrojBodova;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
