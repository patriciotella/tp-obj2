package cliente;

import prestamo.Prestamo;

public class ClienteSinPermiso extends ClienteState {

	public void solicitarPrestamo(Cliente c, Prestamo p) throws Exception {
		throw new Exception("No puede pagar cuotas, el pr�stamo todav�a no fue aprobado");
	}

	public boolean aptoParaPedirPrestamo() {
		return false;
	}

}
