package it.uniroma3.diadia.test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
class BorsaTest {

	@Test
	void testHasAttrezzo() {
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Borsa borsa=new Borsa();
		Borsa borsa2=new Borsa();
		borsa.addAttrezzo(osso);
		assertTrue(borsa.hasAttrezzo("osso"));
		assertFalse(borsa2.hasAttrezzo("lanterna"));
		assertNotSame(borsa.getNumeroAttrezzi(), borsa2.getNumeroAttrezzi());
		
		
	}

}
