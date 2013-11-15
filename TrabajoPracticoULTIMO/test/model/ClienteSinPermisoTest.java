package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteSinPermisoTest {
	
	ClienteState c;
	Cliente cl;
	Prestamo p;

	@Before
	public void setUp() throws Exception {
		c = new ClienteSinPermiso();
		cl = mock(Cliente.class);
		p = mock(Prestamo.class);
	}


	@Test
	public void testSolicitarPrestamo() {
		fail("implementar");
	}
	
	@Test
	public void testAptoParaPedirPrestamo(){
		assertFalse(c.aptoParaPedirPrestamo());
	}

}
