package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	@Test
	void testVinta() {
		Partita p=new Partita();
		assertFalse(p.getLabirinto().getStanzaCorrente()==p.getLabirinto().getStanzaVincente());
		p.setFinita();
		assertTrue(p.isFinita());
	}

	@Test
	void testIsFinita() {
		Partita p=new Partita();
		//p.getGiocatore().setCfu(10);
		//assertFalse(p.isFinita());
		//p.setFinita();
		//assertTrue(p.isFinita());
		assertFalse(p.vinta());
	}

}
