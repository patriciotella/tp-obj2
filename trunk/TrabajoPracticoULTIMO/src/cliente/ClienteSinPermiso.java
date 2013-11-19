package cliente;

import prestamo.Prestamo;

public class ClienteSinPermiso extends ClienteState {

	@Override
	public void solicitarPrestamo(Cliente c, Prestamo p) {
		System.out.println("Usted no puede pedir ningun prestamo en este momento");
	}

	@Override
	public boolean aptoParaPedirPrestamo() {
		return false;
	}

}
