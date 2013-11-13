package Busquedas;


import model.Prestamo;

public class DniCliente extends Filtro {
	
	private int dni;
	
	public DniCliente(int dni) {
		this.dni = dni;
	}

	@Override
	public boolean filtrarPor(Prestamo p) {
		return (p.getCliente().getDni() == this.dni);
	}

}
