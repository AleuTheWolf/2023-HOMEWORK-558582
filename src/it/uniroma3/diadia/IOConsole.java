package it.uniroma3.diadia;
import java.util.Scanner;
public class IOConsole implements IO{
public void mostraMessaggio(String msg) {
System.out.println(msg);
}
public String leggiRiga() {
	Scanner scannerDiLinee = new Scanner(System.in);	// da warning perché scanner non è chiuso (è commentato sotto)
	String riga = scannerDiLinee.nextLine();
	//scannerDiLinee.close();
	return riga;	// Di tipo String
}
}