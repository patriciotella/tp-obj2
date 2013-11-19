package seguroDeVida;

import cuota.Cuota;

public class SinSeguro extends SeguroDeVida{

	public SinSeguro() {
		super((float) 0);
	}

	public float calcularSeguro(Cuota c) {
		return 0;
	}
	
	public void recibirSaldoAnterior(float saldoDeDeudaCuotaAnterior) {
		// No hace nada porque es innecesario que maneje los saldos.
	}

}
