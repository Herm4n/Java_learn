import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


public class MenuTest extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JMenu menuPlik, menuNarzedzia, menuPomoc, menuPodmenu, menuOpcje;
	JMenuItem mOtworz, mZapisz, mZamknij, mNarz1, mNarz2, mNarz3, mOPrograme, mStronaWWW, mOpcja1, mOpcja2;
	JCheckBoxMenuItem cbmOpcja1, cbmOpcja2;
	
	public MenuTest()
	{
		setTitle("Demonstracja JMenuBar");
		setSize(500, 500);
		setBounds(100, 100, 400, 300);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		menuPlik = new JMenu("Plik");
		menuNarzedzia = new JMenu("Narzedzia");
		menuPomoc = new JMenu("Pomoc");
		
		setJMenuBar(menuBar);
		
//		MENU PLIK
		menuBar.add(menuPlik);
		
		mOtworz = new JMenuItem("Otworz", 'O');
		menuPlik.add(mOtworz);
		
		mZapisz = new JMenuItem("Zapisz");
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
		
	}
// OBS£UGA AKCJI
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
		
	}

	public static void main(String[] args)
	{
		MenuTest Window = new MenuTest();
		Window.setVisible(true);
	}

}
