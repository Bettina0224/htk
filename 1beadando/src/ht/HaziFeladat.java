package ht;
import java.io.IOException;
import java.io.FileNotFoundException;

public class HaziFeladat 
{

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
	      Titkositas titkositas = new Titkositas("./bemenoSzoveg.txt");
	      titkositas.adatOlvasas();
	      titkositas.kodolas();
	      
	} 
}
