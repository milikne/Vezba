package classes;

import enums.Stanje;
import interfaces.IOperations;

/**
 * Radio class. Performs basic radio operations, changing frequentcy and volume
 * Implements IOperations
 * Kolokvijum 05.06.2018. 
 * @author Nikola Corkovic SI 2/15
 * @version 1.0
 */

public class Radio implements IOperations {
	
	protected double freq;
	protected int vol;
	protected Stanje stanje;
	protected int brAkcija;
	
	/**
	 * Constructor for Radio class
	 */
	public Radio () {
		this.freq = 0;
		this.vol = 0;
		this.brAkcija = 0;
		this.stanje = Stanje.sOFF;
	}

	/**
	 * @return the freq
	 */
	public double getFreq() {
		return freq;
	}

	/**
	 * @param freq the freq to set
	 */
	public void setFreq(double freq) {
		this.freq = freq;
	}

	/**
	 * @return the vol
	 */
	public int getVol() {
		return vol;
	}

	/**
	 * @param vol the vol to set
	 */
	public void setVol(int vol) {
		this.vol = vol;
	}

	/**
	 * @return the stanje
	 */
	public Stanje getStanje() {
		return stanje;
	}

	/**
	 * @param stanje the stanje to set
	 */
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}
	
	/**
	 * @return the brAkcija
	 */
	public double getBrAkcija() {
		return brAkcija;
	}

	/**
	 * @param brAkcija the brAkcija to set
	 */
	public void setBrAkcija(int brAkcija) {
		this.brAkcija = brAkcija;
	}
	
	/**
	 * @param freq increments freq by 0.5
	 */
	public void PlusFreq () {
		if (this.freq < 108) {
			setFreq(this.freq+0.5);
			this.brAkcija++;
		}
	}
	
	/**
	 * @param freq decrements freq by 0.5
	 */
	public void MinusFreq () {
		if (this.freq > 87.5) {
			setFreq(this.freq-0.5);
			this.brAkcija++;
		}	
	}
	
	/**
	 * @param vol increments vol by 1
	 */
	public void PlusVol () {
		if (this.vol < 20) {
			setVol(this.vol+1);
			this.brAkcija++;
		}
	}
	
	/**
	 * @param vol decrements vol by 1
	 */
	public void MinusVol () {
		if (this.vol > 0) {
			setVol(this.vol-1);
			this.brAkcija++;
		}
	}
	
	/**
	 * @param brAkcija compared with limit (15)
	 */
	public void ProveraBrojac () {
		if (brAkcija == 15) {
			StanjeOUT();
		}
	}
	
	/**
	 * @param stanje set to OFF
	 */
	public void StanjeOFF () {
		setStanje(Stanje.sOFF);
		setFreq(0);
		setVol(0);
		setBrAkcija(0);
	}
	
	/**
	 * @param stanje set to ON
	 */
	public void StanjeON () {
		setStanje(Stanje.sON);
		setFreq(87.5);
		setVol(10);
		setBrAkcija(0);
	}
	
	/**
	 * @param stanje set to OUT
	 */
	public void StanjeOUT () {
		setStanje(Stanje.sOUT);
		setFreq(0);
		setVol(0);
		setBrAkcija(0);
	}
	
}
