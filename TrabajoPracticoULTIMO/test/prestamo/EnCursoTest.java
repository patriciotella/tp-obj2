package prestamo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cuota.Cuota;
import prestamo.EnCurso;
import prestamo.Prestamo;

public class EnCursoTest {
	
	private EnCurso ec;
	private Prestamo p;
	private Cuota c;

	@Before
	public void setUp() throws Exception {
		ec = new EnCurso();
		p = mock(Prestamo.class);
		c = mock(Cuota.class);
	}

	@Test
	public void testEstaEnCurso() {
		assertTrue(ec.estaEnCurso());
	}
	
	@Test
	public void testEstaEnDeuda() {
		assertFalse(ec.estaEnDeuda());
	}
	
	@Test
	public void testPagarCuota() {
		ec.pagarCuota(p, c);
		verify(c).pagarCuota();
	}

}