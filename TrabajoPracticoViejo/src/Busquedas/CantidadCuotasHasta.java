package Busquedas;

import model.Prestamo;

public class CantidadCuotasHasta extends Filtro {

	private int cuotas;
	
	public CantidadCuotasHasta (int cuotas) {
		this.cuotas = cuotas;
	}

	@Override
	public boolean filtrarPor(Prestamo p) {
		return (this.cuotas >= p.getCuotas().size());
	}

}
