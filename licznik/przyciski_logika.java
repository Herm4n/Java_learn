
public class przyciski_logika
{
	public static void StoperStart()
	{
		Stoper stoper = new Stoper();
		Licznik.watekStopera = new Thread(stoper); //tworzy nowy watek i w argumencie wysyla obiek stoper klasy Stoper
		stoper.setIsStart(true);
		Licznik.watekStopera.start();
	}

}
