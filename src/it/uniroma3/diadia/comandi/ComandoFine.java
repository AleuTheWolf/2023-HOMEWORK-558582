package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	private IO console;

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		this.console.mostraMessaggio("Grazie per aver giocato!");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIO(IO console) {
		
		this.console = console;
	}

}
