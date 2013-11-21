package configuracionGeneral;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import configuracionGeneral.MensualesPorcentuales;

public class MensualesPorcentualesTest {
	
	private MensualesPorcentuales mp;

	@Before
	public void setUp() throws Exception {
		mp = new MensualesPorcentuales((float) 0.05);
	}

	@Test
	public void testRecotizarValor() {
		assertEquals(525, mp.recotizarValor(500), 0.01);
	}
	
	@Test
	public void testGetValor() {
		assertEquals(0.05, mp.getValor(), 0.01);
	}

}
