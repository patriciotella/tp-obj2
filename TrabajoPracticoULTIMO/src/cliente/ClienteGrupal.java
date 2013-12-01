package cliente;

import java.util.ArrayList;
import java.util.List;

import prestamo.Prestamo;

public class ClienteGrupal extends Cliente {
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private Cliente clienteResponsable;

	public ClienteGrupal(Cliente clienteResponsable, String razonSocial, String dniClienteResponsable, String domicilio) {
		super("", razonSocial, dniClienteResponsable, domicilio);
		this.clientes.add(clienteResponsable);
		this.clienteResponsable = clienteResponsable;
	}

	/**
	 * Agrega a un cliente a su lista de clientes.
	 * @param c Cliente a agregar.
	 */
	public void agregarCliente(Cliente c){
		this.clientes.add(c);
	}

	public void agregarPrestamo(Prestamo p) {
		this.prestamos.add(p);
		for (Cliente e : clientes) {
			e.agregarPrestamo(p);
		}
	}
	
	/**
	 * Retorna la lista de clientes del grupo.
	 */
	public List<Cliente> getClientes() {
		return this.clientes;
	}
	
	/**
	 * Retorna el apellido del cliente responsable.
	 */
	public String getApellidoClienteResponsable() {
		return this.clienteResponsable.getApellido();
	}
}
