import java.util.Scanner;


public class TestRownania 
{

	public static void main(String[] args) 
	{
		Scanner skaner = new Scanner(System.in);
		System.out.print("Podaj pierwsz� liczb�: ");
		double a = (skaner.nextDouble());
		System.out.print("Podaj drug� liczb�: ");
		double b = (skaner.nextDouble());
		System.out.print("Podaj trzeci� liczb�: ");
		double c = (skaner.nextDouble());
		skaner.close();
		RownanieKwadratowe mojeRownanie = new RownanieKwadratowe(a , b ,c);
		
		String wynik = mojeRownanie.obliczDelta();
		System.out.println(wynik);
	}

}
