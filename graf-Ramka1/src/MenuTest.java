import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class MenuTest extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JButton btnSzukaj, btnWybierzKolor;
	JTextField txfSzukany;
	JPopupMenu popMenu;
	JMenu menuPlik, menuNarzedzia, menuPomoc, menuPodmenu, menuOpcje;
	JMenuItem mOtworz, mZapisz, mZamknij, mNarz1, mNarz2, mNarz3, mOPrograme, mStronaWWW, mOpcja1, mOpcja2, mpoKopiuj, mpoWklej, mpoDolacz;
	JCheckBoxMenuItem cbmOpcja1, cbmOpcja2;
	JComboBox<String> cbxKolorKombo;
	JTextArea notatnik;
	String wybranyTekst;
	
	public MenuTest()
	{
		setTitle("Demonstracja JMenuBar");
		setSize(500, 500);
		setBounds(100, 100, 500, 650);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		******************************************************************************************
//		********************************* IMPLEMENTACJA MENU *************************************
//		******************************************************************************************
		menuBar = new JMenuBar();
		menuPlik = new JMenu("Plik");
		menuNarzedzia = new JMenu("Narzedzia");
		menuPomoc = new JMenu("Pomoc");
		
		setJMenuBar(menuBar);
//		MENU PLIK
		menuBar.add(menuPlik);
		
		mOtworz = new JMenuItem("Otworz", 'O');
		mOtworz.addActionListener(this);
		menuPlik.add(mOtworz);
		
		mZapisz = new JMenuItem("Zapisz");
		mZapisz.addActionListener(this);
		menuPlik.add(mZapisz);
		
		menuPlik.addSeparator();
		
		mZamknij = new JMenuItem("Zamknij");
		mZamknij.addActionListener(this);
		mZamknij.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
		menuPlik.add(mZamknij);
		
		
//		MENU NARZEDZIA
		menuBar.add(menuNarzedzia);
		
		mNarz1 =new JMenuItem("Metry na stopy");
		mNarz1.addActionListener(this);
		menuNarzedzia.add(mNarz1);
		
		mNarz2 =new JMenuItem("Narziedzie 2");
		menuNarzedzia.add(mNarz2);
		
		mNarz3 =new JMenuItem("Narziedzie 3");
		menuNarzedzia.add(mNarz3);
			
			menuOpcje = new JMenu("Opcje");
			cbmOpcja1 = new JCheckBoxMenuItem("Opcja 1");
			cbmOpcja1.addActionListener(this);
			menuOpcje.add(cbmOpcja1);
			
			cbmOpcja2 = new JCheckBoxMenuItem("Opcja 2");
			cbmOpcja2.addActionListener(this);
			menuOpcje.add(cbmOpcja2);
		menuNarzedzia.add(menuOpcje);
		
//		MENU POMOC
		menuBar.add(menuPomoc);
		
		mOPrograme = new JMenuItem("O programie");
		mOPrograme.addActionListener(this);
		menuPomoc.add(mOPrograme);
			menuPodmenu = new JMenu("Wiêcej");
			mStronaWWW = new JMenuItem("Storna WWW");
			menuPodmenu.add(mStronaWWW);
			mStronaWWW.addActionListener(this);
		menuPomoc.add(menuPodmenu);
		
//		POPUP MENU
		
		popMenu = new JPopupMenu();
		mpoDolacz = new JMenuItem("Dolacz");
		mpoDolacz.addActionListener(this);
		
		mpoKopiuj = new JMenuItem("Kopiuj");
		mpoKopiuj.addActionListener(this);
		
		mpoWklej = new JMenuItem("Wklej");
		mpoWklej.addActionListener(this);
		
		popMenu.add(mpoDolacz);
		popMenu.add(mpoKopiuj);
		popMenu.add(mpoWklej);
		
//		COMBOBOX
		cbxKolorKombo = new JComboBox<String>();
		cbxKolorKombo.setBounds(50, 500, 100, 25);
		cbxKolorKombo.addItem("czarny");
		cbxKolorKombo.addItem("rozowy");
		cbxKolorKombo.addItem("niebieski");
		cbxKolorKombo.addItem("pomaranczowy");
		cbxKolorKombo.addActionListener(this);
		
		add(cbxKolorKombo);
		
//		********************************* //IMPLEMENTACJA MENU ***********************************
		
		
//		******************************************************************************************
//		********************************* ELEMENTY OKNA ******************************************
//		******************************************************************************************
		
//		********************************* Pole tekstowe wielolinijkowe ***************************
		notatnik = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(notatnik);
		scrollPane.setBounds(0, 0, 500, 500);
		add(scrollPane);
		notatnik.setComponentPopupMenu(popMenu);
		
//		********************************* //Pole tekstowe wielolinijkowe *************************
//		********************************* Szukajka ***********************************************
		btnSzukaj = new JButton("Szukaj");
		btnSzukaj.setBounds(50, 530, 150, 25);
		btnSzukaj.addActionListener(this);
		add(btnSzukaj);
		txfSzukany = new JTextField();
		txfSzukany.setBounds(220, 530, 150, 25);
		add(txfSzukany);
//		********************************* //Szukajka *********************************************
//		******************************** Zmiana kolorow ******************************************
		btnWybierzKolor = new JButton("Wybierz Kolor");
		btnWybierzKolor.setBounds(50, 560, 150, 25);
		btnWybierzKolor.addActionListener(this);
		add(btnWybierzKolor);
//		******************************** //Zmiana kolorow ****************************************
//		********************************* //ELEMENTY OKNA ****************************************
	}
