package model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Busquedas.CantidadCuotasDesde;

public class CantidadCuotasDesdeTest {
	
	Prestamo p;
	CantidadCuotasDesde cant;
	
	@Before
	public void setUp() throws Exception {
	
	p = mock(Prestamo.class);
	when(p.getCuotas().size()).thenReturn(5);
	cant = new CantidadCuotasDesde(5);
	
	}
	//return (this.cuotas <= p.getCuotas().size());
	@Test
	public void testFiltrarPor() {
		assert(cant.filtrarPor(p));
	}

}
