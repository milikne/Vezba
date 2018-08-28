package interfaces;

import enums.StanjePogadjanja;

public interface IOperations {

	/**
	 * Metoda proverava da li je uneti broj trazeni broj
	 * @param unetiBroj broj koji se pogadja
	 * @return stanje pogadjanja
	 */
	StanjePogadjanja Pogodi(int unetiBroj);
}
