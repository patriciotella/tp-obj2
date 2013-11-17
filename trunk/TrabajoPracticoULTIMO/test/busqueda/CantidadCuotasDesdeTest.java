package busqueda;

//import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import model.Prestamo;

import org.junit.Before;
import org.junit.Test;

import Busquedas.CantidadCuotasDesde;

public class CantidadCuotasDesdeTest {
	
	Prestamo prestamo;
	CantidadCuotasDesde filtro;
	ArrayList l;
	
	@Before
	public void setUp() throws Exception {
	
	prestamo = mock(Prestamo.class);
	l = mock(ArrayList.class);
	when(prestamo.getCuotas()).thenReturn(l);
	when(l.size()).thenReturn(5);
	filtro = new CantidadCuotasDesde(2);
	
	}
	
	@Test
	public void testFiltrarPor() {
		assertTrue(filtro.filtrarPor(prestamo));
	}

}
