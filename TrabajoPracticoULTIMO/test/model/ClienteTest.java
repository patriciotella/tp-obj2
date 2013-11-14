package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mock;



public class ClienteTest {
	private Cliente c;
	private Prestamo p1;
	private Prestamo p2;
	private Prestamo p3;
	
	private void setUp() throws Exception {
		c = new Cliente("cliente", "prueba", 123456, "calle falsa 123");
		p1 = mock(Prestamo.class);
		p1 = mock(Prestamo.class);
		p1 = mock(Prestamo.class);
		c.agregarPrestamo(p1);
		c.agregarPrestamo(p2);
		c.agregarPrestamo(p3);
		when(p1.estaEnDeuda()).thenReturn(true);
		when(p1.estaEnDeuda()).thenReturn(true);
		when(p1.estaEnDeuda()).thenReturn(true);
	}
	
	@Test
	public void testPagarCuota() {
		assert(,c.pagarCuota(p1);
	}

}
