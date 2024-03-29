package Busquedas;


import model.Prestamo;

public class ApellidoCliente extends Filtro {
	
	private String apellido;

	public ApellidoCliente(String apellido) {
		super();
		this.apellido = apellido;
	}

	@Override
	public boolean filtrarPor(Prestamo p) {
		return (this.apellido.equals(p.getCliente().getApellido()));
	}

}
