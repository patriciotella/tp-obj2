package cuota;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import cuota.Cuota;

public class CuotaTest {
	
	private Cuota c1;
	private Cuota c2;
	private Cuota c3;
	private GregorianCalendar fechaPrestamo;
	private GregorianCalendar fechaPeriodo;
	private GregorianCalendar fechaPrestamo2;
	private GregorianCalendar fechaPeriodo2;
	private GregorianCalendar fechaPrestamo3;
	private GregorianCalendar fechaVencimiento;
	private float tem;

	@Before
	public void setUp() throws Exception {
		//Constructores con fecha anterior al 15 / cuota vencida:
		tem = (float) 0.015;
		fechaPrestamo = new GregorianCalendar(2013, Calendar.JUNE, 4);
		fechaPeriodo = new GregorianCalendar(2013, Calendar.JULY, 4);
		c1 = new Cuota((float) 500, 1, fechaPrestamo, 10000, tem, (float) 14.00, (float) 0.05);
		fechaVencimiento = new GregorianCalendar(2013, Calendar.JULY, 14);
		
		//Constructores con fecha mayor al 15:
		fechaPrestamo2 = new GregorianCalendar(2013, Calendar.JUNE, 24);
		fechaPeriodo2 = new GregorianCalendar(2013, Calendar.AUGUST, 24);
		c2 = new Cuota((float) 500, 1, fechaPrestamo2, 10000, tem, (float) 14.00, (float) 0.05);
		
		//Constructores para cuota no vencida:
		fechaPrestamo3 =  new GregorianCalendar(2013, Calendar.NOVEMBER, 3);
		c3 = new Cuota((float)500, 2, fechaPrestamo3, 1000, tem, (float) 14.00, (float) 0.05);
	}
	
//Test sobre el calculo de fecha periodo con fecha anterior al 15:
	@Test
	public void testFechaPeriodoAntesDel15() {
		assertTrue(fechaPeriodo.equals(c1.getFechaPeriodo()));
	}
	
//	Test sobre el calculo de fecha periodo con fecha superior al 15:
	@Test
	public void testFechaPeriodoDespuesDel15() {
		assertTrue(fechaPeriodo2.equals(c2.getFechaPeriodo()));
	}
	
	@Test
	public void testFechaVencimiento(){
		assertEquals(fechaVencimiento, c1.getFechaVencimiento());
	}
	
	@Test
	public void testPagarCuotaAlDia(){
		c3.pagarCuota();
		assertTrue(c3.getPago());
		assertEquals(0, c3.getInteresPorMora(), 0);
	}
	
	@Test
	public void testPagarCuotaVencida(){
		c1.pagarCuota();
		assertTrue(c1.getPago());
		assertEquals(8.09, c1.getInteresPorMora(), 0.01);
	}
	
	@Test
	public void testGetNroCuota() {
		assertEquals(1, c1.getNroCuota());
	}
	
	@Test
	public void testGetSaldoDeDeuda() {
		assertEquals(9650, c1.getSaldoDeDeuda(), 0);
	}
	
	@Test
	public void testGetValorCuotaNeto() {
		assertEquals(500, c1.getValorCuotaNeto(), 0);
	}

	@Test
	public void testGetAmortizacion() {
		assertEquals(350, c1.getAmortizacion(), 0);
	}

	@Test
	public void getFechaDePago() {
		GregorianCalendar hoy = new GregorianCalendar();
		Date fechaHoy = new Date();
		hoy.setTime(fechaHoy);
		c1.pagarCuota();
		assertEquals(hoy, c1.getFechaDePago());
//		puede fallar por milisegundos
	}

	@Test
	public void getInteres() {
		assertEquals(150, c1.getInteres(), 0.01);
	}
	
	@Test
	public void getValorTotalDeCuota() {
		assertEquals(539, c1.getValorTotalDeCuota(), 0.01);
	}
}
