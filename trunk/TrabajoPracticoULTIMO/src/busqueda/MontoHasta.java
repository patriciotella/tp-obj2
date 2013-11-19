package busqueda;

import prestamo.Prestamo;

public class MontoHasta extends Filtro {

	private int monto;
	
	public MontoHasta(int monto) {
		this.monto = monto;
	}

	public boolean filtrarPor(Prestamo p) {
		return (this.monto >= p.getMonto());
	}

}
