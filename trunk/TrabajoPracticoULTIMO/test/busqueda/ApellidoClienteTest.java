package busqueda;

//import static org.junit.Assert.*;

import model.Cliente;
import model.Prestamo;

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
		
		filtro = new ApellidoCliente("smith");
	    prestamo = mock(Prestamo.class);
	    cliente = mock(Cliente.class);
	    when(prestamo.getCliente()).thenReturn(cliente);
	    when(cliente.getApellido()).thenReturn("smith");
	    
	}
	
	@Test
	public void testFiltrarPor() {
		assert(filtro.filtrarPor(prestamo));
	}

}
