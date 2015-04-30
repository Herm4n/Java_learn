import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuTest extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JMenu menuPlik, menuNarzedzia, menuPomoc;
	JMenuItem mOtworz, mZapisz, mZamknij, mNarz1, mNarz2, mNarz3, mOPrograme, mStronaWWW;
	
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
		menuBar.add(menuPlik);
		menuBar.add(menuNarzedzia);
		menuBar.add(menuPomoc);
		
		mOtworz = new JMenuItem("Otworz");
		mZapisz = new JMenuItem("Zapisz");
		mZamknij = new JMenuItem("Zamknij");
		menuPlik.add(mOtworz);
		menuPlik.add(mZapisz);
		menuPlik.add(mZamknij);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args)
	{
		MenuTest Window = new MenuTest();
		Window.setVisible(true);
	}

}
