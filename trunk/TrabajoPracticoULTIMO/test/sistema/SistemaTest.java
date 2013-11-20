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
	private Prestamo p2;
	private Busqueda b;

	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		c1 = mock(Cliente.class);
		p1 = mock(Prestamo.class);
		p2 = mock(Prestamo.class);
		b = mock(Busqueda.class);
		
		when(c1.aptoParaPedirPrestamo()).thenReturn(true);
		when(b.filtrarPor(p1)).thenReturn(true);
		when(p1.tieneCuotasVencidas()).thenReturn(true);
		when(p1.estaEnDeuda()).thenReturn(true);
		when(p2.tieneCuotasVencidas()).thenReturn(false);
		when(p2.estaEnDeuda()).thenReturn(false);
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
	public void testBuscarPor() throws InstallmentCountException, InvalidAmountException {
		s.agregarPrestamo(p1);
		s.buscarPor(b);
		verify(b).filtrarPor(p1);
	}

	@Test
	public void testPasarPrestamoAEnDeuda() throws InstallmentCountException, InvalidAmountException {
//		tira error por la excepcion
		s.procesarPrestamo(c1, p1);
		s.aprobarPrestamo(p1);
		s.pasarPrestamoAEnDeuda(p1);
		verify(c1).pasarAEnDeuda(p1);
	}

	@Test
	public void testPendientesDeAprobacion() {
		s.procesarPrestamo(c1, p1);
		s.procesarPrestamo(c1, p2);
		assertEquals(2, s.getPrestamosEnEstadoSolicitado().size());
	}

	@Test
	public void testPosiblesDeudores() {
		s.agregarPrestamo(p1);
		s.agregarPrestamo(p2);
		assertEquals(1, s.posiblesDeudores().size());
	}

	@Test
	public void testPosiblesDeudoresIncobrables() {
		s.agregarPrestamo(p1);
		s.agregarPrestamo(p2);
		assertEquals(1, s.posiblesDeudoresIncobrables().size());
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
//		tira error por la excepcion
		s.procesarPrestamo(c1, p1);
		assertEquals(1, s.prestamosEnEstadoSolicitado.size());
		s.rechazarPrestamo(p1);
		verify(c1).pasarARechazado(p1);
		assertEquals(0, s.prestamosEnEstadoSolicitado.size());
	}

}
