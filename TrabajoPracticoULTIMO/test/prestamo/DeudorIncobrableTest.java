package prestamo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import model.Cuota;

import org.junit.Before;
import org.junit.Test;

import prestamo.DeudorIncobrable;
import prestamo.Prestamo;

public class DeudorIncobrableTest {
	
	private DeudorIncobrable di;
	private Prestamo p;
	private Cuota c;

	@Before
	public void setUp() throws Exception {
		di = new DeudorIncobrable();
		p = mock(Prestamo.class);
		c = mock(Cuota.class);
	}

	@Test
	public void testPagarCuota() {
		try {
			di.pagarCuota(p, c);
		} catch (Exception e) {
			verifyZeroInteractions(p);
			verifyZeroInteractions(c);
		}		
	}

	@Test
	public void testEstaEnDeuda() {
		assertTrue(di.estaEnDeuda());
	}

	@Test
	public void testEstaEnCurso() {
		assertFalse(di.estaEnCurso());
	}

}
