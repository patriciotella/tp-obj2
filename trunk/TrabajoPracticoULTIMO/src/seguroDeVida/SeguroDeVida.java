package seguroDeVida;

import java.util.ArrayList;
import java.util.List;

import cuota.Cuota;

public abstract class SeguroDeVida {

	protected float coeficiente;
	protected List<Float> saldosConSeguroAplicado;
	
	public SeguroDeVida(float coeficiente){
		this.coeficiente = coeficiente;
		this.saldosConSeguroAplicado = new ArrayList<Float>();
	}
	
	public abstract float calcularSeguro(Cuota c);
	
	public abstract void recibirSaldoAnterior(float saldoDeDeudaCuotaAnterior);
}
