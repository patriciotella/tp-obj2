package prestamo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import model.Cuota;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;
import prestamo.Solicitado;
import static org.mockito.Mockito.*;

public class SolicitadoTest {
	
	private Solicitado s;
	private Prestamo p;
	private Cuota c;

	@Before
	public void setUp() throws Exception {
		s = new Solicitado();
		p = mock(Prestamo.class);
		c = mock(Cuota.class);
	}

	@Test
	public void testPagarCuota() {
		try {
			s.pagarCuota(p, c);
		} catch (Exception e) {
			verifyZeroInteractions(p);
			verifyZeroInteractions(c);
		}	
	}

	@Test
	public void testEstaEnDeuda() {
		assertFalse(s.estaEnDeuda());
	}

	@Test
	public void testEstaEnCurso() {
		assertFalse(s.estaEnCurso());
	}

}
