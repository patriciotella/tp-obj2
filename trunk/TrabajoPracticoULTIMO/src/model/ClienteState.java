package model;

public abstract class ClienteState {
	
	public abstract void solicitarPrestamo(Cliente c, Prestamo p, Sistema s);

	public abstract boolean aptoParaPedirPrestamo();
}
