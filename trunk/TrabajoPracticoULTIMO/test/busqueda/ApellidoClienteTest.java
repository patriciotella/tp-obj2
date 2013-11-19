package busqueda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import busqueda.ApellidoCliente;
import cliente.Cliente;
import prestamo.Prestamo;
import static org.mockito.Mockito.*;

public class ApellidoClienteTest {

	Prestamo prestamo;
	Cliente cliente;
	Prestamo prestamo2;
	Cliente cliente2;
	ApellidoCliente filtro;
	
	@Before
	public void setUp() throws Exception {
		
		filtro = new ApellidoCliente("smith");
	    prestamo = mock(Prestamo.class);
	    cliente = mock(Cliente.class);
	    when(prestamo.getCliente()).thenReturn(cliente);
	    when(cliente.getApellido()).thenReturn("smith");
	    prestamo2 = mock(Prestamo.class);
	    cliente2 = mock(Cliente.class);
	    when(prestamo2.getCliente()).thenReturn(cliente2);
	    when(cliente2.getApellido()).thenReturn("conan");
	    
	}
	
	@Test
	public void testFiltrarPor() {
		assertTrue(filtro.filtrarPor(prestamo));
	}
	//Test para mostrar el caso en donde el filtro no se aplica para este prestamo.
	@Test
	public void testFalsoFiltrarPor() {
		assertFalse(filtro.filtrarPor(prestamo2));
	}

}
