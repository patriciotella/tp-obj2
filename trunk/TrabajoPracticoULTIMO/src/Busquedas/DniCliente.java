package Busquedas;


import model.Prestamo;

public class DniCliente extends Filtro {
	
	private String dni;
	
	public DniCliente(String dni) {
		this.dni = dni;
	}

	public boolean filtrarPor(Prestamo p) {
		return (p.getCliente().getDni() == this.dni);
	}

}
