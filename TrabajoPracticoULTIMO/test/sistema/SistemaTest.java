package sistema;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import org.junit.Before;
import org.junit.Test;

import busqueda.Busqueda;
import cliente.Cliente;
import prestamo.Prestamo;

public class SistemaTest {
	
	private Sistema s;
	private Cliente c1;
	private Prestamo p1;
	private Busqueda b;

	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		c1 = mock(Cliente.class);
		p1 = mock(Prestamo.class);
		b = mock(Busqueda.class);
		
		when(c1.aptoParaPedirPrestamo()).thenReturn(true);
		when(b.filtrarPor(p1)).thenReturn(true);
	}

	@Test
	public void testAprobarPrestamo() throws InstallmentCountException, InvalidAmountException {
//		tira error por la excepcion
		s.procesarPrestamo(c1, p1);
		assertEquals(1, s.getPrestamosEnEstadoSolicitado().size());
		s.aprobarPrestamo(p1);
		verify(c1).pasarAAprobado(p1);
		assertEquals(0, s.getPrestamosEnEstadoSolicitado().size());
		assertEquals(1, s.getPrestamos().size());
	}

	@Test
	public void testAtenderCliente() {
//		preguntar
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPor() {
		s.procesarPrestamo(c1, p1);
		s.buscarPor(b);
		verify(b).filtrarPor(p1);
		assertEquals(p1, s.buscarPor(b));
	}

	@Test
	public void testPasarPrestamoAEnDeuda() {
		fail("Not yet implemented");
	}

	@Test
	public void testPendientesDeAprobacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testPosiblesDeudores() {
		fail("Not yet implemented");
	}

	@Test
	public void testPosiblesDeudoresIncobrables() {
		fail("Not yet implemented");
	}

	@Test
	public void testProcesarPrestamo() {
		assertEquals(0, s.getClientes().size());
		assertEquals(0, s.getPrestamosEnEstadoSolicitado().size());
		s.procesarPrestamo(c1, p1);
		verify(c1).agregarPrestamo(p1);
		assertEquals(1, s.getClientes().size());
		assertEquals(1, s.getPrestamosEnEstadoSolicitado().size());
	}

	@Test
	public void testRechazarPrestamo() {
		fail("Not yet implemented");
	}

}
