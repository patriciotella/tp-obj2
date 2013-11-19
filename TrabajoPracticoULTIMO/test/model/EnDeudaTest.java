package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class EnDeudaTest {
	
	private EnDeuda ed;
	private Prestamo p;
	private Cuota c;

	@Before
	public void setUp() throws Exception {
		ed = new EnDeuda();
		p = mock(Prestamo.class);
		c = mock(Cuota.class);
	}

	@Test
	public void testPagarCuota() {
		ed.pagarCuota(p, c);
		verify(p).chequearEstado();
		verify(c).pagarCuota();
	}

	@Test
	public void testEstaEnDeuda() {
		assertTrue(ed.estaEnDeuda());
	}
	
	@Test
	public void testEstaEnCurso() {
		assertFalse(ed.estaEnCurso());
	}

}
