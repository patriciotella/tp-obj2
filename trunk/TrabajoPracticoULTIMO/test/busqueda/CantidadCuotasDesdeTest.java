package busqueda;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;
import Busquedas.CantidadCuotasDesde;

public class CantidadCuotasDesdeTest {
	
	Prestamo prestamo;
	Prestamo prestamo2;
	CantidadCuotasDesde filtro;
	ArrayList l1;
	ArrayList l2;
	
	@Before
	public void setUp() throws Exception {
	
	prestamo = mock(Prestamo.class);
	prestamo2 = mock(Prestamo.class);
	l1 = mock(ArrayList.class);
	l2 = mock(ArrayList.class);
	when(prestamo.getCuotas()).thenReturn(l1);
	when(l1.size()).thenReturn(5);
	when(prestamo2.getCuotas()).thenReturn(l2);
	when(l2.size()).thenReturn(1);
	filtro = new CantidadCuotasDesde(3);
	
	}
	
	@Test
	public void testFiltrarPor() {
		assertTrue(filtro.filtrarPor(prestamo));
	}
	
	@Test
	public void testFiltrarPorFechaIgual() {
		assertFalse(filtro.filtrarPor(prestamo2));
	}
}
