package model;

//import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Busquedas.CantidadCuotasDesde;

public class CantidadCuotasDesdeTest {
	
	Prestamo p;
	CantidadCuotasDesde cant;
	ArrayList l;
	
	@Before
	public void setUp() throws Exception {
	
	p = mock(Prestamo.class);
	l = mock(ArrayList.class);
	when(p.getCuotas()).thenReturn(l);
	when(l.size()).thenReturn(5);
	cant = new CantidadCuotasDesde(5);
	
	}
	
	@Test
	public void testFiltrarPor() {
		assert(cant.filtrarPor(p));
	}

}
