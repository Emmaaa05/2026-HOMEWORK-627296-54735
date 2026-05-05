package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class IOSimulatorTest {
	private DiaDia gioco;
	private IOSimulator io;
	
	/* test partite*/
	@Test
	void testPartitaSemplice() {
		String[] input= {"aiuto", "guarda", "prendi osso", "vai est","posa osso","fine"};
		this.io = new IOSimulator(input);
		this.gioco=new DiaDia(io);
		this.gioco.gioca();
		boolean trovato=false;
		String[] output = io.getOutput();
		
		for(int i=0; i < io.getNumeroOutput(); i++) {
			if(output[i] != null && output[i].contains("Hai preso")) {
				trovato=true;
				break;
				}
			}
		assertTrue(trovato);
		}

	@Test
	void testPartitaFinita() {
		String[] input= {"fine"};
		this.io = new IOSimulator(input);
		this.gioco=new DiaDia(io);
		this.gioco.gioca();
		boolean trovato=false;
		String[] output = io.getOutput();
		
		for(int i=0; i < io.getNumeroOutput(); i++) {
			if(output[i] != null && output[i].contains("Grazie")) {
				trovato=true;
				break;
				}
			}
		assertTrue(trovato);
		}
	
	@Test
	void testPartitaVinta() {
		String[] input= {"vai nord"};
		this.io = new IOSimulator(input);
		this.gioco=new DiaDia(io);
		this.gioco.gioca();
		boolean trovato=false;
		String[] output = io.getOutput();
		
		for(int i=0; i < io.getNumeroOutput(); i++) {
			if(output[i] != null && output[i].contains("Hai Vinto!")) {
				trovato=true;
				break;
				}
			}
		assertTrue(trovato);
		}
	
	@Test
	void testPartitaComandoVaiNonValido() {
		String[] input= {"aiuto","vai","vai eee","fine"};
		this.io = new IOSimulator(input);
		this.gioco=new DiaDia(io);
		this.gioco.gioca();
		boolean trovato=false;
		String[] output = io.getOutput();
		
		for(int i=0; i < io.getNumeroOutput(); i++) {
			if(output[i] != null && output[i].contains("Direzione inesistente")) {
				trovato=true;
				break;
				}
			}
		assertTrue(trovato);
		}

	@Test
	void testPartitaComandoPrendiNonValido() {
		String[] input= {"prendi","prendi casco","fine"};
		this.io = new IOSimulator(input);
		this.gioco=new DiaDia(io);
		this.gioco.gioca();
		int trovato=0;
		String[] output = io.getOutput();
		
		for(int i=0; i < io.getNumeroOutput(); i++) {
			if(output[i] != null && (output[i].contains("Devi specificare")
					|| output[i].contains("presente nella stanza"))) {
				trovato++;
			}
		}
		assertEquals(2,trovato);
	}
	
	@Test
	void testPartitaComandoPosaNonValido() {
		String[] input= {"posa", "prendi osso", "vai est",
				"posa ooo", "posa casco","fine"};
		this.io = new IOSimulator(input);
		this.gioco=new DiaDia(io);
		this.gioco.gioca();
		int trovato=0;
		String[] output = io.getOutput();
		
		for(int i=0; i < io.getNumeroOutput(); i++) {
			if(output[i] != null && (output[i].contains("e' vuota")
					|| output[i].contains("Devi specificare") || 
					output[i].contains("presente nella borsa"))) {
				trovato++;
			}
		}
		assertEquals(3,trovato);
	}
}
