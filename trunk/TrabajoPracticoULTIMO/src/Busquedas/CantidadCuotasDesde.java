package Busquedas;

import model.Prestamo;

public class CantidadCuotasDesde extends Filtro {

	private int cuotas;
	
	public CantidadCuotasDesde(int cuotas) {
		this.cuotas = cuotas;
	}

	@Override
	public boolean filtrarPor(Prestamo p) {
		return (this.cuotas <= p.getCuotas().size());
	}

}
