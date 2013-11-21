package busqueda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import busqueda.ConectorLogicoO;
import busqueda.MontoDesde;
import busqueda.MontoHasta;
import prestamo.Prestamo;

public class ConectorLogicoOTest {
	
	private ConectorLogicoO conector;
	private Prestamo prestamo;
	private MontoDesde monto;
	private MontoHasta monto2;
	

	@Before
	public void setUp() throws Exception {
		conector = new ConectorLogicoO();
		prestamo = mock(Prestamo.class);
		monto = new MontoDesde(15000);
		monto2 = new MontoHasta(30000);
//		mocks de los filtros en gral
		when(prestamo.getMonto()).thenReturn((float)10000);
		this.conector.addBusqueda(monto);
		this.conector.addBusqueda(monto2);
	}

	@Test
	public void testAddBusqueda() {
		assertEquals(2, this.conector.getBusquedas().size());
	}
	
	@Test
	public void testFiltrarPor() {
		assertTrue(conector.filtrarPor(prestamo));
	}
}
