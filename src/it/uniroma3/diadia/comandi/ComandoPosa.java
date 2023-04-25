package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;
	private IO console;
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzoInBorsa = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoInBorsa);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);

	}

	@Override
	public void setParametro(String parametro) {
		
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void setIO(IO console) {
		
		this.console = console;
	}

}