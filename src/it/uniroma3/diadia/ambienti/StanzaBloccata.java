package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
private String direzioneBloccata;
private String sbloccoPorta;

public StanzaBloccata(String nome, String direzioneBloccata, String sbloccoPorta) {
	super(nome);
	this.direzioneBloccata=direzioneBloccata;
	this.sbloccoPorta=sbloccoPorta;
}


@Override
public Stanza getStanzaAdiacente(String direzione) {
    	if (direzione.equals(direzioneBloccata)&&(!this.hasAttrezzo(sbloccoPorta)))
    		return this;
        return super.getStanzaAdiacente(direzione);
}

@Override
public String toString() {
	StringBuilder risultato = new StringBuilder();
	risultato.append("\n* " + super.getNome() + " *");
	risultato.append("\nUscite: ");
	for (String direzione : super.getDirezioni())
	{
		if (direzione!=null)
			risultato.append(" " + direzione);
		if (direzione.equals(direzioneBloccata))
			risultato.append("(bloccata) ");
	}
	risultato.append("\nAttrezzi nella stanza: ");
	for (int i = 0; i < super.getNumeroAttrezzi(); i++) {
		if (super.getAttrezzi()[i] != null)
			risultato.append(super.getAttrezzi()[i].toString()+" ");
	}
	risultato.append("\n------------------------------------");
	return risultato.toString();
}


}
