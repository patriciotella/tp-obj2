package busqueda;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;
import Busquedas.MontoHasta;

public class MontoHastaTest {
	
	private MontoHasta filtro;
	private Prestamo prestamo;

	@Before
	public void setUp() throws Exception {
		this.filtro = new MontoHasta(20000);
		this.prestamo = mock(Prestamo.class);
		when(prestamo.getMonto()).thenReturn((float)15000);
	}

	@Test
	public void filtrarPorTest() {
		assertTrue(filtro.filtrarPor(prestamo));
	}

}