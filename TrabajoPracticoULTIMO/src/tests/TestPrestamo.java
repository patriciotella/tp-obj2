package tests;

import static org.junit.Assert.*;
import installment.calculator.exceptions.InstallmentCountException;
import installment.calculator.exceptions.InvalidAmountException;
import model.Cliente;
import model.ConfiguracionGeneral;
import model.EstadoPrestamo;
import model.Prestamo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class TestPrestamo {

	private Prestamo p;
/*	private Mock cliente;
	private Mock configGral;
	private Mock seguroDeVida;*/
	
	@Before
	public void setUp(){
	//	this.cliente.
		//p = new Prestamo(001, 2000, 10, this.cliente, this.seguroDeVida, this.configGral);
	}
	
	@Test
	public void testCambiarEstadoAEnCurso() throws InstallmentCountException, InvalidAmountException {
		EstadoPrestamo eAux = p.getEstado();
		p.cambiarEstadoAEnCurso();
		assertNotSame("estado no cambió", eAux, p.getEstado());
	}

}
