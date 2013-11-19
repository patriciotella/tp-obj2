package prestamo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import cuota.Cuota;
import prestamo.Prestamo;
import prestamo.Rechazado;

public class RechazadoTest {
	
	private Rechazado r;
	private Prestamo p;
	private Cuota c;

	@Before
	public void setUp() throws Exception {
		r = new Rechazado();
		p = mock(Prestamo.class);
		c = mock(Cuota.class);
		
	}

	@Test
	public void testPagarCuota() {
		try {
			r.pagarCuota(p, c);
		} catch (Exception e) {
			verifyZeroInteractions(p);
			verifyZeroInteractions(c);
		}
	}

	@Test
	public void testEstaEnDeuda() {
		assertFalse(r.estaEnDeuda());
	}

	@Test
	public void testEstaEnCurso() {
		assertFalse(r.estaEnCurso());
	}

}
