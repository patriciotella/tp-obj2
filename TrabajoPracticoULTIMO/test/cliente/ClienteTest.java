package cliente;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cliente.Cliente;
import cliente.ClienteState;
import prestamo.EnCurso;
import prestamo.EstadoPrestamo;
import prestamo.Prestamo;

public class ClienteTest {
	private Cliente c;
	private Prestamo p1;
	private Prestamo p2;
	private Prestamo p3;
	private List<Prestamo> listaPrestamosPrueba;
	private EstadoPrestamo ep;
	
	@Before
	public void setUp() throws Exception{
		c = new Cliente("cliente", "prueba", "123456", "calle falsa 123");
		p1 = mock(Prestamo.class);
		p2 = mock(Prestamo.class);
		p3 = mock(Prestamo.class);
		listaPrestamosPrueba = new ArrayList<Prestamo>();
		listaPrestamosPrueba.add(p1);
		listaPrestamosPrueba.add(p2);
		listaPrestamosPrueba.add(p3);
		ep = new EnCurso();
		when(p1.estaEnCurso()).thenReturn(true);
		when(p2.estaEnCurso()).thenReturn(true);
		when(p1.estaEnDeuda()).thenReturn(false);
		when(p2.estaEnDeuda()).thenReturn(false);
		when(p3.estaEnCurso()).thenReturn(false);
		when(p3.estaEnDeuda()).thenReturn(true);
		when(p1.getEstado()).thenReturn(ep);
	}
	
	@Test
	public void testAptoParaPedirPrestamo() {
		assertTrue(c.aptoParaPedirPrestamo());
	}
	
	@Test
	public void testNoAptoParaPedirPrestamoPorTenerDosEnCurso(){
		c.agregarPrestamo(p1);
		c.agregarPrestamo(p2);
		assertFalse(c.aptoParaPedirPrestamo());
	}
	
	@Test
	public void testNoAptoParaPedirPrestamoPorTenerDeuda(){
		c.agregarPrestamo(p3);
		assertFalse(c.aptoParaPedirPrestamo());
	}
	
	
	@Test
	public void testChequearCondicionClienteConPermiso(){
		ClienteState aux = c.getEstado();
		c.chequearCondicion();
		assertEquals(aux, c.getEstado());
	}

	@Test
	public void testChequearCondicionClienteSinPermiso(){
		ClienteState aux = c.getEstado();
		c.agregarPrestamo(p3);
		c.chequearCondicion();
		assertNotSame(aux, c.getEstado());
	}

	@Test
	public void testGetApellido(){
		assertEquals("prueba", c.getApellido());
	}
	
	@Test
	public void testGetDni(){
		assertEquals("123456", c.getDni());
	}
	
	@Test
	public void testGetPrestamos(){
		c.agregarPrestamo(p1);
		c.agregarPrestamo(p2);
		c.agregarPrestamo(p3);
		assertEquals(listaPrestamosPrueba, c.getPrestamos());
	}
	
	@Test
	public void testSolicitarPrestamoConPermiso() throws Exception {
		int aux = c.getPrestamos().size();
		c.solicitarPrestamo(p1);
		assertEquals(aux+1, c.getPrestamos().size());
	}
	
	@Test
	public void testSolicitarPrestamoSinPermiso() throws Exception {
		c.agregarPrestamo(p3);
		c.chequearCondicion();
		try {
			c.solicitarPrestamo(p1);
		} catch (Exception e) {
			fail("implementar catch");
		}
	}
}
