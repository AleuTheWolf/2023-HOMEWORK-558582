package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	// Variabili di istanza
	private String direzione;
	private IO console;

	@Override
	public void esegui(Partita partita) {
		
		
		if(direzione==null)
			/*System.out.println("Dove vuoi andare ?");*/
			console.mostraMessaggio("Dove vuoi andare?");
		Stanza prossimaStanza = null;
		//prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		prossimaStanza = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu--);
		}
		console.mostraMessaggio(" " + partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		
		this.direzione = parametro;
	}

	@Override
	public void setIO(IO console) {
		
		this.console = console;
	}


}