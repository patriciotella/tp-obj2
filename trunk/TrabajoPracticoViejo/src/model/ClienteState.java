package model;

public abstract class ClienteState {
	
	public abstract void solicitarPrestamo(Cliente c, int monto, int cuotas);
}
