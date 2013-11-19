package Busquedas;

import model.Prestamo;

public class ApellidoCliente extends Filtro {
	
	private String apellido;

	public ApellidoCliente(String apellido) {
		super();
		this.apellido = apellido;
	}

	
	public boolean filtrarPor(Prestamo p) {
		return (this.apellido.startsWith(p.getCliente().getApellido()));
	}

}
