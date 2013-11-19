package busqueda;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import prestamo.Prestamo;
import static org.mockito.Mockito.*;
import Busquedas.CantidadCuotasDesde;
import Busquedas.CantidadCuotasHasta;

public class CantidadCuotasHastaTest {
	
	private Prestamo prestamo;
	private Prestamo prestamo2;
	private CantidadCuotasHasta filtro;
	private ArrayList l1;
	private ArrayList l2;
	
	@Before
	public void setUp(){
		filtro = new CantidadCuotasHasta(8);
		prestamo = mock(Prestamo.class);
		l1 = mock(ArrayList.class);
		when(prestamo.getCuotas()).thenReturn(l1);
		when(l1.size()).thenReturn(5);
		prestamo2 = mock(Prestamo.class);
		l2 = mock(ArrayList.class);
		when(prestamo2.getCuotas()).thenReturn(l2);
		when(l2.size()).thenReturn(10);
	}

	@Test
	public void testFiltrarPor() {
		assertTrue(filtro.filtrarPor(prestamo));
	}
	
//	Caso en donde la cantidad de cuotas del prestamo es mayor a la especificada en el filtro:
	
	@Test
	public void testFailFiltrarPor(){
		assertFalse(filtro.filtrarPor(prestamo2));
	}

}
