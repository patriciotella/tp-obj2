package configuracionGeneral;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import configuracionGeneral.GlobalesPorcentuales;

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
	
	@Test
	public void testGetValor() {
		assertEquals(0.08, gp.getValor(), 0.01);
	}

}
