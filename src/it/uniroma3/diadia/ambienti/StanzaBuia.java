package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String Illuminazione;
	
	public StanzaBuia(String nome, String Illuminazione) {
		super(nome);
		this.Illuminazione=Illuminazione;
	}

	
	@Override
   public String getDescrizione() {
    	if(this.hasAttrezzo(this.Illuminazione))
        return this.toString();
    	else
    		return("Qui c'è buio pesto");
    }

}
