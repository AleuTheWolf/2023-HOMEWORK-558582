package it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import it.uniroma3.diadia.comandi.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPrendiTest {

	private Partita partita;
	private Labirinto labirinto;
	private Stanza stanza, stanza1;
	private Attrezzo attrezzo, attrezzo1;
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
		
		// Per la funzione di test testAddInBorsa
		partita.getLabirinto().setStanzaCorrente(stanza); // imposta la stanza corrente che è l'Atrio
		partita.getGiocatore().setBorsa(borsa);	// imposta la borsa
		attrezzo = new Attrezzo("bastone", 1);
		
		// Per tutte le funzioni di test
		comando = new ComandoPrendi();	// Comando è una sotto classe del comando che prende
		io = new IOConsole();	// per eseguire i comandi
		comando.setIO(io);
		
		// Per la funzione di test testAddAttrezzoPesante
		stanza1 = new Stanza("Laboratorio");
		partita.getLabirinto().setStanzaCorrente(stanza1);
	    attrezzo1 = new Attrezzo("piuma", 20);
		
	}
	
	@Test
	public void testAddInBorsa() {
		// aggiungi l'attrezzo in stanza
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("bastone");	// parametro di prendi è bastone
		comando.esegui(partita);	// esegui il comando prendi bastone (parametro)
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("bastone"));			
	}
	

}