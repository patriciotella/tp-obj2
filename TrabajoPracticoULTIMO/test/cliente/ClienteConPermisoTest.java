package cliente;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cliente.ClienteConPermiso;
import cliente.ClienteState;

public class ClienteConPermisoTest {
// YA NO QUEDA EN AMARILLO!!!!
	
	ClienteState c;

	@Before
	public void setUp() throws Exception {
		c = new ClienteConPermiso();
	}

	@Test
	public void testAptoParaPedirPrestamo() {
		assertTrue(c.aptoParaPedirPrestamo());
	}

}
