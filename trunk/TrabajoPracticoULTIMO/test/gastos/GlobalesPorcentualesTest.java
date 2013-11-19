package gastos;

import static org.junit.Assert.*;
import gastos.GlobalesPorcentuales;

import org.junit.Before;
import org.junit.Test;

public class GlobalesPorcentualesTest {
	
	private GlobalesPorcentuales gp;

	@Before
	public void setUp() throws Exception {
		gp = new GlobalesPorcentuales((float)0.08);
	}

	@Test
	public void testRecotizarValor() {
		assertEquals(46000.0, gp.recotizarValor(50000), 0.1);
	}

}
