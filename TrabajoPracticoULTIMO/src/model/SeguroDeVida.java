package model;

import java.util.List;

public abstract class SeguroDeVida {

	protected float coeficiente;
	protected List saldosDeDeuda;
	
	public SeguroDeVida(float coeficiente){
		this.coeficiente = coeficiente;
	}
	
	public abstract float calcularSeguro(Cuota c);
	
	public abstract void recibirSaldoAnterior(float saldoDeDeudaCuotaAnterior);
}
