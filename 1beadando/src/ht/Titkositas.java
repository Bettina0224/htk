package ht;
import java.nio.charset.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Titkositas 
{
	private String fajlNev;
	private String bemenet;
	public Titkositas(String fajlNev) 
	{
		super();
		this.fajlNev = fajlNev;
	}
	void adatOlvasas() throws FileNotFoundException, IOException 
	{
          this.bemenet = new String(Files.readAllBytes(Paths.get(this.fajlNev)), StandardCharsets.UTF_8);
	}

	private char[] kodolt;
	void kodolas() 
	{
		char[] kodolando = this.bemenet.toCharArray();
		for (int k=0;k < kodolando.length; k++) 
		{
			if(kodolando[k] != ' ')kodolando[k]++;
		}
		this.kodolt = kodolando;
		this.kiiratas();
	}

	void kiiratas()
	{
        PrintWriter keszAllomany;
		try 
		{
			keszAllomany = new PrintWriter(new FileWriter("./titkositottSzoveg.txt"));
			keszAllomany.write(this.kodolt);
			keszAllomany.close();
		} 
		catch (IOException e) {e.printStackTrace();}
	}
}
