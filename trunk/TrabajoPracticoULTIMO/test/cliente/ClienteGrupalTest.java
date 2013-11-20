package cliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;

public class ClienteGrupalTest {
	private ClienteGrupal cliente;
	private ClienteSimple c1;
	private ClienteSimple c2;
	private Prestamo p1;

	@Before
	public void setUp() throws Exception {
		cliente = new ClienteGrupal("", "empresa", "35.563.542", "quilmes");
		c1 = mock(ClienteSimple.class);
		c2 = mock(ClienteSimple.class);
		cliente.addCliente(c1);
		cliente.addCliente(c2);
		p1 = mock(Prestamo.class);
		cliente.agregarPrestamo(p1);
	}

	@Test
	public void testGetApellido() {
		assertEquals("empresa", cliente.getApellido());
	}

	@Test
	public void testGetDni() {
		assertEquals("35.563.542", cliente.getDni());
	}

	@Test
	public void testGetPrestamos() {
		assertEquals(1, cliente.getPrestamos().size());
	}

	@Test
	public void testChequearCondicion() {
		ClienteState aux = cliente.getEstado();
		cliente.chequearCondicion();
		assertEquals(aux, cliente.getEstado());
	}

}
