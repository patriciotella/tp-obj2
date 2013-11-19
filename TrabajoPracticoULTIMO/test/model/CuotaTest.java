package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class CuotaTest {
	
	Cuota cuota;
	GregorianCalendar fechaPrestamo;
	GregorianCalendar fechaPeriodo;
	GregorianCalendar fechaVencimiento;
	float tem;
	SeguroDeVida s;

	@Before
	public void setUp() throws Exception {
		fechaPrestamo = new GregorianCalendar(2013, Calendar.JUNE, 4);
		fechaPeriodo = new GregorianCalendar(2013, Calendar.JULY, 4);
		fechaVencimiento = new GregorianCalendar(2013, Calendar.JULY, 14);
		tem = (float) 0.015;
		s = mock(SeguroDeVida.class);
		cuota = new Cuota((float) 500, 1, fechaPrestamo, 10000, tem, s);
	}


	@Test
	public void testCalcularVencimiento(){
		assertTrue(fechaVencimiento.equals(cuota.getFechaVencimiento()));
	}
	
	@Test
	public void testFechaPeriodo() {
		assertTrue(fechaPeriodo.equals(cuota.getFechaPeriodo()));
	}
	
	@Test
	public void testFechaVencimiento(){
		assertTrue(fechaVencimiento.equals(cuota.getFechaVencimiento()));
	}
	

}
