package configuracionGeneral;


public class GlobalesValorFijo extends Globales{

	public GlobalesValorFijo(float c){
		this.valor = c;
	}
	
	public float recotizarValor(float monto) {
		float aux = monto - this.valor;
		return aux;
	}

}
