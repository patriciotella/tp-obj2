package Busquedas;

import model.EstadoPrestamo;
import model.Prestamo;

public class EstadoDelPrestamo extends Filtro {
	
	private EstadoPrestamo estado;

	public boolean filtrarPor(Prestamo p) {
		return (this.estado.equals(p.getEstado()));
	}

}
