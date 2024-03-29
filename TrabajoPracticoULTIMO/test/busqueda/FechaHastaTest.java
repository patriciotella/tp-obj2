package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import busqueda.FechaHasta;
import prestamo.Prestamo;

public class FechaHastaTest {
	private FechaHasta filtro;
	private Prestamo prestamo;

	@Before
	public void setUp() throws Exception {
		filtro = new FechaHasta(new GregorianCalendar(2013, Calendar.JULY, 24));
		this.prestamo = mock(Prestamo.class);
		when(prestamo.getFechaPrestamo()).thenReturn(new GregorianCalendar(2013, Calendar.JUNE, 12));
		
	}

	@Test
	public void test() {
		assertTrue(filtro.filtrarPor(prestamo));
	}

}
