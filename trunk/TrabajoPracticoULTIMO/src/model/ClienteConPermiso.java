package model;

public class ClienteConPermiso extends ClienteState {

	@Override
	public void solicitarPrestamo(Cliente c, Prestamo p) {
		c.agregarPrestamo(p);
	}

	@Override
	public boolean aptoParaPedirPrestamo() {
		return true;
	}
}
