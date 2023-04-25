package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
public interface Comando {

/**
* esecuzione del comando
*/
public void esegui(Partita partita);
public void setParametro(String Parametro);
public void setIO(IO console);

}