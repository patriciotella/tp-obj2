package model;

public class ClienteConPermiso extends ClienteState {

	public void solicitarPrestamo(Cliente c, Prestamo p) {
		c.agregarPrestamo(p);
	}

	public boolean aptoParaPedirPrestamo() {
		return true;
	}
}
