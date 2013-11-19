package seguroDeVida;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

import model.Cuota;

import org.junit.Before;
import org.junit.Test;

public class PromedioEnCuotasTest {

	private PromedioEnCuotas seguro;
	private Cuota cuota;
	@Before
	public void setUp() throws Exception {
		seguro = new PromedioEnCuotas((float)0.015);
		seguro.recibirSaldoAnterior(2000);
		seguro.recibirSaldoAnterior(1500);
		seguro.recibirSaldoAnterior(1000);
		cuota = mock(Cuota.class);
	}

	@Test
	public void testRecibirSaldoAnterior() {
		assertEquals(3, seguro.getSaldos().size());
	}
	
	@Test
	public void testCalcularSeguro() {
		assertEquals(22,5, seguro.calcularSeguro(cuota));
	}

}
