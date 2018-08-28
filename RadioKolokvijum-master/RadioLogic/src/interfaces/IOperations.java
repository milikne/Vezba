package interfaces;

public interface IOperations {
	
	/**
	 * Increments frequentcy by 0.5
	 * @return Incremented frequentcy
	 */
	public void PlusFreq ();
	
	/**
	 * Decrements frequentcy by 0.5
	 * @return Decremented frequentcy
	 */
	public void MinusFreq ();
	
	/**
	 * Increments Volume by 1
	 * @return Incremented Volume
	 */
	public void PlusVol();
	
	/**
	 * Decrements Volume by 1
	 * @return Decremented Volume
	 */
	public void MinusVol();

}
