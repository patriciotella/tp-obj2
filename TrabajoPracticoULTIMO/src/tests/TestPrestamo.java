package tests;

import static org.junit.Assert.*;
import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;
import model.Cliente;
import model.ConfiguracionGeneral;
import model.EstadoPrestamo;
import model.Prestamo;
import model.SeguroDeVida;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class TestPrestamo {

	private Prestamo p;
	private Cliente cliente = mock(Cliente.class);
	private ConfiguracionGeneral config = mock(ConfiguracionGeneral.class);
	private SeguroDeVida seguroDeVida = mock(SeguroDeVida.class);
	
	@Before
	public void setUp(){
	p = new Prestamo(001, (float) 2000.0, 10, this.config, this.seguroDeVida, this.cliente);
	}
	
	@Test
	public void testCambiarEstadoAEnCurso() throws InstallmentCountException, InvalidAmountException {
		EstadoPrestamo eAux = p.getEstado();
		p.cambiarEstadoAEnCurso();
		assertNotSame("estado no cambió", eAux, p.getEstado());
	}

}
