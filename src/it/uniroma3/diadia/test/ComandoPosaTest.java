package it.uniroma3.diadia.test;

import static org.junit.Assert.*;
import it.uniroma3.diadia.comandi.*;
import org.junit.Test;
import org.junit.Before;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {

	private Partita partita;
	private Labirinto labirinto;
	private Stanza stanza;
	private Attrezzo attrezzo;
	private IO io;
	private Comando comando;
	private Borsa borsa;
	private Giocatore giocatore;
	
	@Before
	public void setUp() {
		partita = new Partita();
		labirinto = new Labirinto();
		giocatore = new Giocatore();
		stanza = new Stanza("Atrio");
		borsa = new Borsa();
		partita.setGiocatore(giocatore);	// imposta nella partita il giocatore
		partita.setLabirinto(labirinto);	// imposta il labirinto
		partita.getLabirinto().creaStanze();	// crea le stanze del labirinto
		
		// Per la funzione di test 
		partita.getLabirinto().setStanzaCorrente(stanza); // imposta la stanza corrente che è l'Atrio
		partita.getGiocatore().setBorsa(borsa);	// imposta la borsa
		// Crea gli attrezzi
		attrezzo = new Attrezzo("attrezzo", 1);
		
		// Per tutte le funzioni di test
		comando = new ComandoPosa();	// Comando è una sotto classe del comando che posa
		io = new IOConsole();	// per eseguire i comandi
		comando.setIO(io);
	}
	
	@Test
	public void testAddAttrezzoInStanza() {
		// Aggiungi attrezzo in borsa
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("attrezzo");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("attrezzo"));
	}

}

