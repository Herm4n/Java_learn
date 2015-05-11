import java.awt.Color;

public class Stoper implements Runnable
{
	private long pauza = 1000; //czas zatrzymania watku w milisekundach
	private static long t1 = 0, t2 = 0, t3 = 0;//	t1 - bezwzgledny czas właczenia stoper	t2 - bezwzgledny czas wylaczenia stopera t3 - czas pracy stopera w jednym cyklu w ms
	private static boolean isStart = false; // flaga oznaczajaca czy stoper jest wlaczony

	
//	Setery
	
	public static void setCzasStart(long t)
	{
		t1 = t;
	}
	
	public static void setCzasStop(long t)
	{
		t2 = t;
	}
	
	public static void setCzasTrwania(long t)
	{
		t3 = t;
	}
	
	public static void setIsStart(boolean b)
	{
		isStart = b;
	}
//	koniec Seterow
	
//	Getery
	
	private static long getCzasStart()
	{
		return t1;
	}
	
	private static long getCzasStop()
	{
		return t2;
	}
	
	public static long getCzasTrwania()
	{
		return t3;
	}
	
	public static boolean getIsStart()
	{
		return isStart;
	}
//	koniec Geterow
	
//	Konstruktor domyslny
	public Stoper(){}
	
//	Metoda run() zawiera w sobie wszystkie operacje wykonywane w kolejnym watku, 
	public void run()
	{
		if (Licznik.getIsStop() == false && Licznik.getIsWznow() == false) //rozpoczyna mierzenie czasu od zeraz
		{
			setCzasStart(System.currentTimeMillis()); //pobiera czas startu stopera
			while (isStart == true)
			{
				setCzasTrwania(System.currentTimeMillis()-getCzasStart());
				Licznik.setLblStoperText(convertSecondsToHMmSs(getCzasTrwania()));
				try
				{
					Thread.sleep(pauza); // zatrzymanie watka na xxx ms
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (Licznik.getIsStop() == true && Licznik.getIsWznow() == true) //wznawia mierzenie czasu po nacisnieciu "wznow"
		{
			long czasPoprzedniej = Licznik.gettTrwaniaPoprzedniejSesji();
			setCzasStart(0);
			setCzasStart(System.currentTimeMillis());
			while (isStart == true)
			{
				setCzasTrwania(System.currentTimeMillis()-getCzasStart());
				setCzasTrwania(getCzasTrwania() + czasPoprzedniej);
				Licznik.setLblStoperText(convertSecondsToHMmSs(getCzasTrwania()));
				try
				{
					Thread.sleep(pauza); // zatrzymanie watka na xxx ms
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
//	Konwersja z czasu z milisekund na hhMMss 
	public static String convertSecondsToHMmSs(long miliseconds) 
	{
	    long s = (miliseconds / 1000) % 60;
	    long m = (miliseconds / 1000 / 60) % 60;
	    long h = (miliseconds / 1000 / (60 * 60)) % 24;
	    return String.format("%02d:%02d:%02d", h,m,s);
	    
	    
	}

	
	
	public static void main(String[] args) // zostawione do testow
	{
//		Stoper stoper = new Stoper();
//		Thread watekStoper = new Thread(stoper);
//		isStart = true;
//		watekStoper.start();

		
	}

}
