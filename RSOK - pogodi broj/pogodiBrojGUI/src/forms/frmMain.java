package forms;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.PogodiBroj;
import enums.StanjePogadjanja;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain {

	public JFrame frmMain;
	private JTextField txtGornjaGranica;
	private JLabel lblStatusPogadjanjaVrednost;
	private JLabel lblTrenutanBrojGreskiVrednost;
	private JLabel lblDozvoljenBrogGreskiVrednost;
	private JTextField txtUnesiBroj;
	
	protected PogodiBroj _pogodiBroj;
	private JLabel lblBrojBodovaValue;

	/**
	 * Create the application.
	 */
	public frmMain() {
		initialize();
		this._pogodiBroj = new PogodiBroj();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("Pogodi broj");
		frmMain.setResizable(false);
		frmMain.setBounds(100, 100, 338, 176);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		
		JLabel lblGornjaGranica = new JLabel("Gornja granica:");
		lblGornjaGranica.setBounds(10, 11, 87, 14);
		frmMain.getContentPane().add(lblGornjaGranica);
		
		txtGornjaGranica = new JTextField();
		txtGornjaGranica.setBounds(118, 8, 86, 20);
		frmMain.getContentPane().add(txtGornjaGranica);
		txtGornjaGranica.setColumns(10);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int gornjaGranica = Integer.parseInt(txtGornjaGranica.getText());
					_pogodiBroj.set_gornjaGranica(gornjaGranica);
					lblTrenutanBrojGreskiVrednost.setText(String.valueOf(_pogodiBroj.get_trenutanBrojGreski()));
					lblDozvoljenBrogGreskiVrednost.setText(String.valueOf(_pogodiBroj.get_brojDozvoljenihGreski()));
					lblBrojBodovaValue.setText(String.valueOf(_pogodiBroj.get_trenutanBrojBodova()));
					
				}
				catch (Exception ex)
				{
					
				}
			}
		});
		btnUnesi.setBounds(233, 7, 89, 23);
		frmMain.getContentPane().add(btnUnesi);
		
		JLabel lblStatusPogadjanja = new JLabel("Status pogadjanja : ");
		lblStatusPogadjanja.setBounds(10, 36, 98, 14);
		frmMain.getContentPane().add(lblStatusPogadjanja);
		
		lblStatusPogadjanjaVrednost = new JLabel("[0]");
		lblStatusPogadjanjaVrednost.setBounds(118, 36, 86, 14);
		frmMain.getContentPane().add(lblStatusPogadjanjaVrednost);
		
		JLabel lblTrenutanBrojGreski = new JLabel("Trenutan broj greski : ");
		lblTrenutanBrojGreski.setBounds(10, 61, 107, 14);
		frmMain.getContentPane().add(lblTrenutanBrojGreski);
		
		lblTrenutanBrojGreskiVrednost = new JLabel("[0]");
		lblTrenutanBrojGreskiVrednost.setBounds(118, 61, 26, 14);
		frmMain.getContentPane().add(lblTrenutanBrojGreskiVrednost);
		
		JLabel lblDozvoljenBrogGreski = new JLabel("Dozvoljen broj greski : ");
		lblDozvoljenBrogGreski.setBounds(142, 61, 118, 14);
		frmMain.getContentPane().add(lblDozvoljenBrogGreski);
		
		lblDozvoljenBrogGreskiVrednost = new JLabel("[0]");
		lblDozvoljenBrogGreskiVrednost.setBounds(259, 61, 26, 14);
		frmMain.getContentPane().add(lblDozvoljenBrogGreskiVrednost);
		
		JLabel lblBrojBodova = new JLabel("Broj bodova :");
		lblBrojBodova.setBounds(10, 86, 98, 14);
		frmMain.getContentPane().add(lblBrojBodova);
		
		lblBrojBodovaValue = new JLabel("[0]");
		lblBrojBodovaValue.setBounds(118, 86, 26, 14);
		frmMain.getContentPane().add(lblBrojBodovaValue);
		
		JLabel lblUnesiBroj = new JLabel("Unesi broj : ");
		lblUnesiBroj.setBounds(10, 114, 98, 14);
		frmMain.getContentPane().add(lblUnesiBroj);
		
		txtUnesiBroj = new JTextField();
		txtUnesiBroj.setColumns(10);
		txtUnesiBroj.setBounds(118, 111, 86, 20);
		frmMain.getContentPane().add(txtUnesiBroj);
		
		JButton btnPogadjaj = new JButton("Pogadjaj");
		btnPogadjaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int broj = Integer.parseInt(txtUnesiBroj.getText());
					_pogodiBroj.Pogodi(broj);
					lblStatusPogadjanjaVrednost.setText(String.valueOf(_pogodiBroj.get_stanjePogadjanja()));
					lblBrojBodovaValue.setText(String.valueOf(_pogodiBroj.get_trenutanBrojBodova()));
					lblTrenutanBrojGreskiVrednost.setText(String.valueOf(_pogodiBroj.get_trenutanBrojGreski()));
					
										
					if (_pogodiBroj.is_terminirajProgram())
					{
						if (_pogodiBroj.get_stanjePogadjanja()==StanjePogadjanja.sPogodjen) JOptionPane.showMessageDialog(null, "Trazeni broj je: " + String.valueOf(_pogodiBroj.get_trazeniBroj()), "Pogodili ste trazeni broj!" , JOptionPane.INFORMATION_MESSAGE);
						else JOptionPane.showMessageDialog(null, String.valueOf(_pogodiBroj.get_trazeniBroj()), "Trazeni broj je: " , JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
					

					

					
				}
				catch (Exception ex)
				{
					
				}
			}
		});
		btnPogadjaj.setBounds(233, 110, 89, 23);
		frmMain.getContentPane().add(btnPogadjaj);
	}
}
