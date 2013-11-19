package cliente;

import org.junit.Before;
import org.junit.Test;

import cliente.ClienteConPermiso;
import cliente.ClienteState;

public class ClienteConPermisoTest {
// POR QUE QUEDA AMARILLO?
	
	ClienteState c;

	@Before
	public void setUp() throws Exception {
		c = new ClienteConPermiso();
	}

	@Test
	public void testAptoParaPedirPrestamo() {
		assert(c.aptoParaPedirPrestamo());
	}

}
