package cliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;

public class ClienteGrupalTest {
	private ClienteGrupal cliente;
	private ClienteSimple c1;
	private ClienteSimple c2;
	private Prestamo p1;
	private Prestamo p2;
	private Prestamo p3;
	private List<Prestamo> l;

	@Before
	public void setUp() throws Exception {
		cliente = new ClienteGrupal("", "empresa", "35.563.542", "quilmes");
		c1 = mock(ClienteSimple.class);
		c2 = mock(ClienteSimple.class);
		l = new ArrayList<Prestamo>();
		when(c1.getPrestamos()).thenReturn(l);
		cliente.addCliente(c1);
		cliente.addCliente(c2);
		p1 = mock(Prestamo.class);
		cliente.agregarPrestamo(p1);
		l.add(p1);
		p2 = mock(Prestamo.class);
		p3 = mock(Prestamo.class);
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
	public void testChequearCondicionConPermisos() {
		ClienteState aux = cliente.getEstado();
		cliente.chequearCondicion();
		assertEquals(aux, cliente.getEstado());
	}
	
	@Test
	public void testChequearCondicionSinPermisos() {
		ClienteState aux = cliente.getEstado();
		cliente.agregarPrestamo(p2);l.add(p2);
		cliente.agregarPrestamo(p3);l.add(p3);
		cliente.chequearCondicion();
		System.out.println(c1.getPrestamos().size());
		assertEquals(aux, cliente.getEstado());
	}

}
