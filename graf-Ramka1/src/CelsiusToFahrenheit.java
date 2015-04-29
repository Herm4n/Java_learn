import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CelsiusToFahrenheit extends JFrame implements ActionListener
{
	private JLabel lblCelsiusz, lblFahrenheit, lblStatus;
	private JTextField txfCelsiusz, txfFahrenheit;
	private JButton btnPrzelicz, btnWyczysc, btnZamknij;
	private JCheckBox cbxWielkoscLiter;
	private ButtonGroup bgpRozmiar;
	private JRadioButton rbnCelToFar, rbnFarToCel;
	private double temC, temF;

	public CelsiusToFahrenheit()
	{
		// Okno
		setSize(500, 300);
		setTitle("Przeliczanie stopni Celsiusza na Fahrenheita");
		setLayout(null);
		setBounds(100, 30, 500, 300);
		setResizable(false);

		// Przyciski
		btnPrzelicz = new JButton("Przelicz");
		btnPrzelicz.setBounds(350, 50, 100, 25);
		btnPrzelicz.addActionListener(this);
		add(btnPrzelicz);

		btnWyczysc = new JButton("Wyczysc");
		btnWyczysc.setBounds(350, 100, 100, 25);
		btnWyczysc.addActionListener(this);
		add(btnWyczysc);

		btnZamknij = new JButton("Zamknij");
		btnZamknij.setBounds(350, 240, 100, 25);
		btnZamknij.addActionListener(this);
		add(btnZamknij);

		// Labelki
		lblCelsiusz = new JLabel("Stopnie Celsiusza: ");
		lblCelsiusz.setBounds(50, 50, 200, 25);
		add(lblCelsiusz);

		lblFahrenheit = new JLabel("Stopnie Fahrenheita: ");
		lblFahrenheit.setBounds(50, 100, 200, 25);
		add(lblFahrenheit);

		lblStatus = new JLabel("test status");
		lblStatus.setBounds(50, 250, 300, 25);
		lblStatus.setForeground(Color.red);
		add(lblStatus);

		// TextField'y
		txfCelsiusz = new JTextField();
		txfCelsiusz.setBounds(210, 50, 50, 25);
		txfCelsiusz.addActionListener(this);
		txfCelsiusz.setToolTipText("Podaj temperature w stopniach celsiusza");
		add(txfCelsiusz);

		txfFahrenheit = new JTextField();
		txfFahrenheit.setBounds(210, 100, 50, 25);
		txfFahrenheit.setEditable(false);
		add(txfFahrenheit);
		
		// CheckBox
		cbxWielkoscLiter = new JCheckBox("Wielkie litery");
		cbxWielkoscLiter.setBounds(50, 150, 200, 25);
	//	cbxWielkoscLiter.addActionListener(this);
	//	add(cbxWielkoscLiter);

		// RadioButtony
		bgpRozmiar = new ButtonGroup();

		rbnCelToFar = new JRadioButton("Cel na Fah", true);
		rbnCelToFar.setBounds(50, 175, 200, 25);
		rbnCelToFar.addActionListener(this);
		bgpRozmiar.add(rbnCelToFar);
		add(rbnCelToFar);

		rbnFarToCel = new JRadioButton("Fah na Cel", false);
		rbnFarToCel.setBounds(50, 200, 200, 25);
		rbnFarToCel.addActionListener(this);
		bgpRozmiar.add(rbnFarToCel);
		add(rbnFarToCel);


	}

	// Logika obliczen - tutaj zawarta jest w obslodze zdarzenia
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object zrodlo = e.getSource();
		if (zrodlo == btnPrzelicz || zrodlo == txfCelsiusz)
		{				
			if (lblStatus.isValid())
			{
				lblStatus.setText("");
			}
			
			if (rbnCelToFar.isSelected())
			{
				try
				{
					temC = Double.parseDouble(txfCelsiusz.getText());
					temF = 32.0 + (9.0 / 5.0) * temC;
					txfFahrenheit.setText(String.valueOf(temF));
				} 
				catch (Exception e2)
				{
					lblStatus.setText("Niepoprawene dane wejsciowe");
					txfFahrenheit.setText("");
				}				
			}
			
			if (rbnFarToCel.isSelected())
			{
				try
				{
					temC = Double.parseDouble(txfCelsiusz.getText());
					temF = (temC - 32.0) * (5.0 / 9.0)   ;
					txfFahrenheit.setText(String.valueOf(temF));
				} 
				catch (Exception e2)
				{
					lblStatus.setText("Niepoprawene dane wejsciowe");
					txfFahrenheit.setText("");
				}	
			}
		} 
		else if (zrodlo == btnWyczysc)
		{
			txfCelsiusz.setText("");
			txfFahrenheit.setText("");
			lblStatus.setText("");
		} 
		else if (zrodlo == btnZamknij)
		{
			dispose();
		} 
		else if (zrodlo == rbnCelToFar) 
		{
			lblCelsiusz.setText("Stopnie Celsiusza");
			lblFahrenheit.setText("Stopnie Fahrenheita");
		}
		else if (zrodlo == rbnFarToCel) 
		{
			lblCelsiusz.setText("Stopnie Fahrenheita");
			lblFahrenheit.setText("Stopnie Celsiusza");
		}
	}

	public static void main(String[] args)
	{
		CelsiusToFahrenheit Window = new CelsiusToFahrenheit();
		Window.setVisible(true);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
