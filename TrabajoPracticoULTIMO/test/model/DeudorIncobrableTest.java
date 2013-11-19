package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		doNothing().when(di).pagarCuota(p, c);
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
