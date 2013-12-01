package configuracionGeneral;

public abstract class Gastos {

	/**
	 * Modifica el valor del monto pasado por par�metro,
	 * agreg�ndole los gastos correspndientes.
	 * @param monto Monto a recotizar.
	 */
	public abstract float recotizarValor(float monto);
	
	/**
	 * Retorna el valor del gasto.
	 */
	public abstract float getValor();

}
