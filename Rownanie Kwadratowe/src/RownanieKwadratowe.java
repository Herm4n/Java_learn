import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class RownanieKwadratowe 
{
	private double a = 0;
	private double b = 0;
	private double c = 0;
	
//	Konstruktory
	public RownanieKwadratowe()
	{
		setA(4);
		setB(4);
		setC(1);
	}
	
	public RownanieKwadratowe(double a)
	{
		setA(a);
		setB(12);
		setC(1);
	}
	
	public RownanieKwadratowe(double a, double b)
	{
		setA(a);
		setB(b);
		setC(2);
	}
	
	public RownanieKwadratowe(double a, double b, double c)
	{
		setA(a);
		setB(b);
		setC(c);
	}
	
	public RownanieKwadratowe(String s)
	{
		if (s.equals("user")) 
		{
			pobierzDane();
		}
	}
	
//	Mutatory (Setery)
	public void setA(double a)
	{
		this.a = a;
	}
	
	public void setB(double b)
	{
		this.b = b;
	}
	
	public void setC(double c)
	{
		this.c = c;
	}
	
//	Akcesory (Getery)
	public double getA()
	{
		return this.a;
	}
	
	public double getB()
	{
		return this.b;
	}
	
	public double getC()
	{
		return this.c;
	}
	
//	Wczytanie danych od urzytkownika
	public void pobierzDane()
	{
		Scanner skaner = new Scanner(System.in);
		System.out.print("Podaj pierwsz¹ liczbê: ");
		setA(skaner.nextDouble());
		System.out.print("Podaj drug¹ liczbê: ");
		setB(skaner.nextDouble());
		System.out.print("Podaj trzeci¹ liczbê: ");
		setC(skaner.nextDouble());
		skaner.close();
	}
	
//	Oblicza Delte i rozwi¹zania kwadratowe
	public String obliczDelta()
	{
		String rozwiazanie = "";
		double delta = getB()*getB() - 4*getA()*getC();
		if (delta > 0) 
		{
			double x1 = (-getB() - Math.sqrt(delta)) / 2*getA();
			double x2 = (-getB() + Math.sqrt(delta)) / 2*getA();
			rozwiazanie = "Równanie ma dwa rozwi¹zania: x1 = "+ zaokraglij(x1) + ", x2 = " + zaokraglij(x2);
		}
		else if (delta == 0 )
		{
			double x = -getB() / (2*getA());
			rozwiazanie = "Równanie ma jedno rozwi¹zanie, x1 = x2 = "+ zaokraglij(x);
		}
		else 
		{
			rozwiazanie= "Delta jest mniejsza od zera, równanie nie ma rozwi¹zañ.";
		}
		
		return rozwiazanie;
	}
	
	private double zaokraglij(double xx)
	{
		BigDecimal z = new BigDecimal(xx).setScale(2, BigDecimal.ROUND_CEILING);
		return z.doubleValue();
	}
	
	public static void main(String[] args) 
	{
		
	}
}
