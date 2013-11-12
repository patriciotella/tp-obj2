package model;

public class ClienteSinPermiso extends ClienteState {

	@Override
	public void solicitarPrestamo(Cliente c, int monto, int cuotas) {
		System.out.println("Usted no puede pedir ningun prestamo en este momento");
	}

}
