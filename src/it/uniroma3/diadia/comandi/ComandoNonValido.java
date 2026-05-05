package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private IO io;
	
	public ComandoNonValido(IO io) {
		this.io=io;
	}
	
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Comando non valido. Riprova!");
	}
	
	public void setParametro(String parametro) {}
}
