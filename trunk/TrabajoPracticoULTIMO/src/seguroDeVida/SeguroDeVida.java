package seguroDeVida;

import java.util.ArrayList;
import java.util.List;

public abstract class SeguroDeVida {

	protected float coeficiente;
	protected List<Float> saldosConSeguroAplicado;
	
	public SeguroDeVida(float coeficiente){
		this.coeficiente = coeficiente;
		this.saldosConSeguroAplicado = new ArrayList<Float>();
	}

	/**
	 * Agrega el saldo de deuda de todas las cuotas a una lista, para así poder calcular el monto de seguro de vida por cuota.
	 * @param saldoDeDeudaCuotaAnterior Saldo de deuda de la cuota anterior a la que llama este mensaje.
	 */
	public void recibirSaldoAnterior(float saldoDeDeudaCuotaAnterior) {
		this.saldosConSeguroAplicado.add(saldoDeDeudaCuotaAnterior * this.coeficiente);
	}
	
	/**
	 * Calcula el monto a pagar, dependiendo del tipo de seguro seleccionado.
	 */
	public void calcularSeguro() {
	}
	
	/**
	 * Retorna el valor de seguro a pagar, dependiendo de la cuota indicada.
	 * @param i id de cuota.
	 */
	public abstract float getPorCuota(int i);

	public float getCoef() {
		return this.coeficiente;
	}
}
