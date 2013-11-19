package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import prestamo.Prestamo;
import Busquedas.DniCliente;

public class DniClienteTest {

	private DniCliente filtro;
	private Prestamo prestamo;
	private Cliente cliente;
	
	@Before
	public void setUp() throws Exception {
		filtro = new DniCliente("37.040.383");
		prestamo = mock(Prestamo.class);
		cliente = mock(Cliente.class);
		when(prestamo.getCliente()).thenReturn(cliente);
		when(cliente.getDni()).thenReturn("37.040.383");
	}

	@Test
	public void testFiltrarPor() {
		assertTrue(filtro.filtrarPor(prestamo));
	}

}
