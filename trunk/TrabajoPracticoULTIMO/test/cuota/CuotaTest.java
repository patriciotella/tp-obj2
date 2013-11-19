package cuota;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import cuota.Cuota;
import seguroDeVida.SeguroDeVida;

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
	private SeguroDeVida s;

	@Before
	public void setUp() throws Exception {
		//Contructores con fecha anterior al 15 / cuota vencida:
		s = mock(SeguroDeVida.class);
		tem = (float) 0.015;
		fechaPrestamo = new GregorianCalendar(2013, Calendar.JUNE, 4);
		fechaPeriodo = new GregorianCalendar(2013, Calendar.JULY, 4);
		c1 = new Cuota((float) 500, 1, fechaPrestamo, 10000, tem, s);
		fechaVencimiento = new GregorianCalendar(2013, Calendar.JULY, 14);
		
		//Constructores con fecha mayor al 15:
		fechaPrestamo2 = new GregorianCalendar(2013, Calendar.JUNE, 24);
		fechaPeriodo2 = new GregorianCalendar(2013, Calendar.AUGUST, 24);
		c2 = new Cuota((float) 500, 1, fechaPrestamo2, 10000, tem, s);
		
		//Constructores para cuota no vencida:
		fechaPrestamo3 =  new GregorianCalendar(2013, Calendar.NOVEMBER, 3);
		c3 = new Cuota((float)500, 1, fechaPrestamo3, 1000, tem, s);
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
		assertTrue(fechaVencimiento.equals(c1.getFechaVencimiento()));
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
		assertEquals(7.5, c1.getInteresPorMora(), 0);
	}
	
	@Test
	public void testGetNroCuota() {
		assertEquals(1, c1.getNroCuota());
	}
	
	@Test
	public void testGetSaldoDeDeuda() {
		assertEquals(9850, c1.getSaldoDeDeuda(), 0);
	}
	
	@Test
	public void testGetValorCuotaNeto() {
		assertEquals(500, c1.getValorCuotaNeto(), 0);
	}

}
