package cliente;

import prestamo.PagoInvalidoException;
import prestamo.Prestamo;

public abstract class ClienteState {
	
	/**
	 * En caso de poder hacerlo, solicita un pr�stamo p para un
	 * cliente c.
	 * @param c Cliente que solicita el pr�stamo.
	 * @param p Pr�stamo a solicitar.
	 * @throws PagoInvalidoException En caso de que el cliente
	 * sea SinPermiso.
	 */
	public abstract void solicitarPrestamo(Cliente c, Prestamo p) throws PagoInvalidoException;

	/**
	 * Retorna true en caso de que el cliente pueda pedir 
	 * un pr�stamo, false en caso contrario.
	 */
	public abstract boolean aptoParaPedirPrestamo();
}
