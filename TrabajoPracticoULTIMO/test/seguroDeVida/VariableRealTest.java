package seguroDeVida;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



public class VariableRealTest {

	private VariableReal seguro;
	@Before
	public void setUp() throws Exception {
		seguro = new VariableReal((float)0.015);
		seguro.recibirSaldoAnterior(2000);
		seguro.recibirSaldoAnterior(1500);
		seguro.recibirSaldoAnterior(1000);
	}

	@Test
	public void testRecibirSaldoAnterior() {
		assertEquals(3, seguro.getSaldos().size());
	}
	
	@Test
	public void testCalcularSeguroCuota1() {
		seguro.calcularSeguro();
		assertEquals(30, seguro.getPorCuota(1),0);
	}
	
	@Test
	public void testCalcularSeguroCuota2() {
		seguro.calcularSeguro();
		assertEquals(22, seguro.getPorCuota(2),50);
	}
	
	@Test
	public void testCalcularSeguroCuota3() {
		seguro.calcularSeguro();
		assertEquals(15, seguro.getPorCuota(3),0);
	}

}