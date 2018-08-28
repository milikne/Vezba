package interfaces;

import enumerations.StanjePogadjanja;

public interface IOperations {

	/**
	 * Metoda realizuje validaciju reci na osnovu unete reci
	 * @param unetaRec rec koju treba proveriti (unosi je korisnik)
	 * @return rezultat poredjenja reci
	 */
	StanjePogadjanja Validacija(String unetaRec);
}
