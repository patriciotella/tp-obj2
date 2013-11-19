package gastos;


public class GlobalesValorFijo extends Globales{

	public GlobalesValorFijo(float c){
		this.coef = c;
	}
	
	public float recotizarValor(float monto) {
		float aux = monto - this.coef;
		return aux;
	}

}
