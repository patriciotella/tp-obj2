package configuracionGeneral;


public class GlobalesPorcentuales extends Globales{

	public GlobalesPorcentuales(float c){
		this.valor = c;
	}
	
	public float recotizarValor(float monto) {
		float aux = monto - (monto * this.valor);
		return aux;
	}

}
