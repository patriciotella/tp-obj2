package prestamo;

import cuota.Cuota;

public abstract class EstadoPrestamo {
	
	/**
	 * En caso de ser posible,
	 * realiza el pago de la cuota del préstamo correspondiente.
	 * @param p Préstamo relacionado con la cuota a pagar.
	 * @param c Cuota a pagar.
	 * @throws PagoInvalidoException En caso de que no se pueda realizar el pago.
	 */
	abstract public void pagarCuota(Prestamo p, Cuota c) throws PagoInvalidoException;
	
	/**
	 * Retorna si el estado es EnDeuda.
	 */
	public boolean estaEnDeuda(){
		return false;
	}
	
	/**
	 * Retorna si el estado es EnCurso
	 */
	public boolean estaEnCurso(){
		return false;
	}


}
