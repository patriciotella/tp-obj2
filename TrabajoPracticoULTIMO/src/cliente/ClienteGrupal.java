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

	public void agregarCliente(Cliente c){
		this.clientes.add(c);
	}

	public void agregarPrestamo(Prestamo p) {
		this.prestamos.add(p);
		for (Cliente e : clientes) {
			e.agregarPrestamo(p);
		}
	}

	public void chequearCondicion() {
		int prestamosEnCurso= 0;
		for (Prestamo e : prestamos) {
			if(e.estaEnDeuda()){
				this.setEstadoASinPermiso();
				break;
			}
			if(e.estaEnCurso()){
				prestamosEnCurso++;
			}
		}
		if(prestamosEnCurso >= 2){
			this.setEstadoASinPermiso();
		}
	}
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}
	
	public String getApellidoClienteResponsable() {
		return this.clienteResponsable.getApellido();
	}
//	
//	public ClienteState getEstado() {
//		return this.clientes.get(1).getEstado();
//	}
	
	

}
