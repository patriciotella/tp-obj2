package model;

public abstract class ClienteState {
	
	public abstract void solicitarPrestamo(Cliente c, Prestamo p);

	public abstract boolean aptoParaPedirPrestamo();
}
