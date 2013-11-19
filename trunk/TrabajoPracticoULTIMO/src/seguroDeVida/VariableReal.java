package seguroDeVida;


public class VariableReal extends SeguroDeVida{

	public VariableReal(float coeficiente) {
		super(coeficiente);
	}

	@Override
	public void calcularSeguro() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public float getPorCuota(int i) {
		float ret = 0;
		int contador = 1;
		for (Float e: this.saldosConSeguroAplicado) {
			if(contador == i) ret = e;
			i++;
		}
		return ret;
	}
	
}
