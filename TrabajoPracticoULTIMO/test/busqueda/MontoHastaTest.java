package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import busqueda.MontoHasta;
import prestamo.Prestamo;

public class MontoHastaTest {
	
	private MontoHasta filtro;
	private Prestamo p1;
	private Prestamo p2;

	@Before
	public void setUp() throws Exception {
		filtro = new MontoHasta(20000);
		p1 = mock(Prestamo.class);
		p2 = mock(Prestamo.class);
		when(p1.getMonto()).thenReturn((float)15000);
		when(p2.getMonto()).thenReturn((float)25000);
	}

	@Test
	public void filtrarPorTestConResultado() {
		assertTrue(filtro.filtrarPor(p1));
	}
	
	@Test
	public void filtrarPorTestSinResultado() {
		assertFalse(filtro.filtrarPor(p2));
	}

}