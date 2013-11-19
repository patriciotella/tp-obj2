package prestamo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.GregorianCalendar;

import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;

import org.junit.Before;
import org.junit.Test;

import configuracionGeneral.ConfiguracionGeneral;
import cliente.Cliente;
import seguroDeVida.SeguroDeVida;

public class PrestamoTest {
	
	private Prestamo p;
	private ConfiguracionGeneral cg;
	private SeguroDeVida s;
	private Cliente c;

	@Before
	public void setUp() throws Exception {
		cg = mock(ConfiguracionGeneral.class);
		s = mock(SeguroDeVida.class);
		c = mock(Cliente.class);
		p = new Prestamo(1, 50000, 12, cg, s, c);
		when(cg.getTem()).thenReturn((float) 0.015);
	}

	@Test
	public void testCambiarEstadoAEnCursoYAplicarCG() throws InstallmentCountException, InvalidAmountException {
//		EstadoPrestamo eAux = p.getEstado();
//		p.cambiarEstadoAEnCursoYAplicarCG();
//		assertNotEquals(eAux, p.getEstado());
		fail("implementar");
	}

	@Test
	public void testCambiarEstadoAEnCurso() {
		EstadoPrestamo eAux = p.getEstado();
		p.cambiarEstadoAEnCurso();
		assertNotSame(eAux,p.getEstado());
	}

	@Test
	public void testCambiarEstadoARechazado() {
		EstadoPrestamo eAux = p.getEstado();
		p.cambiarEstadoARechazado();
		assertNotSame(eAux,p.getEstado());
	}

	@Test
	public void testEstaEnCursoTrue() {
		p.cambiarEstadoAEnCurso();
		assertTrue(p.estaEnCurso());
	}
	
	@Test
	public void testEstaEnCursoFalse() {
		p.cambiarEstadoAEnDeuda();
		assertFalse(p.estaEnCurso());
	}

	@Test
	public void testEstaEnDeudaTrue() {
		p.cambiarEstadoAEnDeuda();
		assertTrue(p.estaEnDeuda());
	}
	
	@Test
	public void testEstaEnDeudaFalse() {
		assertFalse(p.estaEnCurso());
	}

	@Test
	public void testGetCuotasEstadoSolicitado() {
		assertNotSame(12, p.getCuotas().size());
	}
	
	@Test
	public void testGetCuotasEstadoEnCurso() throws InstallmentCountException, InvalidAmountException {
//		The Loan amount must be a positive value
		p.cambiarEstadoAEnCursoYAplicarCG();
		assertEquals(12, p.getCuotas().size());
	}

	@Test
	public void testGetId() {
		assertEquals(1, p.getId());
	}

	@Test
	public void testGetMonto() {
		assertEquals((float)50000, p.getMonto(), 0);
	}

	@Test
	public void testGetFechaPrestamo() {
		GregorianCalendar hoy = new GregorianCalendar();
		Date fechaHoy = new Date();
		hoy.setTime(fechaHoy);
		assertEquals(hoy, p.getFechaPrestamo());
	}

	@Test
	public void testGetCliente() {
		assertEquals(c, p.getCliente());
	}

	@Test
	public void testPagarCuota() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerCuotaAPagar() throws InstallmentCountException, InvalidAmountException {
//		The Loan amount must be a positive value
		p.cambiarEstadoAEnCursoYAplicarCG();
		assertEquals(1, p.obtenerCuotaAPagar().getNroCuota());
	}

	@Test
	public void testCambiarEstadoAEnDeuda() {
		EstadoPrestamo eAux = p.getEstado();
		p.cambiarEstadoAEnDeuda();
		assertNotSame(eAux,p.getEstado());
	}

	@Test
	public void testChequearEstado() {
//		Si no tiene cuotas en deuda, pasa el estado a EnCurso. Si no hay cuotas, entonces no hay deuda.
		EstadoPrestamo eAux = p.getEstado();  // Solicitado
		p.chequearEstado();
		assertNotSame(eAux,p.getEstado());
		
//		chequear estado CON CUOTAS que esten en deuda
	}

}
