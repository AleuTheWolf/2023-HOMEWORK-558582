package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			//System.out.println(elencoComandi[i]+" ");
			console.mostraMessaggio(elencoComandi[i] + " ");
		/*System.out.println();*/
		console.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}
	@Override
	public void setIO(IO console) {
		
		this.console = console;
	}

}