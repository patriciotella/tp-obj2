package seguroDeVida;

public class SinSeguro extends SeguroDeVida{

	public SinSeguro() {
		super((float) 0);
	}

	public float getPorCuota(int i) {
		return 0;
	}
}
