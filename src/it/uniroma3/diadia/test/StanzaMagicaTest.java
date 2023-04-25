package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.ambienti.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	
	@Test
	void testSenzaEffetto() {
		Stanza stanza = new StanzaMagica("stanzaMagica");
		stanza.addAttrezzo(new Attrezzo("attrezzo", 1));
		assertTrue(stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testLoopSenzaEffetto() {
		Stanza stanza = new StanzaMagica("stanzaMagica");
		for (int i = 0; i < 3; i++) {
			stanza.addAttrezzo(new Attrezzo("attrezzo" + i, 1));
			assertTrue(stanza.hasAttrezzo("attrezzo" + i));
		}
	}
	
	@Test
	void testMagia() {
		Stanza stanza = new StanzaMagica("stanzaMagica");
		for (int i=0; i<3; i++) {
			stanza.addAttrezzo(new Attrezzo("attrezzo" + i, 1));
			assertTrue(stanza.hasAttrezzo("attrezzo" + i));
		}
		stanza.addAttrezzo(new Attrezzo("attrezzo", 1));
		assertFalse(stanza.hasAttrezzo("attrezzo"));
		assertTrue(stanza.hasAttrezzo("ozzertta"));
		assertEquals(2, stanza.getAttrezzo("ozzertta").getPeso());
	}
}