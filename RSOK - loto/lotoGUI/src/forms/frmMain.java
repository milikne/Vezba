package forms;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import classes.Loto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain {

	public JFrame frmLoto;
	// polje za unos broja
	private JTextField txtUnos;
	// definicija promenljive Loto;
	protected Loto _lotoLogic;
	// lokalna promenljiva za uneti niz
	protected int _niz[];
	// brojac unetih brojeva (za korisnicki interfejs)
	protected int _brojUnetihBrojeva;
	// labele koje ce ispisivati vrednosti validacije loto kombinacije, kao i unetu i generisanu loto kombinaciju
	private JLabel lblUnetaLotoKombinacijaVrednost;
	private JLabel lblGenerisanaLotoKombinacijaVrednosti;
	private JLabel lblBrojParnihUnetaKombinacijaVrednost;
	private JLabel lblBrojNeparnihUnetaKombinacijaVrednost;
	private JLabel lblBrojParnihGenerisanaKombinacijaVrednost;
	private JLabel lblBrojNeparnihGenerisanaKombinacijaVrednost;
	private JLabel lblBrojPogodjenihBrojevaVrednost;
	private JLabel lblStatusKombinacijeVrednost;


	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
		
		// instanciranje objekta tipa Loto (putem ove promenljive se radi sve)
		this._lotoLogic = new Loto();
		// niz ce imati 7 elemenata kao i loto kombinacija
		this._niz = new int[7];
		// inicijalizacija brojaca unetih brojeva
		this._brojUnetihBrojeva = 0;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoto = new JFrame();
		frmLoto.setTitle("LOTO");
		frmLoto.setResizable(false);
		frmLoto.setBounds(100, 100, 387, 303);
		frmLoto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoto.getContentPane().setLayout(null);
		
		JLabel lblBroj = new JLabel("Broj :");
		lblBroj.setBounds(10, 11, 33, 14);
		frmLoto.getContentPane().add(lblBroj);
		
		txtUnos = new JTextField();
		txtUnos.setBounds(45, 8, 86, 20);
		frmLoto.getContentPane().add(txtUnos);
		txtUnos.setColumns(10);
		
		JLabel lblBrojUnetihBrojeva = new JLabel("Broj unetih brojeva: ");
		lblBrojUnetihBrojeva.setBounds(141, 11, 99, 14);
		frmLoto.getContentPane().add(lblBrojUnetihBrojeva);
		
		JLabel lblBrojUnetihBrojevaVrednost = new JLabel("[0]");
		lblBrojUnetihBrojevaVrednost.setBounds(250, 11, 25, 14);
		frmLoto.getContentPane().add(lblBrojUnetihBrojevaVrednost);
		
		JLabel lblUnetaLotoKombinacija = new JLabel("Uneta loto kombinacija :");
		lblUnetaLotoKombinacija.setBounds(10, 36, 141, 14);
		frmLoto.getContentPane().add(lblUnetaLotoKombinacija);
		
		JButton btnUnos = new JButton("Unos");
		btnUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// ako se unese 7 brojeva ne dozvoli vise unos, odmah se vrati iz metode
				if (_brojUnetihBrojeva>=7) return;
				
				// try - catch blok za hvatanje greski
				// ukoliko unos sa tekstboksa ne moze da se pretvori u integer, program ce uci u stanje za obradu greske
				// ukoliko ne moze da se pretvori u integer kod ispod linije u kojoj se poziva funkcija parseInt se ne poziva vec se skace na catch blok koji je prazan
				// dakle ako ne mozes da izparsiras broj nemoj nista da radis
				try
				{
					// konvertuj broje
					int unetBroj = Integer.parseInt(txtUnos.getText());
					// smesti ga u niz na poziciju
					_niz[_brojUnetihBrojeva] = unetBroj;
					// inkrementuj poziciju za slececu iteraciju
					_brojUnetihBrojeva++;
					// javi koliko ima brojeva u nizu
					lblBrojUnetihBrojevaVrednost.setText(String.valueOf(_brojUnetihBrojeva));
					
				}
				catch (Exception ex)
				{
					
				}
				
			}
		});
		btnUnos.setBounds(282, 7, 89, 23);
		frmLoto.getContentPane().add(btnUnos);
		
		lblUnetaLotoKombinacijaVrednost = new JLabel("[0]");
		lblUnetaLotoKombinacijaVrednost.setBounds(161, 36, 210, 14);
		frmLoto.getContentPane().add(lblUnetaLotoKombinacijaVrednost);
		
		JLabel lblGenerisanaLotoKombinacija = new JLabel("Generisana loto kombinacija :");
		lblGenerisanaLotoKombinacija.setBounds(10, 61, 140, 14);
		frmLoto.getContentPane().add(lblGenerisanaLotoKombinacija);
		
		lblGenerisanaLotoKombinacijaVrednosti = new JLabel("[0]");
		lblGenerisanaLotoKombinacijaVrednosti.setBounds(161, 61, 210, 14);
		frmLoto.getContentPane().add(lblGenerisanaLotoKombinacijaVrednosti);
		
		JLabel lblBrojParnihUnetaKombinacija = new JLabel("Broj parnih (Uneta) :");
		lblBrojParnihUnetaKombinacija.setBounds(10, 136, 141, 14);
		frmLoto.getContentPane().add(lblBrojParnihUnetaKombinacija);
		
		lblBrojParnihUnetaKombinacijaVrednost = new JLabel("[0]");
		lblBrojParnihUnetaKombinacijaVrednost.setBounds(161, 136, 46, 14);
		frmLoto.getContentPane().add(lblBrojParnihUnetaKombinacijaVrednost);
		
		JLabel lblBrojNeparnihUnetaKombinacija = new JLabel("Broj neparnih (Uneta) :");
		lblBrojNeparnihUnetaKombinacija.setBounds(10, 161, 141, 14);
		frmLoto.getContentPane().add(lblBrojNeparnihUnetaKombinacija);
		
		lblBrojNeparnihUnetaKombinacijaVrednost = new JLabel("[0]");
		lblBrojNeparnihUnetaKombinacijaVrednost.setBounds(161, 161, 46, 14);
		frmLoto.getContentPane().add(lblBrojNeparnihUnetaKombinacijaVrednost);
		
		JLabel lblBrojParnihGenerisanaKombinacija = new JLabel("Broj parnih (Generisana) :");
		lblBrojParnihGenerisanaKombinacija.setBounds(10, 186, 141, 14);
		frmLoto.getContentPane().add(lblBrojParnihGenerisanaKombinacija);
		
		lblBrojParnihGenerisanaKombinacijaVrednost = new JLabel("[0]");
		lblBrojParnihGenerisanaKombinacijaVrednost.setBounds(161, 186, 46, 14);
		frmLoto.getContentPane().add(lblBrojParnihGenerisanaKombinacijaVrednost);
		
		lblBrojNeparnihGenerisanaKombinacijaVrednost = new JLabel("[0]");
		lblBrojNeparnihGenerisanaKombinacijaVrednost.setBounds(161, 211, 46, 14);
		frmLoto.getContentPane().add(lblBrojNeparnihGenerisanaKombinacijaVrednost);
		
		JLabel lblBrojNeparnihGenerisanaKombinacija = new JLabel("Broj neparnih (Generisana) :");
		lblBrojNeparnihGenerisanaKombinacija.setBounds(10, 211, 141, 14);
		frmLoto.getContentPane().add(lblBrojNeparnihGenerisanaKombinacija);
		
		JButton btnValidacija = new JButton("Validacija");
		btnValidacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// pozovi metodu validacija iz objekta lotoLogic prosledjivanjem korisnicki definisanog niza
				_lotoLogic.Validacija(_niz);
				
				// string za ispis unete loto kombinacije
				String unetaLotoKombinacija = "";
				// sting za ispit generisane loto kombinacije
				String generisanaLotoKombinacija = "";
				
				// prodji kroz unetu korisnicku kombinaciju, i formiraj string koji sadrzi vrednosti spomenute kombinacije
				// koji su odvojeni zarezom. npr izlazni (formirani) string treba da bude 32, 5, 6, 11, 7, 23, 4
				for(int i = 0; i<=_lotoLogic.get_korisnickaKombinacija().length-1;i++)
					unetaLotoKombinacija+=String.valueOf(_lotoLogic.get_korisnickaKombinacija()[i])+", ";
				// prodji kroz unetu generisanu kombinaciju, i formiraj string koji sadrzi vrednosti spomenute kombinacije
				// koji su odvojeni zarezom. npr izlazni (formirani) string treba da bude 32, 5, 6, 11, 7, 23, 4
				for(int i = 0; i<=_lotoLogic.get_generisanaKombinacija().length-1;i++)
					generisanaLotoKombinacija+=String.valueOf(_lotoLogic.get_generisanaKombinacija()[i])+", ";
			
				// ispis unete loto kombinacije
				lblUnetaLotoKombinacijaVrednost.setText(unetaLotoKombinacija);
				// ispis generisane loto kombinacije
				lblGenerisanaLotoKombinacijaVrednosti.setText(generisanaLotoKombinacija);
				// ispis rezultata validacije u labele
				lblBrojPogodjenihBrojevaVrednost.setText(String.valueOf(_lotoLogic.get_pogodjenBrojBrojeva()));
				lblStatusKombinacijeVrednost.setText(String.valueOf(_lotoLogic.get_stanje()));
				lblBrojParnihUnetaKombinacijaVrednost.setText(String.valueOf(_lotoLogic.get_brojParnihKor()));
				lblBrojNeparnihUnetaKombinacijaVrednost.setText(String.valueOf(_lotoLogic.get_brojNeparnihKor()));
				lblBrojParnihGenerisanaKombinacijaVrednost.setText(String.valueOf(_lotoLogic.get_brojParnihGen()));
				lblBrojNeparnihGenerisanaKombinacijaVrednost.setText(String.valueOf(_lotoLogic.get_brojNeparnihGen()));
				
				
			}
		});
		btnValidacija.setBounds(10, 236, 361, 29);
		frmLoto.getContentPane().add(btnValidacija);
		
		JLabel lblBrojPogodjenihBrojeva = new JLabel("Broj pogodjenih brojeva :");
		lblBrojPogodjenihBrojeva.setBounds(10, 86, 141, 14);
		frmLoto.getContentPane().add(lblBrojPogodjenihBrojeva);
		
		lblBrojPogodjenihBrojevaVrednost = new JLabel("[0]");
		lblBrojPogodjenihBrojevaVrednost.setBounds(161, 86, 46, 14);
		frmLoto.getContentPane().add(lblBrojPogodjenihBrojevaVrednost);
		
		JLabel lblStatusKombinacije = new JLabel("Status kombinacije :");
		lblStatusKombinacije.setBounds(10, 111, 141, 14);
		frmLoto.getContentPane().add(lblStatusKombinacije);
		
		lblStatusKombinacijeVrednost = new JLabel("[0]");
		lblStatusKombinacijeVrednost.setBounds(161, 111, 114, 14);
		frmLoto.getContentPane().add(lblStatusKombinacijeVrednost);
	}
}
