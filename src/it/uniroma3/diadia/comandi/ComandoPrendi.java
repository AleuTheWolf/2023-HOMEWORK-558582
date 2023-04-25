package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	
	private String nomeAttrezzo;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzoInStanza = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzoInStanza);
		console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
		// Debugging a stampa
		System.out.println("Rimosso da stanza");

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