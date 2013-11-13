package model;

public class ClienteConPermiso extends ClienteState {

	@Override
	public void solicitarPrestamo(Cliente c, Prestamo p, Sistema s) {
		s.procesarPrestamo(c, p);
	}

	@Override
	public boolean aptoParaPedirPrestamo() {
		return true;
	}
}
