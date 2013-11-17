package busqueda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Prestamo;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import Busquedas.CantidadCuotasHasta;

public class CantidadCuotasHastaTest {
	
	private CantidadCuotasHasta filtro;
	private Prestamo prestamo;	
	private ArrayList l;
	
	@Before
	public void setUp(){
		prestamo = mock(Prestamo.class);
		l = mock(ArrayList.class);
		filtro = new CantidadCuotasHasta(8);
		when(prestamo.getCuotas()).thenReturn(l);
		when(l.size()).thenReturn(5);
	}

	@Test
	public void testFiltrarPor() {
		assertTrue(filtro.filtrarPor(prestamo));
	}

}
