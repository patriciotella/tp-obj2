package gastos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import gastos.ConfiguracionGeneral;
import gastos.Gastos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.TEM;

import org.junit.Before;
import org.junit.Test;


public class ConfiguracionGeneralTest {
	
	private ConfiguracionGeneral cg;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private Gastos gastosM;
	private Gastos gastosG;
	private TEM tem;

	@Before
	public void setUp() throws Exception {
		fechaInicio = new GregorianCalendar(2013,Calendar.APRIL,23);
		fechaFin = new GregorianCalendar(2013,Calendar.MAY,23);
		gastosM = mock(Gastos.class);
		gastosG = mock(Gastos.class);
		tem = mock(TEM.class);
		cg = new ConfiguracionGeneral(fechaInicio, fechaFin, gastosM, gastosG, tem);

		when(gastosM.recotizarValor((float)500)).thenReturn((float)650);
		when(gastosG.recotizarValor((float)50000)).thenReturn((float)51000);
		when(tem.getTEM()).thenReturn((float) 0.05);
	}

	@Test
	public void testGetFechaInicio() {
		assertEquals(fechaInicio, cg.getFechaInicio());
	}

	@Test
	public void testGetFechaFin() {
		assertEquals(fechaFin, cg.getFechaFin());
	}

	@Test
	public void testGetTem() {
		assertEquals((float)0.05, cg.getTem(), 0.1);
	}

	@Test
	public void testRecotizarValorMensual() {
		assertEquals((float)650, cg.recotizarValorMensual((float)500), 0.1);

	}

	@Test
	public void testRecotizarValorGlobal() {
		assertEquals((float)51000, cg.recotizarValorGlobal((float)50000), 0.1);
	}
}
