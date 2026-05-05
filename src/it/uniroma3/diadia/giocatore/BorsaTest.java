package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class BorsaTest {
	private Borsa b;
	private Attrezzo cacciavite;
	
	@BeforeEach
	void setup() {
		b=new Borsa();
		cacciavite = new Attrezzo("cacciavite",6);
	}
	
	@Test
	void getBorsaInizializzata() {
		assertTrue(b.isEmpty());
		assertEquals(10,b.getPesoMax());
		assertEquals("Borsa vuota", b.toString());
	}

	/*Test addAttrezzo*/
	@Test
	void addAttrezzo() {
		assertTrue(b.addAttrezzo(cacciavite));
	}
	
	@Test
	void addAttrezzoFalliscePeso() {
		Attrezzo pala= new Attrezzo("pala",10);
		b.addAttrezzo(pala);
		assertFalse(b.addAttrezzo(cacciavite));
	}
	
	@Test
	void addAttrezzoFallisceSpazio() {
		for(int i=0;i<10;i++)
			b.addAttrezzo(new Attrezzo("att i",0));
		assertFalse(b.addAttrezzo(cacciavite));
	}
	
	/*Test getPeso */
	@Test
	void getPesoVuoto() {
		assertEquals(0,b.getPeso());
	}
	
	@Test
	void getPesoDopoAggiunta() {
		b.addAttrezzo(cacciavite);
		assertEquals(6,b.getPeso());
	}
	
	
	/* Test hasAttrezzo*/
	@Test
	void hasAttrezziVuota() {
		assertFalse(b.hasAttrezzo("osso"));
	}
	
	@Test
	void hasAttrezziNonTrova() {
		b.addAttrezzo(cacciavite);
		assertFalse(b.hasAttrezzo("osso"));
	}
	
	@Test
	void hasAttrezziTrova() {
		b.addAttrezzo(cacciavite);
		assertTrue(b.hasAttrezzo("cacciavite"));
	}
	
	/* Test addAttrezzo */
	@Test
	void getAttrezziVuota() {
		assertNull(b.getAttrezzo("osso"));
	}
	
	@Test
	void getAttrezziNonPresente() {
		b.addAttrezzo(cacciavite);
		assertNull(b.getAttrezzo("osso"));
	}
	
	@Test
	void getAttrezziPresente() {
		b.addAttrezzo(cacciavite);
		assertEquals(cacciavite,b.getAttrezzo("cacciavite"));
	}
	
	/* Test removeAttrezzo */
	@Test
	void removeAttrezzoVuoto() {
		assertNull(b.removeAttrezzo("cacciavite"));
	}
	
	@Test
	void removeAttrezzoAssente() {
		b.addAttrezzo(cacciavite);
		assertNull(b.removeAttrezzo("osso"));
	}
	
	@Test
	void removeAttrezzoPresente() {
		b.addAttrezzo(cacciavite);
		assertEquals(cacciavite,b.removeAttrezzo("cacciavite"));
	}
}
