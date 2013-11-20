package seguroDeVida;

import java.util.List;

public class VariableReal extends SeguroDeVida{

	public VariableReal(float coeficiente) {
		super(coeficiente);
	}

	public float getPorCuota(int i) {
		float ret = 0;
		int contador = 1;
		for (Float e: this.saldosConSeguroAplicado) {
			if(contador == i) ret = e;
			contador++;
		}
		return ret;
	}
	
	@SuppressWarnings("rawtypes")
	public List getSaldos(){
		return this.saldosConSeguroAplicado;
	}
	
}
