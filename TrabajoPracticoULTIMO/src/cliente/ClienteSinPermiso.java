package cliente;

import prestamo.PagoInvalidoException;
import prestamo.Prestamo;

public class ClienteSinPermiso extends ClienteState {

	public void solicitarPrestamo(Cliente c, Prestamo p) throws PagoInvalidoException {
		throw new PagoInvalidoException("No puede pagar cuotas, el préstamo todavía no fue aprobado");
	}

	public boolean aptoParaPedirPrestamo() {
		return false;
	}

}
