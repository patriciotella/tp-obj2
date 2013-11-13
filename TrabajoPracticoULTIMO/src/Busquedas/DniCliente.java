package Busquedas;


import model.Prestamo;

public class DniCliente extends Filtro {
	
	private int Dni;
	
	public DniCliente(int dni) {
		Dni = dni;
	}

	@Override
	public boolean filtrarPor(Prestamo p) {
		return (p.getCliente().getDni() == this.Dni);
	}

}
