package seguroDeVida;

import java.util.List;

import cuota.Cuota;

public class PromedioEnCuotas extends SeguroDeVida{

	public PromedioEnCuotas(float coeficiente) {
		super(coeficiente);
	}

	public float getCoeficiente(int i) {
		return this.coeficiente;
	}

	public void recibirSaldoAnterior(float saldoDeDeudaCuotaAnterior) {
		this.saldosConSeguroAplicado.add(saldoDeDeudaCuotaAnterior * this.coeficiente);
	}

	public float calcularSeguro(Cuota c) {
		float aux = 0;
		for (float f : this.saldosConSeguroAplicado) {
			aux += f;
		}
		return (aux/(this.saldosConSeguroAplicado.size()));
	}
	
	public List getSaldos(){
		return this.saldosConSeguroAplicado;
	}

}
