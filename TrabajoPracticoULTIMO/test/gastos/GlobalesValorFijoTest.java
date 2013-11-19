package gastos;

import static org.junit.Assert.*;
import gastos.GlobalesValorFijo;

import org.junit.Before;
import org.junit.Test;

public class GlobalesValorFijoTest {
	
	private GlobalesValorFijo gvf;

	@Before
	public void setUp() throws Exception {
		gvf = new GlobalesValorFijo(1000);
	}

	@Test
	public void testRecotizarValor() {
		assertEquals(49000, gvf.recotizarValor(50000), 0.1);
	}

}
