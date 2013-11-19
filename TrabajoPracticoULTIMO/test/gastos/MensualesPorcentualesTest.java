package gastos;

import static org.junit.Assert.*;
import gastos.MensualesPorcentuales;

import org.junit.Before;
import org.junit.Test;

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

}
