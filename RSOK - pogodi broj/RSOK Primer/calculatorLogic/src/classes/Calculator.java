package classes;

import enums.EnumOperations;
import interfaces.IAdditionalFeatures;
import interfaces.IOperations;

/**
 * Calcurator class. Performs selected operation over two numbers and returns a result.
 * Implements IOperations, IAdditionalFeatures
 * @author Predrag Pecev
 * @version 0.3
 */

public class Calculator implements IOperations, IAdditionalFeatures {

	protected double _firstNumber;
	protected double _secondNumber;
	protected double _result;
	
	protected boolean _operationExecuted;
	protected EnumOperations _operation;
	
	/**
	 * Constructor for Calculator class
	 */
	
	public Calculator()
	{
		this._firstNumber = 0;
		this._secondNumber = 0;
		this._result = 0;
		this._operationExecuted = false;
		this._operation = EnumOperations.None;
	}
	
	/**
	 * 
	 * @param firstNumber prvi broj	
	 * @param secondNumber drugi broj
	 */
	
	public Calculator(int firstNumber, int secondNumber)
	{
		
	}
	
	/**
	 * @return the _firstNumber
	 */
	public double get_firstNumber() {
		return _firstNumber;
	}
	/**
	 * @param _firstNumber the _firstNumber to set
	 */
	public void set_firstNumber(double _firstNumber) {
		this._firstNumber = _firstNumber;
	}
	/**
	 * @return the _secondNumber
	 */
	public double get_secondNumber() {
		return _secondNumber;
	}
	/**
	 * @param _secondNumber the _secondNumber to set
	 */
	public void set_secondNumber(double _secondNumber) {
		this._secondNumber = _secondNumber;
	}
	/**
	 * @return the _result
	 */
	public double get_result() {
		return _result;
	}
	/**
	 * @param _result the _result to set
	 */
	public void set_result(double _result) {
		this._result = _result;
	}
	/**
	 * @return the _operationExecuted
	 */
	public boolean is_operationExecuted() {
		return _operationExecuted;
	}
	/**
	 * @param _operationExecuted the _operationExecuted to set
	 */
	public void set_operationExecuted(boolean _operationExecuted) {
		this._operationExecuted = _operationExecuted;
	}
	/**
	 * @return the _operation
	 */
	public EnumOperations get_operation() {
		return _operation;
	}
	/**
	 * @param _operation the _operation to set
	 */
	public void set_operation(EnumOperations _operation) {
		this._operation = _operation;
	}
	
	/**
	 * Ovo vise ne radi ADD nego Korenovanje
	 */
	
	@Override
	public double Add() {
		// TODO Auto-generated method stub
		
		this._result = this._firstNumber + this._secondNumber;
		this._firstNumber = this._result;
		
		return this._result;
	}

	@Override
	public double Substract() {
		// TODO Auto-generated method stub
		this._result = this._firstNumber - this._secondNumber;
		this._firstNumber = this._result;
		
		return this._result;
	}

	@Override
	public double Mulultiply() {
		// TODO Auto-generated method stub
		this._result = this._firstNumber * this._secondNumber;
		this._firstNumber = this._result;
		
		return this._result;
	}

	@Override
	public double Divide() {
		// TODO Auto-generated method stub
		this._result = this._firstNumber / this._secondNumber;
		this._firstNumber = this._result;
		
		return this._result;
	}

	@Override
	public double Execute() {
		// TODO Auto-generated method stub
		
		this._operationExecuted = true;
		
		switch(this._operation)
		{
			case Add: { return this.Add(); }
			case Substract : { return this.Substract(); }
			case Divide : { return this.Divide();}
			case Multiply: { return this.Mulultiply();}
			case None: { break; }
		}
		
		return 0;
	}

	@Override
	public double Squared() {
		// TODO Auto-generated method stub
		this._result = this._firstNumber * this._firstNumber;
		this._firstNumber = this._result;
		return this._result;
	}

	@Override
	public double SquareRoot() {
		// TODO Auto-generated method stub
		this._result = Math.sqrt(this._firstNumber);
		this._firstNumber = this._result;
		return this._result;
	}

	@Override
	public String ToHexadecimal() {
		// TODO Auto-generated method stub
		this._result = this._firstNumber;
		return Double.toHexString(this._result);
		
	}
	
	
	
}
