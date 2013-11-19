package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import busqueda.DniCliente;
import cliente.Cliente;
import prestamo.Prestamo;

public class DniClienteTest {

	private DniCliente filtro;
	private Prestamo p1;
	private Prestamo p2;
	private Cliente c1;
	private Cliente c2;
	
	@Before
	public void setUp() throws Exception {
		filtro = new DniCliente("37.040.383");
		p1 = mock(Prestamo.class);
		p2 = mock(Prestamo.class);
		c1 = mock(Cliente.class);
		c2 = mock(Cliente.class);
		when(p1.getCliente()).thenReturn(c1);
		when(c1.getDni()).thenReturn("37.040.383");
		when(p2.getCliente()).thenReturn(c2);
		when(c2.getDni()).thenReturn("35.947.762");
	}

	@Test
	public void testFiltrarPorConResultado() {
		assertTrue(filtro.filtrarPor(p1));
	}
	
	@Test
	public void testFiltrarPorSinResultado() {
		assertFalse(filtro.filtrarPor(p2));
	}

}
