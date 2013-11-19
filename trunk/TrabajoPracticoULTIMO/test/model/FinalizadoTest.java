package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class FinalizadoTest {
	
	private Finalizado f;
	private Prestamo p;
	private Cuota c;

	@Before
	public void setUp() throws Exception {
		f = new Finalizado();
		p = mock(Prestamo.class);
		c = mock(Cuota.class);
	}

	@Test
	public void testPagarCuota() {
		try {
			f.pagarCuota(p, c);
		} catch (Exception e) {
			verifyZeroInteractions(p);
			verifyZeroInteractions(c);
		}	
	}

	@Test
	public void testEstaEnDeuda() {
		assertFalse(f.estaEnDeuda());
	}

	@Test
	public void testEstaEnCurso() {
		assertFalse(f.estaEnCurso());
	}

}
