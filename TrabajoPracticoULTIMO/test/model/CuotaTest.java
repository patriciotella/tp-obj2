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

	@Before
	public void setUp() throws Exception {
		fechaPrestamo = new GregorianCalendar(2013, Calendar.JUNE, 4);
		fechaPeriodo = new GregorianCalendar(2013, Calendar.JULY, 4);
		fechaVencimiento = new GregorianCalendar(2013, Calendar.JULY, 14);
		cuota = new Cuota((float) 500, 1, fechaPrestamo);
	}


	@Test
	public void testCalcularVencimiento(){
		assertTrue(fechaVencimiento.equals(cuota.getFechaVencimiento()));
	}
	
	@Test
	public void testFechaPeriodo() {
		GregorianCalendar f2 = new GregorianCalendar(2013, Calendar.JULY, 14);
		assertTrue(f2.equals(cuota.getFechaPeriodo()));
	}
	
	@Test
	public void testFechaVencimiento(){
		assertTrue(fechaVencimiento.equals(cuota.getFechaVencimiento()));
	}
	

}
