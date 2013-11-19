package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MensualesValorFijoTest {
	
	private MensualesValorFijo mvf;

	@Before
	public void setUp() throws Exception {
		mvf = new MensualesValorFijo(10);
	}

	@Test
	public void testRecotizarValor() {
		assertEquals(510, mvf.recotizarValor(500), 0.01);
	}

}
