package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto","prendi", "posa", "fine"};

	private Partita partita;
    IOConsole IO=new IOConsole();
	public DiaDia() {
		this.partita = new Partita();
		
	}

	public void gioca() {
		String istruzione; 
		IO.mostraMessaggio(MESSAGGIO_BENVENUTO);
		istruzione=IO.leggiRiga();		
		do		
			istruzione = IO.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		 else if (comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
		 else if (comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else {
			IO.mostraMessaggio("Comando sconosciuto");
		    this.aiuto();
		}
		if (this.partita.vinta()) {
			IO.mostraMessaggio("Hai Vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:
	
	                                                     
	  /**
		 * Prende un attrezzo dalla stanza e lo ripone nella borsa 
		 *
		 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
		 */
	  private void prendi(String NomeAttrezzo) {
		  Attrezzo attr=this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(NomeAttrezzo);
		  this.partita.getGiocatore().getBorsa().addAttrezzo(attr);
		  this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attr.getNome());
	   }
		
	/**
	 * Rimuove un attrezzo dalla borsa e lo lascia nella stanza 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
		  private void posa(String NomeAttrezzo) {
			  Attrezzo attr=this.partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo);
			  this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(attr);
			  this.partita.getGiocatore().getBorsa().removeAttrezzo(NomeAttrezzo);
		                                                        }
	  
	  
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		IO.mostraMessaggio("I comandi disponibili sono:");
		for(int i=0; i< elencoComandi.length; i++)			
			IO.mostraMessaggio(elencoComandi[i]+" ");
			
		IO.mostraMessaggio(" ");;
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			IO.mostraMessaggio("Dove vuoi andare?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu);
		}
		IO.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		 IOConsole IO=new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca();
		
	}
}