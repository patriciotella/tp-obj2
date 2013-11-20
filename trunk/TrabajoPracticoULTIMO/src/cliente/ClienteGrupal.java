package cliente;

import java.util.ArrayList;
import java.util.List;

import prestamo.Prestamo;

public class ClienteGrupal extends Cliente {
	
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public ClienteGrupal(String nombre, String apellido, String dni, String domicilio) {
		super(nombre, apellido, dni, domicilio);
	}

	@Override
	public String getApellido() {
		for (Cliente e : clientes) {
			return e.getApellido();
		}
	}

	@Override
	public String getDni() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteState getEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestamo> getPrestamos() {
		// TODO Auto-generated method stub
		return null;
	}

}
