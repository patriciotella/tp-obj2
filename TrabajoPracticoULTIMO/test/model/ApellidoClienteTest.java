package model;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Busquedas.ApellidoCliente;
import static org.mockito.Mockito.*;

public class ApellidoClienteTest {

	Prestamo prestamo;
	Cliente cliente;
	ApellidoCliente filtro;
	
	@Before
	public void setUp() throws Exception {
		
		filtro = new ApellidoCliente("angyPuta");
	    prestamo = mock(Prestamo.class);
	    cliente = mock(Cliente.class);
	    when(prestamo.getCliente()).thenReturn(cliente);
	    when(cliente.getApellido()).thenReturn("angyPuta");
	    
	}
	//return (this.apellido.startsWith(p.getCliente().getApellido()));
	//angyPuta
	@Test
	public void testFiltrarPor() {
		assert(filtro.filtrarPor(prestamo));
	}

}
