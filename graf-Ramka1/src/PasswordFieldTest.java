import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.NotActiveException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.StyledEditorKit.BoldAction;


public class PasswordFieldTest extends JFrame implements ActionListener
{
	private PanelHasla PanelHasla;
	private JTextArea txaNotatnik;
	private JScrollPane scrollPane;
	private JButton btnDodajUzytkownika;
	
	public PasswordFieldTest()
	{
		setTitle("Test hasla");
		setSize(400 , 400);
		setLayout(null);
		
		txaNotatnik = new JTextArea();
		txaNotatnik.setWrapStyleWord(true);
		scrollPane = new JScrollPane(txaNotatnik);
		scrollPane.setBounds(0, 0, 300, 300);
		add(scrollPane);
		
		btnDodajUzytkownika = new JButton("Dodaj uzytkownika");
		btnDodajUzytkownika.setBounds(50, 330, 160, 25);
		btnDodajUzytkownika.addActionListener(this);
		add(btnDodajUzytkownika);
	}
	
	
	
	public static void main(String[] args)
	{
		PasswordFieldTest app = new PasswordFieldTest();
		app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		app.setVisible(true);

	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (PanelHasla == null)
		{
			PanelHasla = new PanelHasla(this);
		}
		PanelHasla.setVisible(true);
		PanelHasla.setFocus();
		
		if (PanelHasla.isOK() == true)
		{
			txaNotatnik.append(PanelHasla.getUser() + " , ");
			txaNotatnik.append(PanelHasla.getPassword() + "\n");
		}
		else if (PanelHasla.isOK() == false)
		{
			
		}
//		JOptionPane.showMessageDialog(this, Arrays.toString(psfHaslo.getPassword()));
//		JOptionPane.showMessageDialog(this, String.valueOf(psfHaslo.getPassword()));
//		JOptionPane.showMessageDialog(this, new String(psfHaslo.getPassword()));
	}

}

class PanelHasla extends JDialog implements ActionListener
{
	private JLabel lblUser, lblHaslo;
	private JTextField txfUser, txfHaslo;
	private JPasswordField psfHaslo;
	private JButton btnOk, btnCancel;
	private Boolean okData;
	
	public PanelHasla(JFrame owner)
	{
		super(owner, "Wprowadz haslo", true);
		setSize(300 , 200);
		setLayout(null);
		
		lblUser = new JLabel("Uzytkownik", JLabel.RIGHT);
		lblUser.setBounds(0, 0, 100, 25);
		add(lblUser);
		
		txfUser = new JTextField();
		txfUser.setBounds(120, 0, 100, 25);
		add(txfUser);
		
		
		lblHaslo = new JLabel("Haslo", JLabel.RIGHT);
		lblHaslo.setBounds(0, 30, 100, 25);
		add(lblHaslo);
		
		psfHaslo = new JPasswordField();
		psfHaslo.setBounds(50, 50, 150, 25);
		psfHaslo.setBounds(120, 30, 100, 25);
		psfHaslo.addActionListener(this);
		add(psfHaslo);
		
		
		btnOk = new JButton("OK");
		btnOk.setBounds(0, 100, 100, 25);
		btnOk.addActionListener(this);
		add(btnOk);
		
		btnCancel = new JButton("Anuluj");
		btnCancel.setBounds(100, 100, 100, 25);
		btnCancel.addActionListener(this);
		add(btnCancel);
	}
	
	public String getUser()
	{
		return txfUser.getText();
	}
	public String getPassword()
	{
		return String.valueOf(psfHaslo.getPassword());
	}
	public boolean isOK()
	{
		return okData;
	}
	
	public void setFocus()
	{
		txfUser.requestFocusInWindow();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object z = e.getSource();
		if (z == btnOk)
		{
			okData = true;
		}
		else if (z == btnCancel)
		{
			okData = false;
		}
		setVisible(false);
	}
	
}

