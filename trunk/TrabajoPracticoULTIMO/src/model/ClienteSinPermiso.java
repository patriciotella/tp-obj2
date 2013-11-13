package model;

public class ClienteSinPermiso extends ClienteState {

	@Override
	public void solicitarPrestamo(Cliente c, Prestamo p, Sistema s) {
		System.out.println("Usted no puede pedir ningun prestamo en este momento");
	}

	@Override
	public boolean aptoParaPedirPrestamo() {
		return false;
	}

}
