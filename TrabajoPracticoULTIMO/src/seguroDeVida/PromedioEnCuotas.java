package seguroDeVida;

import java.util.List;

import cuota.Cuota;

public class PromedioEnCuotas extends SeguroDeVida{
	private int cantCuotas;

	public PromedioEnCuotas(float coeficiente, int cuotas) {
		super(coeficiente);
		this.cantCuotas = cuotas;
	}

	public float getCoeficiente(int i) {
		return this.coeficiente;
	}

//	public void recibirSaldoAnterior(float saldoDeDeudaCuotaAnterior) {
//		this.saldosConSeguroAplicado.add(saldoDeDeudaCuotaAnterior * this.coeficiente);
//	}

	public float calcularSeguro(float saldoAnterior) {
//		float aux = 0;
//		for (float f : this.saldosConSeguroAplicado) {
//			aux += f;
//		}
//		return (aux/(this.saldosConSeguroAplicado.size()));
		return saldoAnterior
	}
	
	public List getSaldos(){
		return this.saldosConSeguroAplicado;
	}

}
