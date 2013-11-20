package cliente;

import prestamo.Prestamo;

public abstract class ClienteState {
	
	public abstract void solicitarPrestamo(Cliente c, Prestamo p) throws Exception;

	public abstract boolean aptoParaPedirPrestamo();
}
