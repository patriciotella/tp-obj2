package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;
import Busquedas.MontoDesde;

public class MontoDesdeTest {
	
	private MontoDesde filtro;
	private Prestamo prestamo;

	@Before
	public void setUp() throws Exception {
		this.filtro = new MontoDesde(20000);
		this.prestamo = mock(Prestamo.class);
		when(prestamo.getMonto()).thenReturn((float)20100);
	}

	@Test
	public void filtrarPorTest() {
		assertTrue(filtro.filtrarPor(prestamo));
	}

}
