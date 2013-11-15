package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class CuotaTest {
	
	Cuota c;
	Calendar fechaInicio;

	@Before
	public void setUp() throws Exception {
		fechaInicio = mock(Calendar.class);
		c = new Cuota((float) 500, 1, fechaInicio);
//		when(fechaInicio.compareTo(anotherCalendar)).
	}


	@Test
	public void testEstaVencida() {
		fail("implementar");
	}

}