//	******************************************************************************************
//	********************************* OBSLUGA AKCJI ******************************************
//	******************************************************************************************

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object zrodlo = e.getSource();
		if (zrodlo == mZamknij)
		{
			int odp = JOptionPane.showConfirmDialog(this, "Czy napewno zamknac?", "Zakoncz", JOptionPane.YES_NO_OPTION);
			if(odp == JOptionPane.YES_OPTION)
			{
				dispose();
			}
			else if (odp == JOptionPane.NO_OPTION || odp == JOptionPane.CLOSED_OPTION)
			{
				JOptionPane.showMessageDialog(this, "Wiedzialem", " ", JOptionPane.WARNING_MESSAGE);
			}
		}
//		******************************** obsluga szukajki ******************************************
		else if (zrodlo == btnSzukaj)
		{
			String tekst = notatnik.getText();
			String szukane = txfSzukany.getText();
			String wystapienia = "";
			int i = 0;
			int index = 0;
			int indexStart = 0;
			while ((index = tekst.indexOf(szukane, indexStart)) != -1)
			{
				indexStart = index + szukane.length();
				i++;
				wystapienia = wystapienia + " " + index;
			}
			
			JOptionPane.showMessageDialog(null, szukane + " wystapilo " + i + " razy: " + wystapienia);
		}
//		******************************** //obsluga szukajki ****************************************
//		******************************** wybierz kolor *********************************************
		else if (zrodlo == btnWybierzKolor)
		{
			Color wybranyKolor = JColorChooser.showDialog(null, "Wybor koloru", Color.GREEN);
			notatnik.setForeground(wybranyKolor);
		}
//		******************************** //wybierz kolor *******************************************
//		******************************** OTWIERANIE PLIKU ******************************************
		else if (zrodlo == mOtworz)
		{
			JFileChooser fc = new JFileChooser();
			if  (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File plik = fc.getSelectedFile();
				try
				{
					Scanner skaner = new Scanner(plik);
					while (skaner.hasNextLine())
					{
						notatnik.append(skaner.nextLine() + "\n");
					}
					skaner.close();
				} 
				catch (FileNotFoundException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

//		******************************** //OTWIERANIE PLIKU ******************************************
		
//		********************************** ZAPISYWANIE PLIKU *****************************************
		else if (zrodlo == mZapisz)
		{
			JFileChooser fc = new JFileChooser();
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION);
			{
				File plik = fc.getSelectedFile();
				try
				{
					PrintWriter pw = new PrintWriter(plik);
					Scanner skaner = new Scanner(notatnik.getText());
					while (skaner.hasNextLine())
					{
						pw.println(skaner.nextLine() + "\n");
											
					}
					pw.close();
					skaner.close();
				}
				catch (Exception e2)
				{
					// TODO: handle exception
				}
			}
		}
//		********************************** //ZAPISYWANIE PLIKU ***************************************		
//		****************************************************************************************
		else if (zrodlo == cbmOpcja1)
		{
			if (cbmOpcja1.isSelected())
			{
				mNarz1.setEnabled(false);
			}
			else if (!cbmOpcja1.isSelected())
			{
				mNarz1.setEnabled(true);
			}
		}
		else if (zrodlo == mNarz1)
		{
			String sMetry = JOptionPane.showInputDialog(this, "Podaj dlugosc w meterach");
			double dMetry = Double.parseDouble(sMetry);
			double stopy = dMetry/0.3048;
			String sStopy = String.format("%.2f", stopy);
			JOptionPane.showMessageDialog(this, sMetry + " metrow = "+ sStopy + " stop.");
		}
		else if (zrodlo == mOPrograme)
		{
			JOptionPane.showMessageDialog(this, "Program demonstruje uzycie menu przez wykorzystanie \n JMenuBar i JMenu. "
					+ " No i to jest ca³kiem ciekawe. \n \n \n Wersja 1.0", "Tytul", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (zrodlo == mStronaWWW)
		{
			
			try
			{
				Desktop.getDesktop().browse(new URI("http://wp.pl"));
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (zrodlo == mpoKopiuj)
		{
			wybranyTekst = notatnik.getSelectedText();
		}
		else if (zrodlo == mpoWklej)
		{
			notatnik.insert(wybranyTekst, notatnik.getCaretPosition());
		}
		else if (zrodlo == mpoDolacz)
		{
			notatnik.append("\n" + wybranyTekst);
		}
		else if (zrodlo == cbxKolorKombo)
		{
			String kolor = cbxKolorKombo.getSelectedItem().toString();
			if (kolor.equals("czarny"))
					notatnik.setForeground(Color.BLACK);
			else if (kolor.equals("rozowy"))
				notatnik.setForeground(Color.PINK);
			else if (kolor.equals("niebieski"))
				notatnik.setForeground(Color.BLUE);
			else if (kolor.equals("pomaranczowy"))
				notatnik.setForeground(Color.ORANGE);
			
			
		}
	}
//		********************************* //OBSLUGA AKCJI ******************************************

	public static void main(String[] args)
	{
		MenuTest Window = new MenuTest();
		Window.setVisible(true);
	}

}
