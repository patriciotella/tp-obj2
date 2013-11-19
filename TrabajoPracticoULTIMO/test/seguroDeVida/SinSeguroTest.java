package seguroDeVida;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SinSeguroTest {

	private SinSeguro seguro;
	
	@Before
	public void setUp() throws Exception {
		seguro = new SinSeguro();
		seguro.calcularSeguro();
	}

	@Test
	public void testGetPorCuota() {
		assertEquals(0, seguro.getPorCuota(4), 0);
	}

}
