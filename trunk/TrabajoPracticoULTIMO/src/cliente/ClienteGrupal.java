package cliente;

import java.util.ArrayList;
import java.util.List;

import prestamo.Prestamo;

public class ClienteGrupal extends Cliente {
	
	private List<String> apellidoIntegrantes;
	private List<String> dniIntegrantes;
	
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public ClienteGrupal(String nombre, String apellido, String dni, String domicilio) {
		super(nombre, apellido, dni, domicilio);
	}

	public String getApellido() {
		return this.apellido;
	}

	@Override
	public String getDni() {
		return this.dni;
	}

	@Override
	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	@Override
	public void chequearCondicion() {
		for (Cliente e : clientes) {
			e.chequearCondicion();
		}
		
	}
	
	

}
