package it.uniroma3.diadia.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;
class StanzaBuiaTest {

	@Test
	public void testBuia() {
		Stanza stanza = new StanzaBuia("stanzaBuia", "osso");
		assertEquals("Qui c'è buio pesto", stanza.getDescrizione());
	}
	
	@Test
	public void testBuiaOggettoSbagliato() {
		Stanza stanza = new StanzaBuia("stanzaBuia", "osso");
		stanza.addAttrezzo(new Attrezzo("torcia spenta", 1));
		assertEquals("Qui c'è buio pesto", stanza.getDescrizione());
	}
	
	@Test
	public void testIlluminata() {
		Stanza stanza = new StanzaBuia("stanzaBuia", "torcia");
		stanza.addAttrezzo(new Attrezzo("torcia", 1));
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
}