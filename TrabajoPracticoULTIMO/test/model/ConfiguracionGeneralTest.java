package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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
	// no es importante, revisar
	public void testGetTem() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecotizarValorMensual() {
		assertEquals((float)650, cg.recotizarValorMensual((float)500), 0.1);

	}

	@Test
	public void testRecotizarValorGlobal() {
		fail("Not yet implemented");
	}
}
