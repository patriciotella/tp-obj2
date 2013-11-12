package Busquedas;

import model.Prestamo;

public class MontoDesde extends Filtro {

	private int monto;
	
	public MontoDesde(int monto) {
		this.monto = monto;
	}

	@Override
	public boolean filtrarPor(Prestamo p) {
		return (this.monto <= p.getMonto());
	}

}
