package configuracionGeneral;

public abstract class Mensuales extends Gastos{
	
	protected float valor;

	public float getValor() {
		return valor;
	}

	public abstract float recotizarValor (float cuota);

}
