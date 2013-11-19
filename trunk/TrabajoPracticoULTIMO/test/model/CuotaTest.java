package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import seguroDeVida.PromedioEnCuotas;
import seguroDeVida.SeguroDeVida;

public class CuotaTest {
	
	private Cuota cuota;
	private Cuota cuota2;
	private GregorianCalendar fechaPrestamo;
	private GregorianCalendar fechaPeriodo;
	private GregorianCalendar fechaPrestamo2;
	private GregorianCalendar fechaPeriodo2;
	private GregorianCalendar fechaVencimiento;
	private float tem;
	private PromedioEnCuotas s;

	@Before
	public void setUp() throws Exception {
		//Contructores con fecha anterior al 15:
		s = mock(PromedioEnCuotas.class);
		tem = (float) 0.015;
		fechaPrestamo = new GregorianCalendar(2013, Calendar.JUNE, 4);
		fechaPeriodo = new GregorianCalendar(2013, Calendar.JULY, 4);
		cuota = new Cuota((float) 500, 1, fechaPrestamo, 10000, tem, s);
		fechaVencimiento = new GregorianCalendar(2013, Calendar.JULY, 14);
		//Constructores con fecha mayor al 15:
		fechaPrestamo2 = new GregorianCalendar(2013, Calendar.JUNE, 24);
		fechaPeriodo2 = new GregorianCalendar(2013, Calendar.AUGUST, 24);
		cuota2 = new Cuota((float) 500, 1, fechaPrestamo2, 10000, tem, s);
	}
//Test sobre el calculo de fecha periodo con fecha anterior al 15:
	@Test
	public void testFechaPeriodoAntesDel15() {
		assertTrue(fechaPeriodo.equals(cuota.getFechaPeriodo()));
	}
	
//	Test sobre el calculo de fecha periodo con fecha superior al 15:
	@Test
	public void testFechaPeriodoDespuesDel15() {
		assertTrue(fechaPeriodo2.equals(cuota2.getFechaPeriodo()));
	}
	
	
	@Test
	public void testCalcularVencimiento(){
		assertTrue(fechaVencimiento.equals(cuota.getFechaVencimiento()));
	}
	
	@Test
	public void testFechaVencimiento(){
		assertTrue(fechaVencimiento.equals(cuota.getFechaVencimiento()));
	}
	
	@Test
	public void testPagarCuota(){
		cuota.pagarCuota();
		assertTrue(cuota.getPago());
	}

}
