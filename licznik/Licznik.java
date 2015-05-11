import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Licznik extends JFrame implements ActionListener
{
	private static long tTrwaniaPoprzedniejSesji = 0, t2 = 0;
	private JPanel contentPane;
	private JButton btnStart, btnStop, btnZeruj, btnZamknij;
	private static JLabel lblStoper;
	private static boolean isStop = false, isWznow = false;
	public static Thread watekStopera;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Licznik frame = new Licznik();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Licznik()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		/**
		 * ******************************************************
		 * ****************** przyciski *************************
		 */
		btnStart = new JButton("Start");
		btnStart.setBounds(300, 20, 100, 25);
		btnStart.addActionListener(this);
		add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.setBounds(300, 50, 100, 25);
		btnStop.addActionListener(this);
		add(btnStop);

		btnZeruj = new JButton("Zeruj");
		btnZeruj.setBounds(300, 80, 100, 25);
		btnZeruj.addActionListener(this);
		add(btnZeruj);

		btnZamknij = new JButton("Zamknij");
		btnZamknij.setBounds(300, 250, 100, 25);
		btnZamknij.addActionListener(this);
		add(btnZamknij);

		/**
		 * Label
		 */
		lblStoper = new JLabel("00:00:00");
		lblStoper.setFont(new Font(null, 0, 50));
		lblStoper.setBounds(20, 0, 250, 105);
		add(lblStoper);
	}
	/**
	 * *********************************************************
	 * ******************* Setery ******************************
	 */
// ustawia text w labelce
	public static void setLblStoperText(String t)
	{
		lblStoper.setText(t);
	}
//	testowe do labelkis
	public static void setColor(Color r)
	{
		lblStoper.setForeground(r);
	}
	public static void setIsStop(boolean b)
	{
		isStop = b;
	}
	public static void setIsWznow(boolean b)
	{
		isWznow = b;
	}
	public static void setTTrwaniaPoprzedniejSesji(long tl)
	{
		tTrwaniaPoprzedniejSesji = tl;
	}
	/**
	 * *********************************************************
	 * ******************* Getery ******************************
	 */
	public static boolean getIsStop()
	{
		return isStop;
	}
	
	public static boolean getIsWznow()
	{
		return isWznow;
	}
	public static long gettTrwaniaPoprzedniejSesji()
	{
		return tTrwaniaPoprzedniejSesji;
	}
	/**
	 * *********************************************************
	 * ***************** Obsluga zdarzen ***********************
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object z = e.getSource();
		if (z == btnZamknij)
		{
			if (Stoper.getIsStart() == true)
			{
				Stoper.setIsStart(false);
			}
			dispose();
		} 
		else if (z == btnStart)
		{
			if (Stoper.getIsStart() != true)
			{	
				if (getIsWznow() == false)
					setIsStop(false);
				
				Stoper stoper = new Stoper();
				watekStopera = new Thread(stoper); //tworzy nowy watek i w argumencie wysyla obiek stoper klasy Stoper
				watekStopera.start(); // start() uruchamia instrukcje zawarte w metodzie run() stopera
				Stoper.setIsStart(true);
				btnStart.setEnabled(false);
			}
		} 
		else if (z == btnStop)
		{
			if (Stoper.getIsStart() == true)
			{
				setTTrwaniaPoprzedniejSesji(Stoper.getCzasTrwania());
				Stoper.setIsStart(false);
				setIsStop(true);
				setIsWznow(true);
				Stoper.setCzasStop(System.currentTimeMillis());
				btnStart.setEnabled(true);
				btnStart.setText("Wznow");
			}
		}
		else if (z == btnZeruj)
		{
			setIsStop(false);
			setIsWznow(false);
			Stoper.setIsStart(false);
			Stoper.setCzasStart(0);
			Stoper.setCzasStop(0);
			Stoper.setCzasTrwania(0);
			setLblStoperText("00:00:00");
			btnStart.setText("Start");
			btnStart.setEnabled(true);
		}
	}
	
}

