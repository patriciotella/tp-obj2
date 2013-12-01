package cliente;

import prestamo.Prestamo;

public class ClienteConPermiso extends ClienteState {

	public void solicitarPrestamo(Cliente c, Prestamo p) {
		c.agregarPrestamo(p);
	}

	public boolean aptoParaPedirPrestamo() {
		return true;
	}
}
