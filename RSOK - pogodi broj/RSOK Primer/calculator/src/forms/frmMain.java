package forms;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;

import classes.Calculator;
import enums.EnumOperations;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain {

	public JFrame frmCalculator;
	private JTextField txtDisplay;
	
	protected Calculator _calculator;

	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
		this._calculator = new Calculator();
		
	}
	
	protected void SetFirstNumber()
	{
		if (!this._calculator.is_operationExecuted())
		{
			try
			{
				this._calculator.set_firstNumber(Double.parseDouble(txtDisplay.getText()));
				this._calculator.set_result(Double.parseDouble(txtDisplay.getText()));
			}
			catch (Exception ex)
			{
				
			}
		}
		
		txtDisplay.setText("");
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setResizable(false);
		frmCalculator.setBounds(100, 100, 278, 347);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setBounds(10, 11, 246, 41);
		frmCalculator.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		JButton btnBackSpace = new JButton("BCK");
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int textLenght = txtDisplay.getText().length();
					txtDisplay.setText(txtDisplay.getText().substring(0, textLenght-1));
				}
				catch (Exception ex)
				{
					
				}
			}
		});
		btnBackSpace.setBounds(10, 63, 118, 35);
		frmCalculator.getContentPane().add(btnBackSpace);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText("");
				_calculator = new Calculator();
			}
		});
		btnClear.setBounds(138, 63, 54, 35);
		frmCalculator.getContentPane().add(btnClear);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetFirstNumber();
				_calculator.set_operation(EnumOperations.Divide);
			}
		});
		btnDivide.setBounds(202, 63, 54, 35);
		frmCalculator.getContentPane().add(btnDivide);
		
		JButton btnSeven = new JButton("7");
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = txtDisplay.getText();
				currentText+="7";
				txtDisplay.setText(currentText);
			}
		});
		btnSeven.setBounds(10, 109, 54, 35);
		frmCalculator.getContentPane().add(btnSeven);
		
		JButton btnEight = new JButton("8");
		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = txtDisplay.getText();
				currentText+="8";
				txtDisplay.setText(currentText);
			}
		});
		btnEight.setBounds(74, 109, 54, 35);
		frmCalculator.getContentPane().add(btnEight);
		
		JButton btnNine = new JButton("9");
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = txtDisplay.getText();
				currentText+="9";
				txtDisplay.setText(currentText);
			}
		});
		btnNine.setBounds(138, 109, 54, 35);
		frmCalculator.getContentPane().add(btnNine);
		
		JButton btnMuliply = new JButton("*");
		btnMuliply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetFirstNumber();
				_calculator.set_operation(EnumOperations.Multiply);
			}
		});
		btnMuliply.setBounds(202, 109, 54, 35);
		frmCalculator.getContentPane().add(btnMuliply);
		
		JButton btnFour = new JButton("4");
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = txtDisplay.getText();
				currentText+="4";
				txtDisplay.setText(currentText);
			}
		});
		btnFour.setBounds(10, 155, 54, 35);
		frmCalculator.getContentPane().add(btnFour);
		
		JButton btnFive = new JButton("5");
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = txtDisplay.getText();
				currentText+="5";
				txtDisplay.setText(currentText);
			}
		});
		btnFive.setBounds(74, 155, 54, 35);
		frmCalculator.getContentPane().add(btnFive);
		
		JButton btnSix = new JButton("6");
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = txtDisplay.getText();
				currentText+="6";
				txtDisplay.setText(currentText);
			}
		});
		btnSix.setBounds(138, 155, 54, 35);
		frmCalculator.getContentPane().add(btnSix);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetFirstNumber();
				_calculator.set_operation(EnumOperations.Add);
			}
		});
		btnAdd.setBounds(202, 155, 54, 35);
		frmCalculator.getContentPane().add(btnAdd);
		
		JButton btnOne = new JButton("1");
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = txtDisplay.getText();
				currentText+="1";
				txtDisplay.setText(currentText);
			}
		});
		btnOne.setBounds(10, 201, 54, 35);
		frmCalculator.getContentPane().add(btnOne);
		
		JButton btnTwo = new JButton("2");
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = txtDisplay.getText();
				currentText+="2";
				txtDisplay.setText(currentText);
			}
		});
		btnTwo.setBounds(74, 201, 54, 35);
		frmCalculator.getContentPane().add(btnTwo);
		
		JButton btnThree = new JButton("3");
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = txtDisplay.getText();
				currentText+="3";
				txtDisplay.setText(currentText);
			}
		});
		btnThree.setBounds(138, 201, 54, 35);
		frmCalculator.getContentPane().add(btnThree);
		
		JButton btnSubstract = new JButton("-");
		btnSubstract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetFirstNumber();
				_calculator.set_operation(EnumOperations.Substract);
			}
		});
		btnSubstract.setBounds(202, 201, 54, 35);
		frmCalculator.getContentPane().add(btnSubstract);
		
		JButton btnChangeSign = new JButton("+/-");
		btnChangeSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String current = txtDisplay.getText();
				if (current.indexOf("-")==-1) current="-"+current;
					else current = current.replace("-", "");
				txtDisplay.setText(current);
				
				_calculator.set_result(_calculator.get_result()*-1);
				_calculator.set_firstNumber(_calculator.get_result());
				
			}
		});
		btnChangeSign.setBounds(10, 244, 54, 35);
		frmCalculator.getContentPane().add(btnChangeSign);
		
		JButton btnZero = new JButton("0");
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String currentText = txtDisplay.getText();
				currentText+="0";
				txtDisplay.setText(currentText);

			}
		});
		btnZero.setBounds(74, 244, 54, 35);
		frmCalculator.getContentPane().add(btnZero);
		
		JButton btnDecimal = new JButton(".");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String current = txtDisplay.getText();
				if (current.indexOf(".")==-1) current+=".";
				txtDisplay.setText(current);
			}
		});
		btnDecimal.setBounds(138, 244, 54, 35);
		frmCalculator.getContentPane().add(btnDecimal);
		
		JButton btnCalculate = new JButton("=");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					_calculator.set_secondNumber(Double.parseDouble(txtDisplay.getText()));
					_calculator.Execute();
					txtDisplay.setText(String.valueOf(_calculator.get_result()));
				}
				catch (Exception ex)
				{
					
				}
				

			}
		});
		btnCalculate.setBounds(202, 244, 54, 35);
		frmCalculator.getContentPane().add(btnCalculate);
		
		JMenuBar menuBarMain = new JMenuBar();
		frmCalculator.setJMenuBar(menuBarMain);
		
		JMenu mnCalculatorMenu = new JMenu("Calculator");
		menuBarMain.add(mnCalculatorMenu);
		
		JMenuItem mntmSquared = new JMenuItem("Squared");
		mntmSquared.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetFirstNumber();
				_calculator.Squared();
				txtDisplay.setText(String.valueOf(_calculator.get_result()));
			}
		});
		mnCalculatorMenu.add(mntmSquared);
		
		JMenuItem mntmSquareRoot = new JMenuItem("Square Root");
		mntmSquareRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetFirstNumber();
				_calculator.SquareRoot();
				txtDisplay.setText(String.valueOf(_calculator.get_result()));
			}
		});
		mnCalculatorMenu.add(mntmSquareRoot);
		
		JMenuItem mntmHexadecimal = new JMenuItem("Hexadecimal");
		mntmHexadecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(_calculator.ToHexadecimal());
			}
		});
		mnCalculatorMenu.add(mntmHexadecimal);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnCalculatorMenu.add(mntmExit);
	}
}
