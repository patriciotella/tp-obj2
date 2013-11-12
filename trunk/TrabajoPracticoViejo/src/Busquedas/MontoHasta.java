package Busquedas;

import model.Prestamo;

public class MontoHasta extends Filtro {

	private int monto;
	
	public MontoHasta(int monto) {
		this.monto = monto;
	}

	@Override
	public boolean filtrarPor(Prestamo p) {
		return (this.monto >= p.getMonto());
	}

}
