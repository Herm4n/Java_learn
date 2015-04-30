

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class RownanieGUI extends JFrame implements ActionListener
{
	private JTextField txfA, txfB, txfC;
	private JLabel lblA, lblB, lblC, lblW;
	private JButton btnZamknij, btnOblicz, btnWyczysc;

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object zrodlo = e.getSource();
		
		if (zrodlo == btnOblicz)
		{
			try
			{
				RownanieKwadratowe rownanie = new RownanieKwadratowe(Double.parseDouble(txfA.getText()), Double.parseDouble(txfB.getText()), Double.parseDouble(txfC.getText()));
				String rozwiazanie = rownanie.obliczDelta();
				lblW.setText(rozwiazanie);
				
			} catch (Exception e2)
			{
				lblW.setText("Niepoprawne dane wejsciowe");
			}
		}
		else if (zrodlo == btnWyczysc)
		{
			txfA.setText("");
			txfB.setText("");
			txfC.setText("");
			lblW.setText("");
		}
		else if (zrodlo == btnZamknij)
		{
			dispose();
		}
				
		
		
	}
	public RownanieGUI()
	{
		setSize(500, 300);
		setTitle("Rownanie kwadratowe");
		setLayout(null);
		setBounds(100, 100, 500, 300);
		setResizable(false);
		
//		Labelki
		lblA = new JLabel("Podaj wspolczynnik A:");
		lblA.setBounds(50, 50, 200, 25);
		add(lblA);
		
		lblB = new JLabel("Podaj wspolczynnik B:");
		lblB.setBounds(50, 75, 200, 25);
		add(lblB);
		
		lblC = new JLabel("Podaj wspolczynnik C:");
		lblC.setBounds(50, 100, 200, 25);
		add(lblC);
		
		lblW = new JLabel("");
		lblW.setBounds(50, 150, 400, 25);
		add(lblW);
		
//		TextField'y do wprowadzania liczb
		txfA = new JTextField();
		txfA.setBounds(200, 50, 200, 25);
		add(txfA);
		
		txfB = new JTextField();
		txfB.setBounds(200, 75, 200, 25);
		add(txfB);
		
		txfC = new JTextField();
		txfC.setBounds(200, 100, 200, 25);
		add(txfC);
		
//		Przyciski
		btnOblicz = new JButton("Oblicz");
		btnOblicz.setBounds(50, 240, 100, 25);
		btnOblicz.addActionListener(this);
		add(btnOblicz);
		
		btnWyczysc = new JButton("Wyczysc");
		btnWyczysc.setBounds(150, 240, 100, 25);
		btnWyczysc.addActionListener(this);
		add(btnWyczysc);
		
		btnZamknij = new JButton("Zamknij");
		btnZamknij.setBounds(350, 240, 100, 25);
		btnZamknij.addActionListener(this);
		add(btnZamknij);
	}
	
	public static void main(String[] args)
	{
		RownanieGUI Window = new RownanieGUI();
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setVisible(true);

	}

}
