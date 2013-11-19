package busqueda;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import prestamo.EnCurso;
import prestamo.EstadoPrestamo;
import prestamo.Prestamo;
import Busquedas.EstadoDelPrestamo;

public class EstadoDelPrestamoTest {
	
	private EstadoDelPrestamo filtro;
	private Prestamo prestamo;
	private EstadoPrestamo estado;
	@Before
	public void setUp() throws Exception {
		this.estado = mock(EnCurso.class);
		filtro = new EstadoDelPrestamo(estado);
		this.prestamo = mock(Prestamo.class);
		when(prestamo.getEstado()).thenReturn(estado);
	}

	@Test
	public void testFiltrarPor() {
		assertTrue(filtro.filtrarPor(prestamo));
	}

}
