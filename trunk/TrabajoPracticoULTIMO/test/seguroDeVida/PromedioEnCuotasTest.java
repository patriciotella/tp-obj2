package seguroDeVida;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import cuota.Cuota;

public class PromedioEnCuotasTest {

	private PromedioEnCuotas seguro;
	@Before
	public void setUp() throws Exception {
		seguro = new PromedioEnCuotas((float)0.015);
		seguro.recibirSaldoAnterior(2000);
		seguro.recibirSaldoAnterior(1500);
		seguro.recibirSaldoAnterior(1000);
		mock(Cuota.class);
	}

	@Test
	public void testRecibirSaldoAnterior() {
		assertEquals(3, seguro.getSaldos().size());
	}
	
	@Test
	public void testCalcularSeguro() {
		seguro.calcularSeguro();
		assertEquals(22,5, seguro.getPorCuota(5));
	}

}
