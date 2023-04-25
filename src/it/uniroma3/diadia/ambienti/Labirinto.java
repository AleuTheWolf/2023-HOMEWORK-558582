package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	
	  public void creaStanze() {

			/* crea gli attrezzi */
			Attrezzo osso = new Attrezzo("osso",1);
			Attrezzo badge=new Attrezzo("badge",1);
			Attrezzo lanterna = new Attrezzo("lanterna",3);
			/* crea stanze del labirinto */
			Stanza atrio = new Stanza("Atrio");
			Stanza aulaN11 = new Stanza("Aula N11");
			Stanza aulaN10 = new Stanza("Aula N10");
			Stanza laboratorio = new Stanza("Laboratorio");
			Stanza biblioteca = new Stanza("Biblioteca");
			Stanza CampusOne = new StanzaMagica("Aula CampusOne");
			Stanza N9 = new StanzaBuia("Aula N9","lanterna");
			Stanza N13 = new StanzaBloccata("Aula N13", "est", "badge");
			
			/* collega le stanze */
			atrio.impostaStanzaAdiacente("nord", biblioteca);
			atrio.impostaStanzaAdiacente("est", aulaN11);
			atrio.impostaStanzaAdiacente("sud", aulaN10);
			atrio.impostaStanzaAdiacente("ovest", laboratorio);
			aulaN11.impostaStanzaAdiacente("est", laboratorio);
			aulaN11.impostaStanzaAdiacente("ovest", atrio);
			aulaN10.impostaStanzaAdiacente("nord", atrio);
			aulaN10.impostaStanzaAdiacente("est", aulaN11);
			aulaN10.impostaStanzaAdiacente("sud", CampusOne);
			aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
			laboratorio.impostaStanzaAdiacente("est", atrio);
			laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
			biblioteca.impostaStanzaAdiacente("sud", atrio);
			CampusOne.impostaStanzaAdiacente("est", N13);
			CampusOne.impostaStanzaAdiacente("nord", aulaN10);
			N13.impostaStanzaAdiacente("ovest", CampusOne);
			N13.impostaStanzaAdiacente("est", N9);
			N9.impostaStanzaAdiacente("ovest", N13);

	        /* pone gli attrezzi nelle stanze */
			aulaN10.addAttrezzo(lanterna);
			atrio.addAttrezzo(osso);

			// il gioco comincia nell'atrio
	        stanzaCorrente = atrio;  
			stanzaVincente = biblioteca;
	    }
	  

		public Stanza getStanzaVincente() {
			return stanzaVincente;
		}

		public void setStanzaCorrente(Stanza stanzaCorrente) {
			this.stanzaCorrente = stanzaCorrente;
		}

		public Stanza getStanzaCorrente() {
			return this.stanzaCorrente;
		}
		
		
}
