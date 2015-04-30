import java.util.Scanner;


public class TestRownania 
{

	public static void main(String[] args) 
	{
		Scanner skaner = new Scanner(System.in);
		System.out.print("Podaj pierwsz¹ liczbê: ");
		double a = (skaner.nextDouble());
		System.out.print("Podaj drug¹ liczbê: ");
		double b = (skaner.nextDouble());
		System.out.print("Podaj trzeci¹ liczbê: ");
		double c = (skaner.nextDouble());
		skaner.close();
		RownanieKwadratowe mojeRownanie = new RownanieKwadratowe(a , b ,c);
		
		String wynik = mojeRownanie.obliczDelta();
		System.out.println(wynik);
	}

}
