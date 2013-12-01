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
	private Prestamo p2;
	private Prestamo p3;

	@Before
	public void setUp() {
		c1 = mock(ClienteSimple.class);
		c2 = mock(ClienteSimple.class);
		p1 = mock(Prestamo.class);
		p2 = mock(Prestamo.class);
		p3 = mock(Prestamo.class);
		
		cliente = new ClienteGrupal(c1, "empresa", "20-35947762-7", "quilmes");
		
		when(c1.getApellido()).thenReturn("Perez");
		when(p1.estaEnDeuda()).thenReturn(false);
		when(p2.estaEnDeuda()).thenReturn(false);
		when(p3.estaEnDeuda()).thenReturn(true);
		when(p1.estaEnCurso()).thenReturn(true);
		when(p2.estaEnCurso()).thenReturn(true);
		
		
	}

	@Test
	public void testClienteResponsable() {
		assertEquals(c1.getApellido(), cliente.getApellidoClienteResponsable());
	}
	
	@Test
	public void testAgregarCliente() {
		cliente.agregarCliente(c2);
		assertEquals(2, cliente.getClientes().size());
	}
	
	@Test
	public void testGetApellido() {
		assertEquals("empresa", cliente.getApellido());
	}

	@Test
	public void testGetDni() {
		assertEquals("20-35947762-7", cliente.getDni());
	}

	@Test
	public void testAgregarPrestamo() {
		cliente.agregarPrestamo(p1);
		verify(c1).agregarPrestamo(p1);
		assertEquals(1, cliente.getPrestamos().size());
	}

	@Test
	public void testChequearCondicionSinAlterarEstado() {
		ClienteState aux = cliente.getEstado();
		cliente.chequearCondicion();
		cliente.agregarPrestamo(p2);
		cliente.agregarPrestamo(p3);
		assertEquals(aux, cliente.getEstado());
	}
	
	@Test
	public void testChequearCondicionConPrestamoEnDeuda() {
		ClienteState aux = cliente.getEstado();
		cliente.agregarPrestamo(p1);
		cliente.agregarPrestamo(p2);
		cliente.agregarPrestamo(p3);
		cliente.chequearCondicion();
		assertNotSame(aux, cliente.getEstado());
	}
	
	@Test
	public void testChequearCondicionConDosPrestamosEnCurso() {
		ClienteState aux = cliente.getEstado();
		cliente.agregarPrestamo(p1);
		cliente.agregarPrestamo(p2);
		cliente.chequearCondicion();
		assertNotSame(aux, cliente.getEstado());
	}
}
