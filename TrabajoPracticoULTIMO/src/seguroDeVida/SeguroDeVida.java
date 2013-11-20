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
	
	public void recibirSaldoAnterior(float saldoDeDeudaCuotaAnterior) {
		this.saldosConSeguroAplicado.add(saldoDeDeudaCuotaAnterior * this.coeficiente);
	}
	
	public void calcularSeguro() {
	}
	
	public abstract float getPorCuota(int i);
}
