package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

    private Labirinto lab;
    private Giocatore P1;
	private boolean finita;
	
	
	
	public Partita(){
		this.lab=new Labirinto();
		this.P1=new Giocatore();
		lab.creaStanze();
		this.finita = false;
	}
	
	public Labirinto getLabirinto() {
		return this.lab;
	}

	public Giocatore getGiocatore() {
		return this.P1;
	}
	public void setLabirinto(Labirinto lab) {
		this.lab=lab;
	}
	
	public void setGiocatore(Giocatore P1) {
		this.P1=P1;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return lab.getStanzaCorrente()== lab.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.P1.getCfu() == 0);
	}

	public boolean giocatoreIsVivo() {
		// TODO Auto-generated method stub
		return this.getGiocatore().isVivo();
	}
	
	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}
