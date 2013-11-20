package seguroDeVida;

import java.util.List;

public class PromedioEnCuotas extends SeguroDeVida{
	
	private float porCuota;
	
	public PromedioEnCuotas(float coeficiente) {
		super(coeficiente);
	}

	public void calcularSeguro() {
		float aux = 0;
		for (float f : this.saldosConSeguroAplicado) {
			aux += f;
		}
		this.porCuota = (aux/(this.saldosConSeguroAplicado.size()));
	}
	
	public float getPorCuota(int i){
		return this.porCuota;
	}
	
	@SuppressWarnings("rawtypes")
	public List getSaldos(){
		return this.saldosConSeguroAplicado;
	}
}
