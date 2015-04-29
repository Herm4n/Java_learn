import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Okienko extends JFrame implements ActionListener
{
	JButton btnPodajDate, btnWyjscie, btnWyswietlNapis;
	JLabel lblWyswietlDate, lblWyswietlNapis;
	int licznikKlikow = 0;
	
	
	public Okienko()
	{
		// setSize(300, 300);
		setTitle("Moje pierwsze okienko");
		setLayout(null);
		setBounds(1700, 200, 500, 300);

//		Przyciski
		btnPodajDate = new JButton("Podaj datę");
		btnPodajDate.setBounds(50, 50, 150, 25);
		btnPodajDate.addActionListener(this);
		
		btnWyswietlNapis =new JButton("Wyświetl napis");
		btnWyswietlNapis.setBounds(50, 85, 150, 25);
		btnWyswietlNapis.addActionListener(this);
		
		btnWyjscie = new JButton("Zamknij");
		btnWyjscie.setBounds(320, 240, 150, 25);
		btnWyjscie.addActionListener(this);
		
		add(btnPodajDate);
		add(btnWyswietlNapis);
		add(btnWyjscie);
		
//		Labelki
		lblWyswietlDate = new JLabel("Data: ");
		lblWyswietlDate.setBounds(250, 50, 200, 25);
		lblWyswietlDate.setForeground(Color.CYAN);
		
		lblWyswietlNapis = new JLabel("Napis: ");
		lblWyswietlNapis.setBounds(250, 85, 250, 25);
		lblWyswietlNapis.setForeground(new Color(68, 239, 9));
		lblWyswietlNapis.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		add(lblWyswietlDate);
		add(lblWyswietlNapis);
	}

	public static void main(String[] args)
	{
		Okienko okienko = new Okienko();
		okienko.setVisible(true);
		okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object zrodlo = e.getSource();
		if (zrodlo == btnPodajDate)
		{
			lblWyswietlDate.setText(new Date().toString());
//			System.out.println(new Date());	
		}
		else if (zrodlo == btnWyswietlNapis) 
		{
			licznikKlikow ++;
			lblWyswietlNapis.setText("Kliknięcie numer: " + licznikKlikow);
//			System.out.println("Klikniecie numer: " + licznikKlikow);
		}
		else if (zrodlo == btnWyjscie)
		{
			dispose();
		}
	}
	
}
