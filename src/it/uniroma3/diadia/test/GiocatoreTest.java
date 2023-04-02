package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {

	@Test
	void testGetBorsa() {
		Giocatore p1=new Giocatore();
		
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		p1.getBorsa().addAttrezzo(osso);
		assertTrue(p1.getBorsa().hasAttrezzo("osso"));
		assertFalse(p1.getBorsa().hasAttrezzo("lanterna"));
		assertFalse(p1.getBorsa().isEmpty());
		
	}

}
