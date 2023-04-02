package it.uniroma3.diadia.test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class StanzaTest {

	@Test
	void testHasAttrezzo() {
		Attrezzo osso = new Attrezzo("osso",1);
		Stanza stanza1=new Stanza("stanza");
		stanza1.addAttrezzo(osso);
		assertTrue(stanza1.hasAttrezzo("osso"));
		assertFalse(stanza1.hasAttrezzo("lanterna"));
	}

	@Test
	void testGetAttrezzo() {
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Stanza stanza1=new Stanza("stanza1");
		Stanza stanza2=new Stanza("stanza2");
		Stanza stanza3=new Stanza("stanza3");
		stanza1.addAttrezzo(osso);
		stanza2.addAttrezzo(lanterna);
		assertSame(stanza1.getAttrezzo("osso"), osso);
		assertNotSame(stanza2.getAttrezzo("lanterna"), osso);
		assertNotSame(stanza3.getAttrezzo("osso"), osso);
	}

	@Test
	void testRemoveAttrezzo() {
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Stanza stanza1=new Stanza("stanza1");
		Stanza stanza2=new Stanza("stanza2");
		Stanza stanza3=new Stanza("stanza3");
		stanza1.addAttrezzo(osso);
		stanza2.addAttrezzo(lanterna);
		stanza1.removeAttrezzo("osso");
		assertSame(stanza1.getAttrezzi().length,stanza3.getAttrezzi().length);
		stanza1.addAttrezzo(lanterna);
		assertSame(stanza1.getAttrezzi().length,stanza2.getAttrezzi().length);
		assertNotSame(stanza1.getAttrezzi(),stanza3.getAttrezzi());
		
	}

}
