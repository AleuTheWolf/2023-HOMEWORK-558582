package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	
	private IO console;
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		console.mostraMessaggio("");
		console.mostraMessaggio("Stanza corrente:");
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		console.mostraMessaggio("");
		console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		console.mostraMessaggio("");
		console.mostraMessaggio("CFU:"); // <<<---- RICORDATI DI CERCARE TOGLI RITORNO A CAPO DA QUI
		console.mostraMessaggio(String.valueOf(partita.getGiocatore().getCfu())); // <<<---- CONVERTE DA INT A STRING
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