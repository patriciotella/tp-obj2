package model;

public class PromedioEnCuotas extends SeguroDeVida{

	public PromedioEnCuotas(float coeficiente) {
		super(coeficiente);
	}

	public float getCoeficiente(int i) {
		return this.coeficiente;
	}

	@Override
	public void recibirSaldoAnterior(float saldoDeDeudaCuotaAnterior) {
		this.saldosDeDeuda.add(saldoDeDeudaCuotaAnterior * this.coeficiente);
		
	}

	@Override
	public float calcularSeguro(Cuota c) {
		float aux = 0;
		for (float f : this.saldosDeDeuda) {
			aux += f;
		}
		return (aux/(this.saldosDeDeuda.size()));
	}

}
