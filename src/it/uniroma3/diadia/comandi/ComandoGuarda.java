package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	private IO io;
	
	public ComandoGuarda(IO io) {
		this.io=io;
	}
	
	public void esegui(Partita partita) {
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		if(!partita.isFinita())
			this.io.mostraMessaggio("La partita e' ancora in corso. "
					+ partita.getGiocatore().toString());
	}
	
	public void setParametro(String parametro) {}
}
