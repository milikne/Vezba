package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Radio;
import enums.Stanje;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UISwing extends JFrame {

	private JPanel contentPane;
	private JTextField txtMhz;
	private JTextField txtVol;
	private JButton btnON;
	private JButton btnOFF;
	private JButton btnPlusVol;
	private JButton btnMinusVol;
	private JButton btnMinusMhz;
	private JButton btnPlusMhz;

	protected Radio Radio;
	private JButton btnPopravi;
	
	/*
	 * Create the application.
	 */
	public UISwing () {
		frame();
		this.Radio = new Radio();
		setOFFState();
	}
	
	protected void setONState() {
		Radio.StanjeON();
		txtMhz.setText(String.valueOf(Radio.getFreq()));
		txtVol.setText(String.valueOf(Radio.getVol()));
		btnON.setEnabled(false);
		btnOFF.setEnabled(true);
		btnPlusVol.setEnabled(true);
		btnMinusVol.setEnabled(true);
		btnPlusMhz.setEnabled(true);
		btnMinusMhz.setEnabled(true);
		btnPopravi.setEnabled(false);
	}
	
	protected void setOFFState() {
		Radio.StanjeOFF();
		txtMhz.setText("");
		txtVol.setText("");
		btnPlusVol.setEnabled(false);
		btnMinusVol.setEnabled(false);
		btnPlusMhz.setEnabled(false);
		btnMinusMhz.setEnabled(false);
		btnOFF.setEnabled(false);
		btnON.setEnabled(true);
		btnPopravi.setEnabled(false);
	}
	
	protected void setOUTState() {
		Radio.StanjeOUT();
		txtMhz.setText("");
		txtVol.setText("");
		btnPlusVol.setEnabled(false);
		btnMinusVol.setEnabled(false);
		btnPlusMhz.setEnabled(false);
		btnMinusMhz.setEnabled(false);
		btnOFF.setEnabled(false);
		btnON.setEnabled(false);
		btnPopravi.setEnabled(true);
	}
	
	protected void StateCheck() {
		if (Radio.getStanje() == Stanje.sOUT) {
			setOUTState();
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public void frame() {
		setTitle("Radio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMhz = new JTextField();
		txtMhz.setHorizontalAlignment(SwingConstants.CENTER);
		txtMhz.setEditable(false);
		txtMhz.setBounds(10, 11, 264, 38);
		contentPane.add(txtMhz);
		txtMhz.setColumns(10);
		
		btnMinusMhz = new JButton("-0.5Mhz");
		btnMinusMhz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Radio.MinusFreq();
				Radio.ProveraBrojac();
				StateCheck();
				txtMhz.setText(String.valueOf(Radio.getFreq()));
			}
		});
		btnMinusMhz.setBounds(10, 60, 120, 38);
		contentPane.add(btnMinusMhz);
		
		btnPlusMhz = new JButton("+0.5Mhz");
		btnPlusMhz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Radio.PlusFreq();
				Radio.ProveraBrojac();
				StateCheck();
				txtMhz.setText(String.valueOf(Radio.getFreq()));
			}
		});
		btnPlusMhz.setBounds(154, 60, 120, 38);
		contentPane.add(btnPlusMhz);
		
		txtVol = new JTextField();
		txtVol.setHorizontalAlignment(SwingConstants.CENTER);
		txtVol.setEditable(false);
		txtVol.setBounds(10, 109, 50, 86);
		contentPane.add(txtVol);
		txtVol.setColumns(10);
		
		btnON = new JButton("ON");
		btnON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setONState();
			}
		});
		btnON.setBounds(154, 109, 120, 38);
		contentPane.add(btnON);
		
		btnOFF = new JButton("OFF");
		btnOFF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setOFFState();
			}
		});
		btnOFF.setBounds(154, 158, 120, 38);
		contentPane.add(btnOFF);
		
		btnPlusVol = new JButton("+");
		btnPlusVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Radio.PlusVol();
				Radio.ProveraBrojac();
				StateCheck();
				txtVol.setText(String.valueOf(Radio.getVol()));
			}
		});
		btnPlusVol.setBounds(70, 109, 60, 38);
		contentPane.add(btnPlusVol);
		
		btnMinusVol = new JButton("-");
		btnMinusVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Radio.MinusVol();
				Radio.ProveraBrojac();
				StateCheck();
				txtVol.setText(String.valueOf(Radio.getVol()));
			}
		});
		btnMinusVol.setBounds(70, 158, 60, 38);
		contentPane.add(btnMinusVol);
		
		btnPopravi = new JButton("Popravi");
		btnPopravi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setOFFState();
			}
		});
		btnPopravi.setBounds(10, 210, 260, 23);
		contentPane.add(btnPopravi);
	}
}
