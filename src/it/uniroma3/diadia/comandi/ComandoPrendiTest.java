package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ComandoPrendiTest {
	private Partita partita;
	private Attrezzo osso;
	private Comando comando;
	private IO io;

	@BeforeEach
	void setUp() {
		this.partita= new Partita();
		this.osso = partita.getStanzaCorrente().getAttrezzo("osso");
		this.io=new IOConsole();
		this.comando = new ComandoPrendi(this.io);
	}
	
	@Test
	void prendiAttrezzoPresente() {
		comando.setParametro(osso.getNome());
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test
	void prendiAttrezzoNonPresente() {
		comando.setParametro("lanterna");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test
	void prendiAttrezzoStanzaVuota() {
		partita.getStanzaCorrente().removeAttrezzo(osso.getNome());
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("osso"));
		comando.setParametro(osso.getNome());
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test
	void prendiAttrezzoNullo() {
		comando.setParametro(null);
		comando.esegui(partita);
		assertEquals(1,partita.getStanzaCorrente().getNumeroAttrezzi());
	}
	
	@Test
	void prendiAttrezzoBorsaPiena() {
		for(int i=0; i<10; i++) {
			Attrezzo att= new Attrezzo("att"+i,1);
			partita.getGiocatore().getBorsa().addAttrezzo(att);
		}
		comando.setParametro(osso.getNome());
		comando.esegui(partita);
		assertEquals(1,partita.getStanzaCorrente().getNumeroAttrezzi());
	}
	
}
