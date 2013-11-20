package sistema;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

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
	private Cliente c2;
	private Prestamo p1;
	private Prestamo p2;
	private Busqueda b;
	private ArrayList<Prestamo> l;

	@Before
	public void setUp() throws Exception {
		s = new Sistema();
		c1 = mock(Cliente.class);
		c2 = mock(Cliente.class);
		p1 = mock(Prestamo.class);
		p2 = mock(Prestamo.class);
		b = mock(Busqueda.class);
		l = new ArrayList<Prestamo>();
		l.add(p2);
		
		when(c1.aptoParaPedirPrestamo()).thenReturn(true);
		when(c1.getPrestamos()).thenReturn(l);
		when(c2.aptoParaPedirPrestamo()).thenReturn(false);
		when(b.filtrarPor(p1)).thenReturn(true);
		when(p1.tieneCuotasVencidas()).thenReturn(true);
		when(p1.estaEnDeuda()).thenReturn(true);
		when(p2.tieneCuotasVencidas()).thenReturn(false);
		when(p2.estaEnDeuda()).thenReturn(false);
	}

	@Test
	public void testAprobarPrestamo() throws InstallmentCountException, InvalidAmountException {
		s.procesarPrestamo(c1, p2);
		assertEquals(1, s.getPrestamosEnEstadoSolicitado().size());
		try {
		s.aprobarPrestamo(p2);
		} catch (InvalidAmountException e) {}
		verify(c1).pasarAAprobado(p2);
		assertEquals(0, s.getPrestamosEnEstadoSolicitado().size());
		assertEquals(1, s.getPrestamos().size());
	}

	@Test
	public void testAtenderCliente() {
		fail("consultar");
	}

	@Test
	public void testBuscarPor() throws InstallmentCountException, InvalidAmountException {
		s.agregarPrestamo(p1);
		s.buscarPor(b);
		verify(b).filtrarPor(p1);
	}

	@Test
	public void testPasarPrestamoAEnDeuda() throws InstallmentCountException, InvalidAmountException {
		s.procesarPrestamo(c1, p2);
		try {
			s.aprobarPrestamo(p2);
		} catch (Exception e) {	}
		s.pasarPrestamoAEnDeuda(p2);
		verify(c1).pasarAEnDeuda(p2);
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
	public void testProcesarPrestamoClienteConPermiso() {
		assertEquals(0, s.getClientes().size());
		assertEquals(0, s.getPrestamosEnEstadoSolicitado().size());
		s.procesarPrestamo(c1, p1);
		verify(c1).agregarPrestamo(p1);
		assertEquals(1, s.getClientes().size());
		assertEquals(1, s.getPrestamosEnEstadoSolicitado().size());
	}
	
	@Test
	public void testProcesarPrestamoClienteSinPermiso() {
		s.procesarPrestamo(c2, p1);
		assertEquals(0, s.getClientes().size());
		assertEquals(0, s.getPrestamosEnEstadoSolicitado().size());
	}

	@Test
	public void testRechazarPrestamo() {
		s.procesarPrestamo(c1, p2);
		assertEquals(1, s.prestamosEnEstadoSolicitado.size());
		s.rechazarPrestamo(p2);
		verify(c1).pasarARechazado(p2);
		assertEquals(0, s.prestamosEnEstadoSolicitado.size());
	}

}
