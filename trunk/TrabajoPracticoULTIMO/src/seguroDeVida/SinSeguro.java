package seguroDeVida;

import cuota.Cuota;

public class SinSeguro extends SeguroDeVida{

	public SinSeguro() {
		super((float) 0);
	}

	@Override
	public void calcularSeguro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getPorCuota(int i) {
		return 0;
	}

}
