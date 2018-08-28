package classes;

import java.util.Random;

import enums.StanjePogadjanja;
import interfaces.IOperations;

public class PogodiBroj implements IOperations {
	
	protected int _gornjaGranica;
	protected int _brojDozvoljenihGreski;
	protected int _trenutanBrojGreski;
	
	protected int _trazeniBroj;
	protected int _unetiBroj;
	
	protected StanjePogadjanja _stanjePogadjanja;
	
	protected int _trenutanBrojBodova;
	
	
	protected boolean _terminirajProgram;
	
	public boolean is_terminirajProgram() {
		return _terminirajProgram;
	}


	public void set_terminirajProgram(boolean _terminirajProgram) {
		this._terminirajProgram = _terminirajProgram;
	}


	public PogodiBroj()
	{
		this._brojDozvoljenihGreski = 0;
		this._trazeniBroj = 0;
		this._gornjaGranica = 0;
		this._stanjePogadjanja = StanjePogadjanja.sManji;
		this._terminirajProgram = false;
	}
	
	
	protected void GenerisiBroj()
	{
		Random rnd = new Random();
		this._trazeniBroj = rnd.nextInt(this._gornjaGranica)+1;
		this._brojDozvoljenihGreski = (this._trazeniBroj / 5) + 5;
		this._trenutanBrojBodova = this._brojDozvoljenihGreski * 100;
	}
	

	public int get_gornjaGranica() {
		return _gornjaGranica;
	}

	public void set_gornjaGranica(int _gornjaGranica) {
		this._gornjaGranica = _gornjaGranica;
		this.GenerisiBroj();
	}

	public int get_brojDozvoljenihGreski() {
		return _brojDozvoljenihGreski;
	}

	public void set_brojDozvoljenihGreski(int _brojDozvoljenihGreski) {
		this._brojDozvoljenihGreski = _brojDozvoljenihGreski;
	}

	public int get_trenutanBrojGreski() {
		return _trenutanBrojGreski;
	}

	public void set_trenutanBrojGreski(int _trenutanBrojGreski) {
		this._trenutanBrojGreski = _trenutanBrojGreski;
	}

	public int get_trazeniBroj() {
		return _trazeniBroj;
	}

	public void set_trazeniBroj(int _trazeniBroj) {
		this._trazeniBroj = _trazeniBroj;
	}

	public int get_unetiBroj() {
		return _unetiBroj;
	}

	public void set_unetiBroj(int _unetiBroj) {
		this._unetiBroj = _unetiBroj;
	}

	public StanjePogadjanja get_stanjePogadjanja() {
		return _stanjePogadjanja;
	}

	public void set_stanjePogadjanja(StanjePogadjanja _stanjePogadjanja) {
		this._stanjePogadjanja = _stanjePogadjanja;
	}

	public int get_trenutanBrojBodova() {
		return _trenutanBrojBodova;
	}

	public void set_trenutanBrojBodova(int _trenutanBrojBodova) {
		this._trenutanBrojBodova = _trenutanBrojBodova;
	}

	@Override
	public StanjePogadjanja Pogodi(int unetiBroj) {
		// TODO Auto-generated method stub
		
		this._unetiBroj = unetiBroj;
		if (this._trazeniBroj == this._unetiBroj) 
		{ 
			this._stanjePogadjanja = StanjePogadjanja.sPogodjen;  
			if (this._trenutanBrojGreski<5) this._trenutanBrojBodova+=500;
			this._terminirajProgram = true; 
		}
		else
		{
			if (this._trazeniBroj>this._unetiBroj) this._stanjePogadjanja = StanjePogadjanja.sVeci; else this._stanjePogadjanja = StanjePogadjanja.sManji;
			this._trenutanBrojGreski++;
			this._trenutanBrojBodova-=100;
		}
	
		
		return this._stanjePogadjanja;
	}

}
